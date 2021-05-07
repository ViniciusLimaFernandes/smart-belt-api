package com.smart.belt.application.service.interfaces;

import com.smart.belt.application.data.user.UserRequestDTO;
import com.smart.belt.application.data.user.UserResponseDTO;
import com.smart.belt.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    public UserResponseDTO createUser(final UserRequestDTO userRequestDTO);

    public Page<User> listAll(final Pageable pageable);

}
