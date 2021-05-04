package com.smart.belt.application.data.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.belt.application.entity.Product;
import com.smart.belt.application.enumeration.ProductCondition;
import com.smart.belt.application.enumeration.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    @JsonProperty("user")
    private String user;

    @JsonProperty("productType")
    private ProductType productType;

    @JsonProperty("quantity")
    private Long quantity;

    @JsonProperty("productCondition")
    private ProductCondition productCondition;

    public static Product convertToEntity(final ProductRequestDTO productRequestDTO) {

        final ModelMapper modelMapper = new ModelMapper();

        final PropertyMap<ProductRequestDTO, Product> propertyMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().getUser().setId(source.getUser());
            }
        };

        modelMapper.addMappings(propertyMap);

        return modelMapper.map(productRequestDTO, Product.class);
    }
}

