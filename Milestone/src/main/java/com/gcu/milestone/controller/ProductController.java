package com.gcu.milestone.controller;

import com.gcu.milestone.business.ProductBusinessServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcu.milestone.model.LoginModel;
import com.gcu.milestone.model.ProductModel;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/products"})
public class ProductController
{

	@Autowired
	private ProductBusinessServiceInterface service;

    private final ProductModel productModel;
    private final LoginModel loginModel;

    @Autowired
    public ProductController(ProductModel productModel, LoginModel loginModel)
    {
        this.productModel = productModel;
        this.loginModel = loginModel;
    }

    @GetMapping("/display")
    public String displayProducts(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        return "validatedIndex";
    }

    @GetMapping("/createProduct")
    public String displayCreateProduct(Model model)
    {
        model.addAttribute("title", "Create Product");
        model.addAttribute("productModel", productModel);

        return "newproduct";
    }
    
    @GetMapping("/inventory")
    public String displayAlbums(Model model)
    {
        model.addAttribute("title", "Product Inventory");
        model.addAttribute("productModel", productModel);
        
        List<ProductModel> products = service.getProducts();
        model.addAttribute("products", products);

        return "albums";
    }

    @GetMapping("/reservations")
    public String reserveAlbums(Model model)
    {
    	model.addAttribute("title", "Album Reservation");
    	model.addAttribute("productModel", productModel);
    	
    	List<ProductModel> products = service.getProducts();
    	model.addAttribute("products", products);
    	
    	return "reserve";
    }

    @PostMapping("/newProduct")
    public String newProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("title", "Create Product");
            model.addAttribute("error", "Validation errors. Please check your input.");
            return "newproduct";
        }

     try {
		
    	 
    	 System.out.println(productModel.toString());
        //Add new album/product
        service.addProduct(productModel);

        List<ProductModel> products = service.getProducts();

        model.addAttribute("products", products);

        return "validatedIndex";
        
    } catch (Exception e) {
        // Log the exception or print to console for debugging
        e.printStackTrace();
        // Add an attribute to indicate that there was an error
        model.addAttribute("error", "Failed to create the product. Please check your input or database connection.");
        // Return to the form with the error message
        return "newproduct";
    }
    }
    
    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Long id, Model model) {
        
        service.deleteProduct(id);

        List<ProductModel> products = service.getProducts();
        model.addAttribute("products", products);

        return "albums"; // Redirect to the product inventory page or any other appropriate page
    }

    @GetMapping({"/editProduct"})
    public String displayEditProduct(@RequestParam Long id, Model model)
    {
        ProductModel product = service.getProduct(id);
        model.addAttribute("title", "Edit Product");
        model.addAttribute("productModel", product);

        return "editproduct";
    }

    @PostMapping({"/updateProduct"})
    public String updateProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("title", "Edit Product");
            model.addAttribute("error", "Validation errors. Please check your input.");

            return "editproduct";
        }

        try {
            System.out.println(productModel.toString());

            //Add new album/product
            service.editProduct(productModel);

            List<ProductModel> products = service.getProducts();

            model.addAttribute("products", products);

            return "albums";

        } catch (Exception e) {
            // Log the exception or print to console for debugging
            e.printStackTrace();
            // Add an attribute to indicate that there was an error
            model.addAttribute("error", "Failed to create the product. Please check your input or database connection.");
            // Return to the form with the error message
            return "editproduct";
        }
    }


    @GetMapping({"/album"})
    public String viewAlbum(@RequestParam long id, Model model)
    {
        ProductModel product = service.getProduct(id);
        model.addAttribute("title", product.getTitle());
        model.addAttribute("product", product);

        return "album";
    }
}
