package com.globalLogicTest.controller;

import com.globalLogicTest.model.Phone;
import com.globalLogicTest.model.User;
import com.globalLogicTest.dto.RegisterUserDTO;
import com.globalLogicTest.response.LoginResponse;
import com.globalLogicTest.response.RegisterResponse;
import com.globalLogicTest.services.AuthenticationService;
import com.globalLogicTest.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterUserDTO registerUserDto) throws Exception {
        User registeredUser = authenticationService.signup(registerUserDto);
        String jwtToken = jwtService.generateToken(registeredUser);
        RegisterResponse registerResponse = new RegisterResponse(registeredUser.getId(),
                registeredUser.getCreatedAt(),
                registeredUser.getLastLogin(),
                jwtToken,
                registeredUser.getIsActive());
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestHeader(name="Authorization") String token) {
        LoginResponse loginResponse = authenticationService.login(token);
        return ResponseEntity.ok(loginResponse);
    }
}
