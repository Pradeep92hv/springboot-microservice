package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        // convert UserDto to User JPA Entity to save in DB

        User user= UserMapper.mapToUser(userDto);
         User savedUser= userRepository.save(user);

         // convert User JPA Entity to UserDto

        UserDto savedUserDto=UserMapper.mapToUserDto(user);

        return savedUserDto;

    }

    //2
    @Override
    public UserDto getUserById(Long userID) {
     Optional<User>  optionalUser=userRepository.findById(userID);
     User user = optionalUser.get();

     return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users =userRepository.findAll();
        return users.stream().map(UserMapper :: mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
        User existingUser=userRepository.findById(user.getId()).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser= userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deteleUser(Long id) {
        userRepository.deleteById(id);
    }
}
