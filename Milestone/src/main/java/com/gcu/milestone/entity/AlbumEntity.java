package com.gcu.milestone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALBUMS")
public class AlbumEntity {
	
	public AlbumEntity()
	{

	}
	
	public AlbumEntity(long id, String albumTitle, String artist, String year, String imagePath, String description, int genreID, Double price) {
		this.id = id;
		this.albumTitle = albumTitle;
		this.artist = artist;
		this.year = year;
		this.imagePath = imagePath;
		this.description = description;
		this.genreID = genreID;
		this.price = price;

	}
	
	@Override
	public String toString() {
		return "AlbumEntity [id=" + id + ", albumTitle=" + albumTitle + ", artist=" + artist + ", year=" + year
				+ ", imagePath=" + imagePath + ", description=" + description + ", genreID=" + genreID + ", price="
				+ price + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "album_title")
	String albumTitle;
	
	@Column(name = "artist")
	String artist;
	
	@Column(name = "year")
	String year;
	
	@Column(name = "image_path")
	String imagePath;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "genre_ID")
	int genreID;
	
	@Column(name = "price")
	Double price;

	public String getAlbumTitle() {
		return albumTitle;
	}
	
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getGenreID() {
		return genreID;
	}
	
	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
}