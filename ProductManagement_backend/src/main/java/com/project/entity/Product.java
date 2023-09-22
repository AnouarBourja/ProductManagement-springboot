package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String nameProduct;

    private Double priceProduct;

    private Date creationDate;

    @ManyToOne
    private Category category;

    public Product(String nameProduct, Double priceProduct, Date creationDate)
    {
        super();
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.creationDate = creationDate;
    }


}