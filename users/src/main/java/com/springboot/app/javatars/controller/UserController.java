package com.springboot.app.javatars.controller;

import com.springboot.app.javatars.dto.UserDTO;
import com.springboot.app.javatars.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserDTO> listAll() {
        return userService.listAll();
    }

    @GetMapping("/{email}")
    public UserDTO getByMail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody @Valid UserDTO userDTO) { // response entity
        return userService.createUser(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) {
        return userService.updateUser(id, userDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/search")
    public List<UserDTO> searchUsers(@RequestParam(name = "query") String query) {
        return userService.searchUsers(query);
    }

    @GetMapping("/count")
    public Long countUsers() {
        return userService.countUsers();
    }


}


