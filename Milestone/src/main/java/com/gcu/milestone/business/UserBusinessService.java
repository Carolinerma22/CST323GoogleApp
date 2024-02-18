package com.gcu.milestone.business;

import com.gcu.milestone.data.UserDataService;
import com.gcu.milestone.entity.UserEntity;
import com.gcu.milestone.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBusinessService implements UserBusinessServiceInterface, UserDetailsService 
{
    @Autowired
    private UserDataService service;

    @Override
    public void init()
    {

    }

    @Override
    public void newUser(UserModel user)
    {
        UserEntity userEntity = new UserEntity(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword())
        );

        System.out.println("Creating User");

        if(service.create(userEntity))
        {
            System.out.println("User created");
        }
        else
        {
            System.err.println("User creation failed.");
        }

    }

    @Override
    public List<UserModel> getUsers()
    {
        List<UserEntity> usersEntity = service.findAll();

        var usersDomain = new ArrayList<UserModel>();
        for(UserEntity entity : usersEntity)
        {
            usersDomain.add(
                    new UserModel(
                            entity.getId(),
                            entity.getFirstName(),
                            entity.getLastName(),
                            entity.getEmail(),
                            entity.getPhone(),
                            entity.getUsername(),
                            entity.getPassword()
                    )
            );
        }

        return usersDomain;
    }

    @Override
    public UserModel getUserById(int id)
    {
        return null;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Your user is " + username);
		
		UserEntity user = service.findByUsername(username);
		if (user != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			System.out.println("user is " +user.getUsername() + " password is " + user.getPassword());
			return new User(user.getUsername(), user.getPassword(), authorities);
		} else {
			throw new UsernameNotFoundException("Username not Found!");
		}
	}
}
