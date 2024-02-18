package com.gcu.milestone.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.gcu.milestone.data.AlbumDataService;
import com.gcu.milestone.entity.AlbumEntity;
import com.gcu.milestone.model.ProductModel;
import org.springframework.stereotype.Service;

@Service
public class ProductBusinessService implements ProductBusinessServiceInterface
{
	
	@Autowired
	AlbumDataService service;
	
	//List of products/albums
	private List<ProductModel> products = new ArrayList<ProductModel>();

	//Manually add album objects - these will now come from database
	@Override
	public void init()
	{
        // AlbumTitle, Artist, Year, ImagePath, Description, Price, Quantity
        //products.add(new ProductModel("SHIFT!", "EXOCIETY", "2023", "https://f4.bcbits.com/img/a1085268388_16.jpg", "crossing wires til we cut free, exociety’s back", 30.00, 10));
        //products.add(new ProductModel("The Lion King: The Gift", "Beyonce", "2019", "https://upload.wikimedia.org/wikipedia/en/1/11/The_Lion_King_The_Gift.png", "It's aight", 30.00, 10));
        //products.add(new ProductModel("Stick Season", "Noah Kahan", "2022", "https://upload.wikimedia.org/wikipedia/en/1/13/Noah_Kahan_-_Stick_Season.png", "Owen says it good", 30.00, 10));
        //products.add(new ProductModel("Mm..Food", "MF Doom", "2004", "https://upload.wikimedia.org/wikipedia/en/8/8a/Mmfood.jpg", "2004 is old I guess??", 30.00, 10));	
	}

		
	//Add a new album/product
	@Override
	public void addProduct(ProductModel product) {
	    AlbumEntity albumEntity = new AlbumEntity(
	        product.getID(),
	        product.getTitle(),
	        product.getArtist(),
	        product.getYear(),
	        product.getImagePath(),
	        product.getDescription(),
	        product.getGenreID(),
	        product.getPrice()
	    );

	    if (service.create(albumEntity)) {
	        System.out.println("Album created successfully!");
	    } else {
	        System.err.println("Failed to create the album. Please check your input or database connection.");
	    }
	}

	
	//implementation of the getAlbums method specified in the interface
	@Override
	public List<ProductModel> getProducts(){
		//Get all the Entity Albums
		var albums = new ArrayList<ProductModel>();
		
		// Iterate over the entity albums and create a list of albums
		List<AlbumEntity> albumsEntity = service.findAll();
		
		for(AlbumEntity entity : albumsEntity) {
			System.out.println(entity.toString());
			albums.add(new ProductModel(entity.getId(),
										entity.getAlbumTitle(),
										entity.getArtist(),
										entity.getYear(),
										entity.getImagePath(),
										entity.getDescription(),
										entity.getGenreID(),
										entity.getPrice()));
		}
		
		// Return list of Albums
		return albums;
	}


	@Override
	public void deleteProduct(long id) {
			if (service.deleteByID(id)) {
	            System.out.println("Album deleted successfully!");
	        } else {
	            System.err.println("Failed to create the album. Please check your input or database connection.");
	        }
	}


	@Override
	public void editProduct(ProductModel product) {
	    AlbumEntity albumEntity = new AlbumEntity(
		        product.getID(),
		        product.getTitle(),
		        product.getArtist(),
		        product.getYear(),
		        product.getImagePath(),
		        product.getDescription(),
		        product.getGenreID(),
		        product.getPrice()
	        );

			System.out.println(albumEntity.getId());
	        if (service.update(albumEntity)) {
	            System.out.println("Album edited successfully!");
	        } else {
	            System.err.println("Failed to create the album. Please check your input or database connection.");
	        }
	}

	@Override
	public ProductModel getProduct(long id)
	{
		AlbumEntity entity = service.findById(id);
		return new ProductModel(
				entity.getId(),
				entity.getAlbumTitle(),
				entity.getArtist(),
				entity.getYear(),
				entity.getImagePath(),
				entity.getDescription(),
				entity.getGenreID(),
				entity.getPrice()
		);
	}
}

