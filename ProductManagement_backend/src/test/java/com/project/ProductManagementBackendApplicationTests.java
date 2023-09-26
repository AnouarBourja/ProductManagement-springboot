package com.project;

import com.project.entity.Product;
import com.project.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProductManagementBackendApplicationTests
{
    @Test
    void contextLoads() {
    }

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct()
    {
        Product product = new Product("PC Asus",1500.500, new Date());
        productRepository.save(product);
    }

    @Test
    public void testFindProduct()
    {
        Product product = productRepository.findById(63L).get();
        System.out.println(product);
    }

    @Test
    public void testUpdateProduct()
    {
        Product product = productRepository.findById(1L).get();
        product.setPriceProduct(2000.0);
        productRepository.save(product);

        System.out.println(product);
    }

    @Test
    public void testDeleteProduct()
    {
        productRepository.deleteById(1L);
    }

    @Test
    public void testFindAllProducts()
    {
        List<Product> products = productRepository.findAll();

        for (Product product:products)
            System.out.println(product);

    }


}