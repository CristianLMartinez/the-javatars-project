package com.springboot.app.javatars.mapper;

import com.springboot.app.javatars.dto.UserDTO;
import com.springboot.app.javatars.model.User;

public class UserMapper {

    private UserMapper() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class...");
    }

    public static UserDTO toDTO(User user) {
        validUser(user);

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCelphone(),
                user.getAddress(),
                user.getCreatedAt()
        );
    }

    public static User toEntity(UserDTO dto) {
        validUser(dto);

        return new User(
                null,
                dto.name(),
                dto.email(),
                dto.password(),
                dto.celphone(),
                dto.address(),
                new java.sql.Timestamp(System.currentTimeMillis()) // Set created_at to current time
        );
    }

    private static void validUser(Object object) {
        if (object == null) {
            throw new RuntimeException("Can convert null object to boolean");
        }
    }


}
