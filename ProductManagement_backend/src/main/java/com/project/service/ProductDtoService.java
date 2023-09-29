package com.project.service;

import com.project.dto.ProductDto;
import com.project.entity.Category;
import com.project.entity.Product;

import java.util.List;

public interface ProductDtoService
{
    ProductDto saveProduct(ProductDto p);
    ProductDto updateProduct(ProductDto p);

    ProductDto getProduct(Long id);
    List<ProductDto> getAllProducts();


    void deleteProduct(Product p);
    void deleteProductById(Long id);


    List<Product> findByNameProduct(String nom);
    List<Product> findByNameProductContains(String nom);
    List<Product> findByNamePrice(String nom, Double prix);
    List<Product> findByCategory(Category category);
    List<Product> findByCategoryIdCategory(Long id);
    List<Product> findByOrderByNameProductAsc();
    List<Product> sortProductsNamePrice();


    ProductDto convertEntityToDto(Product p);
    Product convertDtoToEntity(ProductDto productDto);

}
