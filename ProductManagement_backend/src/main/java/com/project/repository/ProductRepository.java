package com.project.repository;

import com.project.entity.Category;
import com.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    List<Product> findByNameProduct(String nom);

    List<Product> findByNameProductContains(String nom);

	/*@Query("select p from Product p where p.nameProduct like %?1 and p.priceProduct > ?2")
	List<Product> findByNamePrice(String name, Double price);*/

    @Query("select p from Product p where p.nameProduct like %:name and p.priceProduct > :price")
    List<Product> findByNamePrice(@Param("name") String name, @Param("price") Double price);

    @Query("select p from Product p where p.category = ?1")
    List<Product> findByCategory(Category category);

    List<Product> findByCategoryIdCategory(Long id);

    List<Product> findByOrderByNameProductAsc();

    @Query("select p from Product p order by p.nameProduct ASC, p.priceProduct DESC")
    List<Product> sortProductsNamePrice();

}
