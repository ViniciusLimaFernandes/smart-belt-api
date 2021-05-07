package com.smart.belt.application.service.interfaces;

import com.smart.belt.application.data.product.TotalProductsDTO;
import com.smart.belt.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    public Page<Product> findAll(final Pageable pageable);

    public Product create(final Product product);

    public List<Product> findByUserId(String userID);

    public List<TotalProductsDTO> total(String userID);

}
