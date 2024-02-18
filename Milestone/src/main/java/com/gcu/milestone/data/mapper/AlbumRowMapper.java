package com.gcu.milestone.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.milestone.entity.AlbumEntity;

public class AlbumRowMapper implements RowMapper<AlbumEntity> {
	@Override
	public AlbumEntity mapRow(ResultSet rs, int rowNumber) throws SQLException{
		return new AlbumEntity(rs.getLong("id"),
								rs.getString("album_title"), 
								rs.getString("artist"), 
								rs.getString("year"),
								rs.getString("imagePath"), 
								rs.getString("description"), 
								rs.getInt("genre_ID"), 
								rs.getDouble("price")
							  ); 
	}

}