package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return  userRepository.save((user));
    }

    //2
    @Override
    public User getUserById(Long userID) {
     Optional<User>  optionalUser=userRepository.findById(userID);
     return  optionalUser.get();
    }
}
