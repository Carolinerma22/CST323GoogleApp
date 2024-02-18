package com.gcu.milestone.controller.api;


import com.gcu.milestone.business.ProductBusinessService;
import com.gcu.milestone.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ProductsRestController
{

    @Autowired
    private ProductBusinessService productBusinessService;

    @GetMapping(value = "/getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductModel> getAllProducts()
    {
        return productBusinessService.getProducts();
    }

    @GetMapping(value = "/getProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductModel getProduct(@RequestParam long id)
    {
        return productBusinessService.getProduct(id);
    }

}
