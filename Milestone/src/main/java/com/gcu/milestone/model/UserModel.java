package com.gcu.milestone.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;


public class UserModel
{

    @Override
	public String toString() {
		return "UserModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", username=" + username + ", password=" + password + "]";
	}

	private long id;

	//Error message for firstName
	@NotBlank(message = "First name must not be blank")
    private String firstName;

	//Error message for lastName
    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    //Error message for email
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email address")
    private String email;

    //Error message for phone
    @NotBlank(message = "Phone must not be blank")
    private String phone;

    //Error message for username
    @NotBlank(message = "Username must not be blank")
    private String username;

    //Error message for password
    @NotBlank(message = "Password must not be blank")
    @Size(min = 8)
    private String password;

    public UserModel() {

    }

    public UserModel(long id, String firstName, String lastName, String email, String phone, String username, String password)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }


    //Getters and Setters
    public long getId()
    {
        return id;
    }

    public void setId(long id) {
		this.id = id;
	}

	public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
    
    public void setFirstName(String firstName) 
    {
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
    	this.lastName = lastName;
    }
    
    public void setEmail(String email) 
    {
    	this.email = email;
    }
    
    public void setPhone(String phone) 
    {
    	this.phone = phone;
    }
    
    public void setUsername(String username) 
    {
    	this.username = username;
    }
    
    public void setPassword(String password) 
    {
    	this.password = password;
    }
}
