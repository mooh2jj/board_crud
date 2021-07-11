package com.example.board_crud.repository;

import com.example.board_crud.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    // db setting
    static public ArrayList<UserDto> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDto("seonggon", "test1", "1234"));
        users.add(new UserDto("kang", "test2", "1234"));
        users.add(new UserDto("gattie", "test3", "1234"));
    }

    public UserDto insertUser(UserDto userDto) {
        users.add(userDto);
        return userDto;
    }

    public List<UserDto> getAllUsers() {
        return users;
    }

    public UserDto getUserByUserId(String userId) {
        return users.stream()
                .filter(userDto -> userDto.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDto("", "", ""));
    }

    public void updateUserPw(String userId, UserDto user) {
        users.stream()
                .filter(userDto -> userDto.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDto("","",""))
                .setUserPw(user.getUserPw());
    }

    public void deleteUser(String userId) {
        users.removeIf(userDto -> userDto.getUserId().equals(userId));
    }
}
