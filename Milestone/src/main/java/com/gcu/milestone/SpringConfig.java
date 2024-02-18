package com.gcu.milestone;

import com.gcu.milestone.business.UserBusinessService;
import com.gcu.milestone.business.UserBusinessServiceInterface;
import com.gcu.milestone.model.ProductModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.milestone.business.ProductBusinessService;
import com.gcu.milestone.business.ProductBusinessServiceInterface;
import com.gcu.milestone.model.LoginModel;
import com.gcu.milestone.model.UserModel;

@Configuration
public class SpringConfig
{
	//Login
    @Bean
    public LoginModel loginModel() 
    {
        return new LoginModel();
    }

    
    //User
    @Bean
    public UserModel userModel() 
    {
        return new UserModel(0,null, null, null, null, null, null);
    }

    
    //Product
    @Bean
    public ProductModel productModel() 
    { 
    	return new ProductModel(0, null, null, null, null, null, 0, 0); 
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
