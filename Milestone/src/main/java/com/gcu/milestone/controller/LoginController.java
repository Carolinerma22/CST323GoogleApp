package com.gcu.milestone.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.milestone.business.ProductBusinessServiceInterface;
import com.gcu.milestone.model.LoginModel;
import com.gcu.milestone.model.ProductModel;
import com.gcu.milestone.model.UserModel;
import jakarta.validation.Valid;

@Controller
public class LoginController 
{

	private final LoginModel loginModel;
    
    @Autowired
    public LoginController(LoginModel loginModel)
    {
        this.loginModel = loginModel;
    }

	//Return login page
	@GetMapping({"/login"})
	public String displayLogin(Model model) 
	{

		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", loginModel);
		
		return "login";
	}
}