package com.personalblog.personalblog.mapper;

import com.personalblog.personalblog.dto.user.UserCreateDTO;
import com.personalblog.personalblog.dto.user.UserUpdateDTO;
import com.personalblog.personalblog.model.User;

public class UserMapper {

    public static User toEntity(UserCreateDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoto(dto.getPhoto());
        return user;
    }

    public static User toEntity(UserUpdateDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoto(dto.getPhoto());
        return user;
    }
}
