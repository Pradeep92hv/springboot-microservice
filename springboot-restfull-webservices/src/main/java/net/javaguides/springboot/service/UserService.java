package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userID);   // 1

    List<UserDto> getAllUser();

    User updateUser(User user);

    void deteleUser(Long id);
}
