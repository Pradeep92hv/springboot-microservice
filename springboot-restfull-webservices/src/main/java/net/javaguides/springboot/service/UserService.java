package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userID);   // 1

    List<User> getAllUser();

    User updateUser(User user);

    void deteleUser(Long id);
}
