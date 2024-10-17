package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.dao.UsersDAO;
import com.globalLogicTest.model.Phone;
import com.globalLogicTest.model.User;
import com.globalLogicTest.services.UserService;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

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
        List<User> users = new ArrayList<>();
        users.add(user);
        when(usersDAO.findAll()).thenReturn(users);

        Assert.assertEquals(userService.allUsers(), users);
    }
}
