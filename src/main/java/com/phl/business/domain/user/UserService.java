package com.phl.business.domain.user;


import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(String uuid, UserRequestDto userRequestDto);

    User getOneUser(String uuid);

    List<User> getAllUsers();

    String deleteUser(String uuid);
}
