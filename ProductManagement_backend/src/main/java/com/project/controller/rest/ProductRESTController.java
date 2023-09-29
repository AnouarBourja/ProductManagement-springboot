package com.project.controller.rest;

import com.project.dto.ProductDto;
import com.project.entity.Product;
import com.project.service.ProductDtoService;
import com.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductRESTController
{
    @Autowired
    private ProductDtoService productDtoService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDto> getAllProducts()
    {
        return productDtoService.getAllProducts();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ProductDto getProductById(@PathVariable("id") Long id)
    {
        return productDtoService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto productDto)
    {
        return productDtoService.saveProduct(productDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ProductDto updateProduct(@RequestBody ProductDto productDto)
    {
        return productDtoService.updateProduct(productDto);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") Long id)
    {
        productDtoService.deleteProductById(id);
    }

    @RequestMapping(value="/prodscat/{idCategory}",method = RequestMethod.GET)
    public List<Product> getProductsByCategoryId(@PathVariable("idCategory") Long idCategory)
    {
        return productDtoService.findByCategoryIdCategory(idCategory);
    }


}