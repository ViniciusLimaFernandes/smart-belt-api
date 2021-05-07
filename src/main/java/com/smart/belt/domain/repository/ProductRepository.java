package com.smart.belt.domain.repository;

import com.smart.belt.application.data.product.TotalProductsDTO;
import com.smart.belt.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByUserId(String userId);

    @Query("select new com.smart.belt.application.data.product.TotalProductsDTO(sum(p.quantity), p.productCondition, p.user.id)" +
            " from Product p where p.user.id = ?1 group by p.productCondition")
    List<TotalProductsDTO> total(String userID);
}
