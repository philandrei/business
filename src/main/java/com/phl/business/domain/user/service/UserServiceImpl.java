package com.phl.business.domain.user.service;

import com.phl.business.domain.user.dto.UserRequestDto;
import com.phl.business.domain.user.dto.UserResponseDto;
import com.phl.business.domain.user.mapper.UserMapper;
import com.phl.business.domain.user.model.User;
import com.phl.business.domain.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        LOG.info("[createUser]: Start");
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        LOG.info("[createUser]: Saving User");
        userRepository.save(user);
        LOG.info("[createUser]: Done");
        return userMapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(String uuid, UserRequestDto userRequestDto) {
        LOG.info("[updateUser]: Start");
        User existingUser = userRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
        existingUser.updateFrom(userRequestDto);
        LOG.info("[updateUser]: Saving User");
        userRepository.save(existingUser);
        LOG.info("[updateUser]: Done");
        return userMapper.userToUserResponseDto(existingUser);
    }

    @Override
    public User getOneUser(String uuid) {
        LOG.info("[getOneUser]: Start");
        return userRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        LOG.info("[getAllUsers]: Start");
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(String uuid) {
        LOG.info("[deleteUser]: Start");
        LOG.info("[deleteUser]: Deleting User: "+uuid);
        userRepository.deleteById(uuid);
        LOG.info("[deleteUser]: Done");
        return uuid;
    }
}
