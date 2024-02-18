package com.gcu.milestone.controller;


import com.gcu.milestone.business.UserBusinessService;
import com.gcu.milestone.business.UserBusinessServiceInterface;
import com.gcu.milestone.model.LoginModel;
import com.gcu.milestone.model.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController
{
    @Autowired
    private UserBusinessService service;

    private final UserModel userModel;
    private final LoginModel loginModel;

    @Autowired
    public RegisterController(UserModel userModel, LoginModel loginModel)
    {
        this.userModel = userModel;
        this.loginModel = loginModel;
    }

    @GetMapping("")
    public String displayRegister(Model model)
    {
        model.addAttribute("title", "Register Form");
        model.addAttribute("userModel", userModel);

        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("title", "Register Form");
            return "register";
        }

        try
        {
        	System.out.println(userModel.toString());
            service.newUser(userModel);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", loginModel);

        return "login";
    }
}
