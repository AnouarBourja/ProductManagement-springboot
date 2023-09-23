package com.project.service.impl;

import com.project.entity.Category;
import com.project.entity.Product;
import com.project.repository.CategoryRepository;
import com.project.repository.ProductRepository;
import com.project.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    ProductRepository productRepository;

    CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProduct(Long idProduct)
    {
        Product product = productRepository.findById(idProduct).get();
        return product;
    }

    @Override
    public List<Product> getAllProducts()
    {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product createProduct(Product product)
    {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product)
    {
        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    @Override
    public void removeProductById(Long idProduct)
    {
        productRepository.deleteById(idProduct);
    }

    @Override
    public void removeProduct(Product product)
    {
        productRepository.delete(product);
    }

    @Override
    public Page<Product> getAllProductsParPage(int page, int size)
    {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> findByNameProduct(String name)
    {
        return productRepository.findByNameProduct(name);
    }

    @Override
    public List<Product> findByNameProductContains(String name)
    {
        return productRepository.findByNameProductContains(name);
    }

    @Override
    public List<Product> findByNamePrice(String name, Double price)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> findByCategory(Category category)
    {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findByCategoryIdCategory(Long id)
    {
        return productRepository.findByCategoryIdCategory(id);
    }

    @Override
    public List<Product> findByOrderByNameProductAsc()
    {
        return productRepository.findByOrderByNameProductAsc();
    }

    @Override
    public List<Product> sortProductsNamePrice()
    {
        return productRepository.sortProductsNamePrice();
    }

}
