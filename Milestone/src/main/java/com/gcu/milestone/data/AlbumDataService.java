package com.gcu.milestone.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.milestone.data.repository.AlbumsRepository;
import com.gcu.milestone.entity.AlbumEntity;

@Service
public class AlbumDataService implements DataAccessInterface<AlbumEntity>
{

	@Autowired
	private AlbumsRepository albumsRepository;
	
	//Non-Default constructor for constructor injection
	public AlbumDataService(AlbumsRepository albumsRepository) {
		this.albumsRepository = albumsRepository;
	}
	
	// CRUD: finder to return a single entity
	public AlbumEntity findById(Long id) {
		Optional<AlbumEntity> albumEntityOptional = Optional.of(new AlbumEntity());
		try {
			albumEntityOptional = albumsRepository.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println(albumEntityOptional.get().getId());
        return albumEntityOptional.orElse(null);

	}
	
	// CRUD: Finder to return all entities
	
	public List<AlbumEntity> findAll(){
		List<AlbumEntity> albums = new ArrayList<AlbumEntity>();
		try {
			// Execute SQL Query and loop over result set
			Iterable<AlbumEntity> albumsIterable = albumsRepository.findAll();
			
			//Convert to a list and return the list
			albumsIterable.forEach(albums::add);
		} catch (Exception e){
			e.printStackTrace();
		}
		return albums;
	}
	
	
	// CRUD: create an entity
	public boolean create(AlbumEntity album) {
		try {
			this.albumsRepository.save(album);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	public boolean update(AlbumEntity t) {
		try {
			this.albumsRepository.save(t);
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteByID(Long id) {
		
		try {
			this.albumsRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
