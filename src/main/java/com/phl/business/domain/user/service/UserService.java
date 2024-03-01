package com.phl.business.domain.user.service;


import com.phl.business.domain.user.dto.UserRequestDto;
import com.phl.business.domain.user.dto.UserResponseDto;
import com.phl.business.domain.user.model.User;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(String uuid, UserRequestDto userRequestDto);

    User getOneUser(String uuid);

    List<User> getAllUsers();

    String deleteUser(String uuid);
}
