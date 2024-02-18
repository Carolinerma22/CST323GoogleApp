package com.gcu.milestone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.milestone.business.ProductBusinessServiceInterface;
import com.gcu.milestone.model.LoginModel;
import com.gcu.milestone.model.ProductModel;

@Controller
@RequestMapping({"/home"})
public class IndexController 
{
    
    //Initial page shown - return index.html
	@GetMapping({""})
	public String displayIndex(Model model) 
	{
		
		return "index";
	}
	
}
