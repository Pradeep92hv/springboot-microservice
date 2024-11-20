package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API

    @PostMapping(  )
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto saved=userService.createUser((user));

        return  new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //3

    //build get user by ID REST APi
     // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserBYId(@PathVariable("id") Long userId){
        UserDto user=userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //build get all user  REST APi
    // http://localhost:8080/api/users
    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUser(){
      List<UserDto> users= userService.getAllUser();
      return  new ResponseEntity<>(users,HttpStatus.OK);
    }

    // build update user REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody UserDto user){
        user.setId(userId);
      UserDto updatedUser=  userService.updateUser(user);

      return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    // 28. Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId)
    {
        userService.deteleUser(userId);
        return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
    }

}
