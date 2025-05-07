package com.foodie.user.service;

import com.foodie.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(String id);
    UserDto getUserByEmail(String email);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(String id, UserDto userDto);
    void deleteUser(String id);
}
