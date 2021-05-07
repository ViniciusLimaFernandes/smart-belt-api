package com.smart.belt.application.service;

import com.smart.belt.application.data.product.TotalProductsDTO;
import com.smart.belt.application.exception.ResourceNotFoundException;
import com.smart.belt.application.service.interfaces.ProductService;
import com.smart.belt.domain.entity.Product;
import com.smart.belt.domain.repository.ProductRepository;
import com.smart.belt.domain.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    UserRepository userRepository;

    public ProductServiceImpl(final ProductRepository productRepository, final UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<Product> findAll(final Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product create(final Product product) {
        final boolean userExists = userRepository.findById(product.getUser().getId()).isPresent();

        if (!userExists) {
            throw new ResourceNotFoundException("User not found!");
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> findByUserId(final String userID) {
        return productRepository.findByUserId(userID);
    }

    @Override
    public List<TotalProductsDTO> total(final String userID) {
        return productRepository.total(userID);
    }
}
