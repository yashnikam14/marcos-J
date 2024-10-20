package com.justfun.justfun.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunDTO {

    private Long id;

    private String title;
    private String description;
}
