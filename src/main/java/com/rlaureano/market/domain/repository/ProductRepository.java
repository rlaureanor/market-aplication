package com.rlaureano.market.domain.repository;

import com.rlaureano.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategoryId(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getByProductId(int productId);
    Product save(Product product);
    void delete(int productId);
}
