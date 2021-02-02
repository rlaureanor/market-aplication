package com.rlaureano.market.persistence;

import com.rlaureano.market.domain.Product;
import com.rlaureano.market.domain.repository.ProductRepository;
import com.rlaureano.market.persistence.crud.ProductoCrudRepositoy;
import com.rlaureano.market.persistence.entity.Producto;
import com.rlaureano.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepositoy productoCrudRepositoy;

    @Autowired
    private ProductMapper mapperProduct;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>)productoCrudRepositoy.findAll();
        return mapperProduct.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategoryId(int categoryId) {
        List<Producto> productos = productoCrudRepositoy.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapperProduct.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepositoy.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods->mapperProduct.toProducts(prods));
    }

    @Override
    public Optional<Product> getByProductId(int productId) {
        return productoCrudRepositoy.findById(productId).map(producto -> mapperProduct.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto=mapperProduct.toProducto(product);
        return mapperProduct.toProduct(productoCrudRepositoy.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepositoy.deleteById(productId);
    }

}
