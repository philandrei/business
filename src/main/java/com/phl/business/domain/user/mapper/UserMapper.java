package com.phl.business.domain.user.mapper;

import com.phl.business.domain.user.dto.UserRequestDto;
import com.phl.business.domain.user.dto.UserResponseDto;
import com.phl.business.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    public User userRequestDtoToUser(UserRequestDto userRequestDto){
        User user = User.builder()
                            .username(userRequestDto.getUsername())
                            .password(passwordEncoder.encode(userRequestDto.getPassword()))
                            .build();

        return user;
    }

    public UserRequestDto userToUserDto(User user){
        UserRequestDto userRequestDto = UserRequestDto.builder()
                                  .password(user.getPassword())
                                  .username(user.getUsername())
                                  .build();
        return userRequestDto;
    }

    public UserResponseDto userToUserResponseDto(User user){
        UserResponseDto userResponseDto = UserResponseDto.builder()
                                                  .uuid(user.getUuid())
                                                  .username(user.getUsername())
                                                  .build();
        return userResponseDto;
    }
}
