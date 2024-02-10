package com.phl.business.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    public User userDtoToUser(UserDto userDto){
        User user = User.builder()
                            .username(userDto.getUsername())
                            .password(passwordEncoder.encode(userDto.getPassword()))
                            .build();

        return user;
    }

    public UserDto userToUserDto(User user){
        UserDto userDto = UserDto.builder()
                                  .password(user.getPassword())
                                  .username(user.getUsername())
                                  .build();
        return userDto;
    }
}
