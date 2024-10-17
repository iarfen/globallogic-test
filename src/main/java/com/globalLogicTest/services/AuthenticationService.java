package com.globalLogicTest.services;

import com.globalLogicTest.dto.RegisterUserDTO;
import com.globalLogicTest.model.Phone;
import com.globalLogicTest.model.User;
import com.globalLogicTest.dao.UsersDAO;
import com.globalLogicTest.response.LoginResponse;
import com.globalLogicTest.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class AuthenticationService {
    @Autowired
    private UsersDAO userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public User signup(RegisterUserDTO registerUserDto) throws Exception {
        if (!Pattern.compile("[A-Za-z0-9.-]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+")
                .matcher(registerUserDto.getEmail())
                .matches()) {
            throw new Exception("{\"error\": [{\"timestamp\": \"" + new Date() + "\"," +
                    "\"codigo\": 1," +
                    "\"detail\": \"Invalid email address\"}]}");
        }
        if (registerUserDto.getPassword().length() < 8)
        {
            throw new Exception("{\"error\": [{\"timestamp\": \"" + new Date() + "\"," +
                    "\"codigo\": 2," +
                    "\"detail\": \"Password length is lower than 8 characters\"}]}");
        }
        if (registerUserDto.getPassword().length() > 12)
        {
            throw new Exception("{\"error\": [{\"timestamp\": \"" + new Date() + "\"," +
                    "\"codigo\": 3," +
                    "\"detail\": \"Password length is greather than 12 characters\"}]}");
        }
        int numberDigits = 0;
        int numberUpper = 0;
        for(int i = 0; i < registerUserDto.getPassword().length(); i++) {
            char currentCharacter = registerUserDto.getPassword().charAt(i);
            if( Character.isDigit(currentCharacter)) {
                numberDigits++;
            }
            else if (Character.isUpperCase(currentCharacter)) {
                numberUpper++;
            }
        }
        if (numberUpper != 1)
        {
            throw new Exception("{\"error\": [{\"timestamp\": \"" + new Date() + "\"," +
                    "\"codigo\": 4," +
                    "\"detail\": \"Password must have exactly one uppercase character\"}]}");
        }
        if (numberDigits != 2)
        {
            throw new Exception("{\"error\": [{\"timestamp\": \"" + new Date() + "\"," +
                    "\"codigo\": 5," +
                    "\"detail\": \"Password must have exactly two characters of digits\"}]}");
        }
        User user = new User();
        user.setName(registerUserDto.getName());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));

        List<Phone> phones = new ArrayList<>();
        for (RegisterUserDTO.RegisterPhoneDTO registerPhone : registerUserDto.getPhones())
        {
            Phone phone = new Phone();
            phone.setNumber(registerPhone.getNumber());
            phone.setCitycode(registerPhone.getCitycode());
            phone.setCountrycode(registerPhone.getCountrycode());
            phones.add(phone);
        }

        user.setPhones(phones);
        user.setLastLogin(new Date());
        user.setIsActive(true);

        return userRepository.save(user);
    }

    public LoginResponse login(String email) {
        email = jwtService.extractUsername(email.substring(7));
        User authenticatedUser = userRepository.findByEmail(email).orElseThrow();

        String jwtToken = jwtService.generateToken(authenticatedUser);

        List<RegisterUserDTO.RegisterPhoneDTO> responsePhones = new ArrayList<>();
        for(Phone phone : authenticatedUser.getPhones())
        {
            RegisterUserDTO.RegisterPhoneDTO responsePhone = new RegisterUserDTO.RegisterPhoneDTO(phone.getNumber(),phone.getCitycode(),phone.getCountrycode());
        }

        LoginResponse loginResponse = new LoginResponse(authenticatedUser.getId(),
                authenticatedUser.getCreatedAt(),
                authenticatedUser.getLastLogin(),
                jwtToken,
                authenticatedUser.getIsActive(),
                authenticatedUser.getName(),
                authenticatedUser.getEmail(),
                authenticatedUser.getPassword(),
                responsePhones);
        return loginResponse;
    }
}