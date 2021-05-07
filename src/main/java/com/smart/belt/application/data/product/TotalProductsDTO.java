package com.smart.belt.application.data.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalProductsDTO {

    private Long total;

    private String condition;

    private String userID;

}
