package com.globalLogicTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {

    private String name;

    private String email;

    private String password;

    private List<RegisterPhoneDTO> phones;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterPhoneDTO {

        private Long number;

        private Long citycode;

        private Long countrycode;
    }

}