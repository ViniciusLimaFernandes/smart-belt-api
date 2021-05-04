package com.smart.belt.application.service;

import com.smart.belt.application.data.user.UserRequestDTO;
import com.smart.belt.application.data.user.UserResponseDTO;
import com.smart.belt.application.entity.User;
import com.smart.belt.application.repository.UserRepository;
import com.smart.belt.application.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(final UserRequestDTO userRequestDTO) {
        final User user = UserRequestDTO.convertToEntity(userRequestDTO);

        userRepository.save(user);

        return UserResponseDTO.convertToResponse(user);
    }
}
