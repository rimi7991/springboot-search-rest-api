package net.javaguides.springbootsearchrestapi.service.impl;

import net.javaguides.springbootsearchrestapi.entity.Product;
import net.javaguides.springbootsearchrestapi.repository.ProductRepository;
import net.javaguides.springbootsearchrestapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        System.out.println("Test Search Products");
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println("Create Products");
        return productRepository.save(product);
    }
}
