package com.smart.belt.application.service.interfaces;

import com.smart.belt.application.data.user.UserRequestDTO;
import com.smart.belt.application.data.user.UserResponseDTO;

public interface UserService {

    public UserResponseDTO createUser(final UserRequestDTO userRequestDTO);

}
