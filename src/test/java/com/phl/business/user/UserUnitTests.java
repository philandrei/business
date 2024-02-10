package com.phl.business.user;

import com.phl.business.domain.user.dto.UserRequestDto;
import com.phl.business.domain.user.dto.UserResponseDto;
import com.phl.business.domain.user.model.User;
import com.phl.business.domain.user.service.UserService;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserUnitTests {


    @Autowired
    UserService userService;

    @PostConstruct
    void init() {
        UserRequestDto userRequestDto = UserRequestDto.builder()
                                                .username("postconstruct")
                                                .password("postconstruct")
                                                .build();
        userService.createUser(userRequestDto);
    }

    @Test
    void createUserTest() {
        UserRequestDto userRequestDto = UserRequestDto.builder()
                                                .username("phil")
                                                .password("root")
                                                .build();
        UserResponseDto savedUserRequestDto = userService.createUser(userRequestDto);

        assertEquals(savedUserRequestDto.getUsername(), userRequestDto.getUsername());
        Assertions.assertNotEquals(userService.getAllUsers().size(), 1);
    }

    @Test
    void updateUserTest() {
        User user = userService.getAllUsers().get(1);
        UserRequestDto userRequestDto = UserRequestDto.builder()
                                                .username("updatedUsername")
                                                .build();
        UserResponseDto updatedUserResponseDto = userService.updateUser(user.getUuid(), userRequestDto);
        User updatedUser = userService.getOneUser(updatedUserResponseDto.getUuid());

        assertNotEquals(updatedUserResponseDto.getUsername(), user.getUsername());
        assertEquals(updatedUserResponseDto.getUsername(),updatedUser.getUsername());
    }

    @Test
    void getOneUserTest() {
        String testUUID = "12345";
        User user = userService.getAllUsers().get(0);

        assertNotNull(userService.getOneUser(user.getUuid()));
        assertNull(userService.getOneUser(testUUID));
    }

    @Test
    void getAllUsersTest() {
        assertNotEquals(userService.getAllUsers().size(), 0);
    }

    @Test
    void deleteUserTest() {
        UserRequestDto userRequestDto = UserRequestDto.builder()
                                                .username("forDelete")
                                                .password("forDelete")
                                                .build();
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        String uuidResponse = userService.deleteUser(userResponseDto.getUuid());

        assertNull(userService.getOneUser(uuidResponse));

    }
}
