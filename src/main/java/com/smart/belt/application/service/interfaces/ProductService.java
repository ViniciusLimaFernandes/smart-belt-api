package com.smart.belt.application.service.interfaces;

import com.smart.belt.application.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public Page<Product> findAll(final Pageable pageable);

    public Product create(final Product product);

}
