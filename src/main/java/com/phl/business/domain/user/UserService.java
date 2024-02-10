package com.phl.business.domain.user;


import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String uuid,UserDto userDto);

    User getOneUser(String uuid);

    List<User> getAllUsers();

    String deleteUser(String uuid);
}
