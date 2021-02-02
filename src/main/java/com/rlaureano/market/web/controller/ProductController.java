package com.rlaureano.market.web.controller;

import com.rlaureano.market.domain.Product;
import com.rlaureano.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Get all supermaket products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search product with an Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<Product> getByProductId(@ApiParam(value = "The id of the product", required = true,example = "7")
                                                      @PathVariable("id") int productId){
        return productService.getByProductId(productId).map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    @ApiOperation("Search product by categoryId ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<List<Product>> getByCategoryId(@PathVariable("id") int categoryId){
        return productService.getByCategoryId(categoryId).map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/scarse/{quantity}")
    @ApiOperation("Search product scarse ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    public Optional<List<Product>> getScarseProducts(@PathVariable("quantity") int quantity){
        return productService.getScarseProducts(quantity);
    }
    @PostMapping("/save")
    @ApiOperation("Save a new product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete a product by Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity delete(@PathVariable("id") int productId){
        if (productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
