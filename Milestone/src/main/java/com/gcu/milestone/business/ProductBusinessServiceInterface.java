package com.gcu.milestone.business;

import java.util.List;
import com.gcu.milestone.model.ProductModel;
import org.springframework.stereotype.Service;


public interface ProductBusinessServiceInterface 
{
	//id, Artist, AlbumTitle, Year, ImagePath, Description, GenreID, Price, Sale Price

	public List<ProductModel> getProducts();

	public void init();
	public ProductModel getProduct(long id);
	public void addProduct(ProductModel product);
	public void deleteProduct(long id);
	public void editProduct(ProductModel product);
}
