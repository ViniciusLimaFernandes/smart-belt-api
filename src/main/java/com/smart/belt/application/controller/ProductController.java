package com.smart.belt.application.controller;

import com.smart.belt.application.data.ProductVO;
import com.smart.belt.application.repository.ProductRepository;
import com.smart.belt.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class HelloWorldController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") final int page,
                                     @RequestParam(value = "limit", defaultValue = "12") final int limit,
                                     @RequestParam(value = "direction", defaultValue = "asc") final String direction) {

        final String propertyReference = "registerDate";

        final Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        final Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, propertyReference));

        final Page<ProductVO> products = productService.findAll(pageable);

        return ResponseEntity.ok(products);
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<?> insertProduct(@RequestBody final ProductVO productVO) {
        productService.create(productVO);

        return ResponseEntity.ok("Product Created!");
    }

}
