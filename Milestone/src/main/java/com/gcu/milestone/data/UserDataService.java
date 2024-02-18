package com.gcu.milestone.data;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.milestone.data.repository.UsersRepository;
import com.gcu.milestone.entity.UserEntity;

@Service
public class UserDataService implements DataAccessInterface<UserEntity>, UsersDataAccessInterface<UserEntity>
{
    @Autowired
    private UsersRepository usersRepository;

    public UserDataService(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }

    public List<UserEntity> findAll()
    {
        List<UserEntity> users = new ArrayList<UserEntity>();
        try {
            // Execute SQL Query and loop over result set
            Iterable<UserEntity> usersIterable = usersRepository.findAll();

            //Convert to a list and return the list
            usersIterable.forEach(users::add);
        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserEntity findById(Long id)
    {
        return null;
    }

    public boolean create(UserEntity user) {
        try {
            this.usersRepository.save(user);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(UserEntity userEntity)
    {
        return false;
    }

    @Override
    public boolean deleteByID(Long id)
    {
        return false;
    }

	public UserEntity findByUsername(String username) {
		return usersRepository.findByUsername(username);
	}
}
