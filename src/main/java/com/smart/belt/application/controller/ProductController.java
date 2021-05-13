package com.smart.belt.application.controller;

import com.smart.belt.application.data.product.ProductRequestDTO;
import com.smart.belt.application.data.product.ProductResponseDTO;
import com.smart.belt.application.data.product.TotalProductsDTO;
import com.smart.belt.application.service.interfaces.ProductService;
import com.smart.belt.domain.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product", description = "Product requests")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @Operation(summary = "List all products based on the given parameters")
    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<Page<ProductResponseDTO>> findAll(final Pageable pageable) {
        //params: page, size e sort
        final Page<Product> productPage = productService.findAll(pageable);

        final Page<ProductResponseDTO> response = productPage.map(ProductResponseDTO::convertToDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @Operation(summary = "Register a new product for an user")
    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<ProductResponseDTO> insertProduct(@RequestBody final ProductRequestDTO productRequestDTO) {
        final Product product = productService.create(ProductRequestDTO.convertToEntity(productRequestDTO));

        final ProductResponseDTO response = ProductResponseDTO.convertToDTO(product);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @CrossOrigin
    @Operation(summary = "List all products by user")
    @GetMapping(value = "/find")
    public ResponseEntity<List<Product>> productsByUser(@RequestParam("userID") final String userID) {
        final List<Product> response = productService.findByUserId(userID);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @Operation(summary = "Products summary by user")
    @GetMapping(value = "/summary")
    public ResponseEntity<List<TotalProductsDTO>> totalProductsByUserAndCondition(@RequestParam("userID") final String userID) {
        final List<TotalProductsDTO> response = productService.total(userID);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
