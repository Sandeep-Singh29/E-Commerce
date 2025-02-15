package com.springbootmicroserviceweek3.ecommerce.inventory.repository;


import com.springbootmicroserviceweek3.ecommerce.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
