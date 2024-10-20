package com.justfun.justfun.services;

import com.justfun.justfun.DTO.UserDTO;
import com.justfun.justfun.entities.UserEntity;
import com.justfun.justfun.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    final UserRepository userRepository;
    final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity= modelMapper.map(userDTO, UserEntity.class);
        return modelMapper.map(userRepository.save(userEntity), UserDTO.class);
    }

//    public UserEntity findByUsername(String username){
//        return userRepository.findByUsername(username);
//    }
}
