package com.smart.belt.application.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.belt.application.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    @JsonProperty("userID")
    private String userID;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    public static UserResponseDTO convertToResponse(final User user) {
        return new ModelMapper().map(user, UserResponseDTO.class);
    }

}
