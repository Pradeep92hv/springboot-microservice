package net.javaguides.springboot.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.ErrorDetails;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API

    //@Valid  ->to anable java bean validation
    @PostMapping(  )
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
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
                                            @Valid @RequestBody UserDto user){
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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException exception, WebRequest webRequest){

        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

}
