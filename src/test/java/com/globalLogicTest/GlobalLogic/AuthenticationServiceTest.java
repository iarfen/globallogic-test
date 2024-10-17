package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.dto.RegisterUserDTO;
import com.globalLogicTest.services.AuthenticationService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AuthenticationServiceTest {

    @Autowired
    private AuthenticationService authenticationService;

    @Test
    public void givenSignUp_whenParametersAreWrong_thenThrowException() {
        List<RegisterUserDTO.RegisterPhoneDTO> phones = new ArrayList<>();
        phones.add(new RegisterUserDTO.RegisterPhoneDTO(11234322L,9L,56L));
        RegisterUserDTO registerUserDTO = new RegisterUserDTO("user1","user1@gmail.cl.com","Qweriuq29",phones);
        RegisterUserDTO registerUserDTO2 = new RegisterUserDTO("user1","user1@gmail.com","Qweriu",phones);
        RegisterUserDTO registerUserDTO3 = new RegisterUserDTO("user1","user1@gmail.com","Qweriu4354326345asfd",phones);
        RegisterUserDTO registerUserDTO4 = new RegisterUserDTO("user1","user1@gmail.com","QweRriuq29",phones);
        RegisterUserDTO registerUserDTO5 = new RegisterUserDTO("user1","user1@gmail.com","Qweriuq229",phones);

        Assert.assertThrows(Exception.class, () -> { authenticationService.signup(registerUserDTO); });
        Assert.assertThrows(Exception.class, () -> { authenticationService.signup(registerUserDTO2); });
        Assert.assertThrows(Exception.class, () -> { authenticationService.signup(registerUserDTO3); });
        Assert.assertThrows(Exception.class, () -> { authenticationService.signup(registerUserDTO4); });
        Assert.assertThrows(Exception.class, () -> { authenticationService.signup(registerUserDTO5); });
    }
}
