package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.dto.RegisterUserDTO;
import com.globalLogicTest.response.LoginResponse;
import com.globalLogicTest.response.RegisterResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class LoginResponseTest {

    @Test
    public void givenGetters_whenInstantiating_thenReturnCorrectValues() throws Exception {
        RegisterUserDTO.RegisterPhoneDTO phone1 = new RegisterUserDTO.RegisterPhoneDTO(11234322L, 9L,56L);
        List<RegisterUserDTO.RegisterPhoneDTO> userPhones = new ArrayList<>();
        userPhones.add(phone1);
        Date date = new Date();
        LoginResponse user = LoginResponse.builder()
                .id(1L)
                .created(date)
                .lastLogin(date)
                .token("123ijAkdhuisah324908lajif")
                .isActive(true)
                .name("user1")
                .email("user1@gmail.com")
                .password("Qweriuq29")
                .phones(userPhones)
                .build();

        Assert.assertEquals(1L, user.getId().longValue());
        Assert.assertEquals(date, user.getCreated());
        Assert.assertEquals(date, user.getLastLogin());
        Assert.assertEquals("123ijAkdhuisah324908lajif", user.getToken());
        Assert.assertEquals(true, user.isActive());
        Assert.assertEquals("user1", user.getName());
        Assert.assertEquals("user1@gmail.com", user.getEmail());
        Assert.assertEquals("Qweriuq29", user.getPassword());
        Assert.assertEquals(userPhones, user.getPhones());

        LoginResponse user2 = new LoginResponse(1L, date, date, "123ijAkdhuisah324908lajif", true, "user1", "user1@gmail.com", "Qweriuq29", userPhones);
        Assert.assertEquals(true, user.equals(user2));
        Assert.assertEquals(user.hashCode(), user.hashCode());
        Assert.assertNotEquals(0, user.toString().length());
        Assert.assertNotEquals(0, user.builder().toString().length());
    }

    @Test
    public void givenAllArgsConstructor_whenUsingGetters_thenReturnCorrectValues() throws Exception {
        RegisterUserDTO.RegisterPhoneDTO phone1 = new RegisterUserDTO.RegisterPhoneDTO(11234322L, 9L,56L);
        List<RegisterUserDTO.RegisterPhoneDTO> userPhones = new ArrayList<>();
        userPhones.add(phone1);
        Date date = new Date();
        LoginResponse user = new LoginResponse(1L, date, date, "123ijAkdhuisah324908lajif", true, "user1", "user1@gmail.com", "Qweriuq29", userPhones);

        Assert.assertEquals(1L, user.getId().longValue());
        Assert.assertEquals(date, user.getCreated());
        Assert.assertEquals(date, user.getLastLogin());
        Assert.assertEquals("123ijAkdhuisah324908lajif", user.getToken());
        Assert.assertEquals(true, user.isActive());
        Assert.assertEquals("user1", user.getName());
        Assert.assertEquals("user1@gmail.com", user.getEmail());
        Assert.assertEquals("Qweriuq29", user.getPassword());
        Assert.assertEquals(userPhones, user.getPhones());
    }

    @Test
    public void givenSetters_whenUsingGetters_thenReturnCorrectValues() throws Exception {
        RegisterUserDTO.RegisterPhoneDTO phone1 = new RegisterUserDTO.RegisterPhoneDTO(11234322L, 9L,56L);
        List<RegisterUserDTO.RegisterPhoneDTO> userPhones = new ArrayList<>();
        userPhones.add(phone1);
        Date date = new Date();
        LoginResponse user = new LoginResponse();
        user.setId(1L);
        user.setCreated(date);
        user.setLastLogin(date);
        user.setToken("123ijAkdhuisah324908lajif");
        user.setActive(true);
        user.setName("user1");
        user.setEmail("user1@gmail.com");
        user.setPassword("Qweriuq29");
        user.setPhones(userPhones);

        Assert.assertEquals(1L, user.getId().longValue());
        Assert.assertEquals(date, user.getCreated());
        Assert.assertEquals(date, user.getLastLogin());
        Assert.assertEquals("123ijAkdhuisah324908lajif", user.getToken());
        Assert.assertEquals(true, user.isActive());
        Assert.assertEquals("user1", user.getName());
        Assert.assertEquals("user1@gmail.com", user.getEmail());
        Assert.assertEquals("Qweriuq29", user.getPassword());
        Assert.assertEquals(userPhones, user.getPhones());
    }
}
