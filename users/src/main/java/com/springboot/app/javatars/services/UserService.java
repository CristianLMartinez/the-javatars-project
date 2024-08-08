package com.springboot.app.javatars.services;

import com.springboot.app.javatars.dto.UserDTO;
import com.springboot.app.javatars.model.User;
import com.springboot.app.javatars.repository.UserRepository;
import com.springboot.app.javatars.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<UserDTO> listAll(){
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getByEmail(String email){
        return UserMapper.toDTO(userRepository.findByEmail(email));
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        User save = userRepository.save(user);
        return UserMapper.toDTO(save);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setCelphone(userDTO.getCelphone());
            user.setAddress(userDTO.getAddress());

            User updatedUser = userRepository.save(user);
            return UserMapper.toDTO(updatedUser);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> searchUsers(String query) {
        List<User> users = userRepository.findByNameContaining(query);
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Long countUsers() {
        return userRepository.count();
    }


}
