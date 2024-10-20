package com.justfun.justfun.DTO;

import lombok.Data;

@Data
public class AuthResponseDTO {
    private String accessToken;
    private String tokenType = "TOKEN ";

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}
