package com.example.board_crud.service;

import com.example.board_crud.dto.UserDto;
import com.example.board_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // C:create
    public UserDto insertUser(UserDto user) {
        return userRepository.insertUser(user);
    }
    // R:read
    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }
    // R:detail
    public UserDto getUserByUserId(String userId) {
        return userRepository.getUserByUserId(userId);
    }
    // U:update
    public void updateUserPw(String userId, UserDto user) {
        userRepository.updateUserPw(userId, user);
    }
    // d:delete
    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }
}
