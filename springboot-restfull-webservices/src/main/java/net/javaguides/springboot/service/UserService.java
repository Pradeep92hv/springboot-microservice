package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.User;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userID);   // 1
}
