package com.smart.belt.application.controller;

import com.smart.belt.application.data.product.ProductRequestDTO;
import com.smart.belt.application.data.product.ProductResponseDTO;
import com.smart.belt.application.entity.Product;
import com.smart.belt.application.service.interfaces.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<Page<ProductResponseDTO>> findAll(final Pageable pageable) {
        //params: page, size e sort
        final Page<Product> productPage = productService.findAll(pageable);

        final Page<ProductResponseDTO> response = productPage.map(ProductResponseDTO::convertToDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<ProductResponseDTO> insertProduct(@RequestBody final ProductRequestDTO productRequestDTO) {
        final Product product = productService.create(ProductRequestDTO.convertToEntity(productRequestDTO));

        final ProductResponseDTO response = ProductResponseDTO.convertToDTO(product);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
