package com.project.service.impl;

import com.project.dto.ProductDto;
import com.project.entity.Category;
import com.project.entity.Product;
import com.project.repository.ProductRepository;
import com.project.service.ProductDtoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDtoServiceImpl implements ProductDtoService
{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductDto saveProduct(ProductDto p)
    {
        return convertEntityToDto(productRepository.save(convertDtoToEntity(p)));

    }

    @Override
    public ProductDto updateProduct(ProductDto p)
    {
        return convertEntityToDto(productRepository.save(convertDtoToEntity(p)) );

    }

    @Override
    public void deleteProduct(Product p)
    {
        productRepository.delete(p);

    }

    @Override
    public void deleteProductById(Long id)
    {
        productRepository.deleteById(id);

    }

    @Override
    public ProductDto getProduct(Long id)
    {
        return   convertEntityToDto(productRepository.findById(id).get());

    }

    @Override
    public List<ProductDto> getAllProducts()
    {
        return productRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

		/*List<Product> prods = productRepository.findAll();
		List<ProductDTO> listprodDto = new ArrayList<>(prods.size());
		for (Product p : prods)
			listprodDto.add(convertEntityToDto(p));
		return listprodDto;*/

    }

    @Override
    public List<Product> findByNameProduct(String nom)
    {
        return productRepository.findByNameProduct(nom);
    }

    @Override
    public List<Product> findByNameProductContains(String nom)
    {
        return productRepository.findByNameProductContains(nom);
    }

    @Override
    public List<Product> findByNamePrice(String nom, Double prix)
    {
        return productRepository.findByNamePrice(nom, prix);
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

    @Override
    public ProductDto convertEntityToDto(Product product)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProductDto productDTO=  modelMapper.map(product, ProductDto.class);

        return productDTO;

		/*ProductDto productDTO = new ProductDto();

		productDTO.setIdProduct(p.getIdProduct());
		productDTO.setNameProduct(p.getNameProduct());
		productDTO.setPriceProduct(p.getPriceProduct());
		productDTO.setCreationDate(p.getCreationDate());
		productDTO.setCategory(p.getCategory());

		return productDTO;*/

	/*	return ProductDto.builder()
				.idProduct(p.getIdProduct())
				.nameProduct(p.getNameProduct())
				//.priceProduct(p.getPriceProduct())
				.dateCreation(p.getCreationDate())
				//.nameCategory(p.getCategory().getNameCategory())
				.category(p.getCategory())
				.build();*/

    }

    @Override
    public Product convertDtoToEntity(ProductDto productDto)
    {

        Product product = new Product();
        product = modelMapper.map(productDto, Product.class);
        return product;


		/*Product product = new Product();

		product.setIdProduct(productDto.getIdProduct());
		product.setNameProduct(productDto.getNameProduct());
		product.setPriceProduct(productDto.getPriceProduct());
		product.setCreationDate(productDto.getCreationDate());
		product.setCategory(productDto.getCategory());

		return product;*/
    }


}