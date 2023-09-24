package com.project.controller;

import com.project.entity.Category;
import com.project.entity.Product;
import com.project.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController
{

    ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }


    @RequestMapping("/ListProducts")
    public String listProducts(ModelMap modelMap, @RequestParam(name="page",defaultValue = "0") int page,
                               @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page<Product> products = productService.getAllProductsParPage(page, size);
        modelMap.addAttribute("products", products);
        modelMap.addAttribute("pages", new int[products.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);

        return "listProducts";
    }


    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap)
    {
        modelMap.addAttribute("product", new Product());
        List<Category> categories = productService.getAllCategories();
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("categories", categories);

        return "formProduct";
    }


    @RequestMapping("/saveProduct")
    public String saveProduct(Product product, BindingResult bindingResult,
                              @RequestParam (name="page",defaultValue = "0") int page,
                              @RequestParam (name="size", defaultValue = "2") int size)
    {
        int currentPage;
        boolean isNew = false;
        if (bindingResult.hasErrors()) return "formProduct";

        if(product.getIdProduct()==null) //add
            isNew=true;

        productService.createProduct(product);
        if (isNew) //add
        {
            Page<Product> prods = productService.getAllProductsParPage(page, size);
            currentPage = prods.getTotalPages()-1;
        }
        else //edit
            currentPage=page;


        //return "formProduct";
        return ("redirect:/ListProducts?page="+currentPage+"&size="+size);
    }


    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long id,
                                ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {

        productService.removeProductById(id);
        Page<Product> products = productService.getAllProductsParPage(page, size);
        modelMap.addAttribute("products", products);
        modelMap.addAttribute("pages", new int[products.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "listProducts";
    }


    @RequestMapping("/editProduct")
    public String editProduct(@RequestParam("id") Long id, ModelMap modelMap,
                              @RequestParam (name="page",defaultValue = "0") int page,
                              @RequestParam (name="size", defaultValue = "2") int size)
    {
        Product product = productService.getProduct(id);
        List<Category> cats = productService.getAllCategories();
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("product", product);
        modelMap.addAttribute("categories", cats);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);

        return "formProduct";
    }



    @RequestMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") Product product, @RequestParam("date") String date,
                                ModelMap modelMap) throws ParseException
    {
        // date conversion
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date creationDate = dateformat.parse(String.valueOf(date));
        product.setCreationDate(creationDate);

        productService.updateProduct(product);
        List<Product> products = productService.getAllProducts();
        modelMap.addAttribute("products", products);

        return "listProducts";
    }

}