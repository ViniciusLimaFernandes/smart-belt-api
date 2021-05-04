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
public class UserRequestDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("cellphone")
    private String cellphone;

    public static User convertToEntity(final UserRequestDTO userRequestDTO) {
        return new ModelMapper().map(userRequestDTO, User.class);
    }
}
