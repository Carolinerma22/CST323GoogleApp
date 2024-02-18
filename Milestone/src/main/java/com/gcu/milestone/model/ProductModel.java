package com.gcu.milestone.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductModel
{
	public ProductModel() {
		
	}
	
	//Constructor
    public ProductModel(long id, String title, String artist, String year, String imagePath, String description, int genreID, double price)
    {
    	this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.imagePath = imagePath;
        this.description = description;
        this.genreID = genreID;
        this.price = price;
    }

    @Override
	public String toString() {
		return "ProductModel [id=" + id + ", title=" + title + ", artist=" + artist + ", year=" + year + ", imagePath="
				+ imagePath + ", description=" + description + ", genreID=" + genreID + ", price=" + price
				+ ", salePrice=" +  "]";
	}

    @NotNull
	private long id;
    
    //Error message for title
    @NotBlank(message = "Album title cannot be blank")
    private String title;

    //Error message for artist
    @NotBlank(message = "Artist cannot be blank")
    private String artist;

    //Error message for year
    @NotBlank(message = "Year cannot be blank")
    private String year;

    //Error message for imagePath
    @NotBlank(message = "Image path cannot be blank")
    private String imagePath;

    //Error message for description
    @NotBlank(message = "Description cannot be blank")
    private String description;
    
    //Error message for genre
    @Min(message="Genre must be selected!", value = 0)
    private int genreID;

    //Error message for price
    @NotNull(message = "Price cannot be null")
    private double price;
    
    //Getters and Setters
    public long getID()
    {
    	return id;
    }
    
    public void setID(long id)
    {
    	this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getGenreID()
    {
    	return genreID;
    }
    
    public void setGenreID(int genreID)
    {
    	this.genreID = genreID;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

}