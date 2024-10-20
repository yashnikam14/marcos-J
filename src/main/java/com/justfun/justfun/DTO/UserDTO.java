package com.justfun.justfun.DTO;

import com.justfun.justfun.entities.RoleEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private List<RoleEntity> roles = new ArrayList<>();

}
