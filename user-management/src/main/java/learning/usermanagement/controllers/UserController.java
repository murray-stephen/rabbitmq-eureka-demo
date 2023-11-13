package learning.usermanagement.controllers;

import learning.usermanagement.dtos.UserDto;
import learning.usermanagement.dtos.UserResponseDto;
import learning.usermanagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final  UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        return new ResponseEntity<>(this.usersService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto user = usersService.saveUser(userDto);

        System.out.println("controller usersDto");
        System.out.println(userDto);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
