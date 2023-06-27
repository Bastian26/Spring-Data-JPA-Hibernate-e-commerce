package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Returns the found entyr by using ist name as search
     * criteria. If no product entry is found, this method
     * returns null
     */
    public Product findByName(String name);

    /**
     * Returns an optional which contains the found product
     * entry by using its id as search criteria. If no product entry is found, this method
     * returns an empty optional
     */
    Optional<Product> findById(Long id);

    /**
     * Returns a found list of product entries whose title or description is given
     * as a method parameter. If no product entries is found, this method
     * returns an empty list
     */
    List<Product> findByNameOrDescription(String name, String description);

    /**
     * Returns a found list of product entries whose title and description is given
     * as a method parameter. If no product entries is found, this method
     * returns an empty list
     */
    List<Product> findByNameAndDescription(String name, String description);

    /**
     * Returns the distinct product entry whose name is given as a method parameter
     * If no product is found, this method returns null
     */
    Product findDistinctByName(String name);

    /**
     * Returns the products where price is greater than given price as method parameter
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);
}
