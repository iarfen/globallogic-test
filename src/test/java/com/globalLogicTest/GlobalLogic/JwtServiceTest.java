package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.dao.UsersDAO;
import com.globalLogicTest.model.Phone;
import com.globalLogicTest.model.User;
import com.globalLogicTest.services.JwtService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @MockBean
    private UsersDAO usersDAO;

    @Test
    public void givenSignUpRequest_whenSignUp_thenReturnRegisteredUser() {
        Phone phone1 = Phone.builder().number(11234322L).citycode(9L).countrycode(56L).build();
        List<Phone> userPhones = new ArrayList<>();
        userPhones.add(phone1);
        User user = User.builder()
                .id(1L)
                .name("user1")
                .email("user1@gmail.com")
                .password("Qweriuq29")
                .phones(userPhones)
                .createdAt(new Date())
                .lastLogin(new Date())
                .isActive(true)
                .build();

        Assert.assertEquals("user1@gmail.com", jwtService.extractUsername(jwtService.generateToken(user)));
    }

    @Test
    public void givenSignUpRequest_whenSignUp_thenReturnRegisteredUser2() {
        Phone phone1 = Phone.builder().number(11234322L).citycode(9L).countrycode(56L).build();
        List<Phone> userPhones = new ArrayList<>();
        userPhones.add(phone1);
        User user = User.builder()
                .id(1L)
                .name("user1")
                .email("user1@gmail.com")
                .password("Qweriuq29")
                .phones(userPhones)
                .createdAt(new Date())
                .lastLogin(new Date())
                .isActive(true)
                .build();

        Assert.assertNotEquals(0L, jwtService.generateToken(user).length());
    }

    @Test
    public void givenSignUpRequest_whenSignUp_thenReturnRegisteredUser3() {
        Assert.assertNotEquals(0L, jwtService.getExpirationTime());
    }

    @Test
    public void givenSignUpRequest_whenSignUp_thenReturnRegisteredUser4() {
        Phone phone1 = Phone.builder().number(11234322L).citycode(9L).countrycode(56L).build();
        List<Phone> userPhones = new ArrayList<>();
        userPhones.add(phone1);
        User user = User.builder()
                .id(1L)
                .name("user1")
                .email("user1@gmail.com")
                .password("Qweriuq29")
                .phones(userPhones)
                .createdAt(new Date())
                .lastLogin(new Date())
                .isActive(true)
                .build();
        String token = jwtService.generateToken(user);

        Assert.assertEquals(true, jwtService.isTokenValid(token,user));
    }
}