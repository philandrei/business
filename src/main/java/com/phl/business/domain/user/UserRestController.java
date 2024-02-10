package com.phl.business.domain.user;

import com.phl.business.domain.user.dto.UserRequestDto;
import com.phl.business.domain.user.dto.UserResponseDto;
import com.phl.business.domain.user.model.User;
import com.phl.business.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }

    @PutMapping("/{uuid}")
    public UserResponseDto updateUser(@PathVariable String uuid, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(uuid, userRequestDto);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{uuid}")
    public User getOneUser(@PathVariable String uuid){
        return userService.getOneUser(uuid);
    }

    @DeleteMapping("/{uuid}")
    public String deleteUser(@PathVariable String uuid){
        return userService.deleteUser(uuid);
    }
}
