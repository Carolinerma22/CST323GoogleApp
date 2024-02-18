package com.gcu.milestone.business;

import com.gcu.milestone.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserBusinessServiceInterface
{
    public void init();

    void newUser(UserModel user);

    public List<UserModel> getUsers();

    public UserModel getUserById(int id);


}
