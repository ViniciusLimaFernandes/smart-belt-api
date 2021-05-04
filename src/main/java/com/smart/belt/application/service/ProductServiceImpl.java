package com.smart.belt.application.service;

import com.smart.belt.application.entity.Product;
import com.smart.belt.application.exception.ResourceNotFoundException;
import com.smart.belt.application.repository.ProductRepository;
import com.smart.belt.application.repository.UserRepository;
import com.smart.belt.application.service.interfaces.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
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

}
