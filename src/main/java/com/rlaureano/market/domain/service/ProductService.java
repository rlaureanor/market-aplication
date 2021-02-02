package com.rlaureano.market.domain.service;

import com.rlaureano.market.domain.Product;
import com.rlaureano.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getByProductId(int productId){
        return productRepository.getByProductId(productId);
    }

    public Optional<List<Product>> getByCategoryId(int categoryId){
        return productRepository.getByCategoryId(categoryId);
    }
    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }
    public boolean delete(int productId){
        return productRepository.getByProductId(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }


}
