package com.smart.belt.application.data.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.belt.domain.entity.Product;
import com.smart.belt.domain.enumeration.ProductCondition;
import com.smart.belt.domain.enumeration.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    @JsonProperty("userId")
    private String userID;

    @JsonProperty("productType")
    private ProductType productType;

    @JsonProperty("quantity")
    private Long quantity;

    @JsonProperty("productCondition")
    private ProductCondition productCondition;

    @JsonIgnore
    private LocalDate registerDate;

    public static ProductResponseDTO convertToDTO(final Product product) {
        return new ModelMapper().map(product, ProductResponseDTO.class);
    }
}
