package com.gcu.milestone.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.milestone.entity.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity>
{
    @Override
    public UserEntity mapRow(ResultSet rs, int rowNumber) throws SQLException
    {
        return new UserEntity(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("phone_number")
        );
    }
}
