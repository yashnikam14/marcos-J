package com.justfun.justfun.controller;

import com.justfun.justfun.DTO.UserDTO;
import com.justfun.justfun.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        try{
            List<UserDTO> users = userService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(path = "/create-user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        try{
            UserDTO user = userService.createUser(userDTO);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @PutMapping(path = "/put-user")
//    public ResponseEntity<?> putUser(@RequestBody UserDTO userDTO){
//        try{
//            UserDTO user = userService.findByUserName(userDTO.getUserName());
//            if (user != null){
//                user.setUserName(user.getUserName());
//                user.setPassword(user.getPassword());
//                userService.createUser(user);
//                return new ResponseEntity<>(user, HttpStatus.CREATED);
//            }
//            return new ResponseEntity<>(HttpStatus.CREATED);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
}
