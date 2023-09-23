package com.project.service;

import com.project.entity.Category;
import com.project.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService
{

    public Product getProduct(Long idProduct);

    public List<Product> getAllProducts();

    Page<Product> getAllProductsParPage(int page, int size);

    List<Category> getAllCategories();

    List<Product> findByNameProduct(String name);

    List<Product> findByNameProductContains(String name);

    List<Product> findByNamePrice (String name, Double price);

    List<Product> findByCategory (Category category);

    List<Product> findByCategoryIdCategory(Long id);

    List<Product> findByOrderByNameProductAsc();

    List<Product> sortProductsNamePrice();

    public Product createProduct(Product product);

    public Product updateProduct(Product product);

    public void removeProductById(Long idProduct);

    public void removeProduct(Product product);


}
