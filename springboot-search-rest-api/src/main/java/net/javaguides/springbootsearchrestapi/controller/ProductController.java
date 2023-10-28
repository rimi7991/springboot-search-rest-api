package net.javaguides.springbootsearchrestapi.controller;


import net.javaguides.springbootsearchrestapi.entity.Product;
import net.javaguides.springbootsearchrestapi.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //http://localhost:8080/api/v1/products/search?query=keyboard
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query)
    {
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    //http://localhost:8080/api/v1/products
    /*
    //Body
     {
    "sku" : "ABC",
    "name" : "keyboard",
    "description" : "keyboard description",
    "active" : true,
    "imageURL" : "keyboard.png"
    }
    */
    @PostMapping
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }
}
