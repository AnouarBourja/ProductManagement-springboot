package com.project.dto;

import com.project.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto
{
    private Long idProduct;

    private String nameProduct;

    private Double priceProduct;

    private Date creationDate;

    private Category category;

    private String nameCategory;
    
}