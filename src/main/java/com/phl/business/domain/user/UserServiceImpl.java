package com.phl.business.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(String uuid,UserDto userDto) {
        User existingUser = userRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
        existingUser.updateFrom(userDto);
        return userMapper.userToUserDto(existingUser);
    }

    @Override
    public User getOneUser(String uuid) {
        return userRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(String uuid) {
        userRepository.deleteById(uuid);
        return uuid;
    }
}
