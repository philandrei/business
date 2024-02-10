package com.phl.business.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping("/{uuid}")
    public UserDto updateUser(@PathVariable String uuid,@RequestBody UserDto userDto){
        return userService.updateUser(uuid,userDto);
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
