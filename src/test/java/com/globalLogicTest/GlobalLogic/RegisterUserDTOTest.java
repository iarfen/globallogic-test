package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.dto.RegisterUserDTO;
import com.globalLogicTest.response.LoginResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RegisterUserDTOTest {

    @Test
    public void givenGetters_whenInstantiating_thenReturnCorrectValues() throws Exception {
        List<RegisterUserDTO.RegisterPhoneDTO> phones = new ArrayList<>();
        phones.add(new RegisterUserDTO.RegisterPhoneDTO(11234322L,9L,56L));
        RegisterUserDTO registerUserDTO = new RegisterUserDTO("user1","user1@gmail.com","Qweriuq29",phones);

        Assert.assertEquals("user1", registerUserDTO.getName());
        Assert.assertEquals("user1@gmail.com", registerUserDTO.getEmail());
        Assert.assertEquals("Qweriuq29", registerUserDTO.getPassword());
        Assert.assertEquals(phones, registerUserDTO.getPhones());

        RegisterUserDTO registerUserDTO2 = new RegisterUserDTO("user1","user1@gmail.com","Qweriuq29",phones);
        Assert.assertEquals(true, registerUserDTO.equals(registerUserDTO2));
        Assert.assertEquals(registerUserDTO.hashCode(), registerUserDTO.hashCode());
        Assert.assertNotEquals(0, registerUserDTO.toString().length());

        RegisterUserDTO.RegisterPhoneDTO registerPhoneDTO2 = new RegisterUserDTO.RegisterPhoneDTO(11234322L,9L,56L);
        Assert.assertEquals(true, phones.get(0).equals(registerPhoneDTO2));
    }

    @Test
    public void givenSetters_whenUsingGetters_thenReturnCorrectValues() throws Exception {
        List<RegisterUserDTO.RegisterPhoneDTO> phones = new ArrayList<>();
        RegisterUserDTO.RegisterPhoneDTO phone = new RegisterUserDTO.RegisterPhoneDTO();
        phone.setNumber(11234322L);
        phone.setCitycode(9L);
        phone.setCountrycode(56L);
        phones.add(phone);
        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        registerUserDTO.setName("user1");
        registerUserDTO.setEmail("user1@gmail.com");
        registerUserDTO.setPassword("Qweriuq29");
        registerUserDTO.setPhones(phones);

        Assert.assertEquals(11234322L, registerUserDTO.getPhones().get(0).getNumber().longValue());
        Assert.assertEquals(9L, registerUserDTO.getPhones().get(0).getCitycode().longValue());
        Assert.assertEquals(56L, registerUserDTO.getPhones().get(0).getCountrycode().longValue());

        Assert.assertEquals("user1", registerUserDTO.getName());
        Assert.assertEquals("user1@gmail.com", registerUserDTO.getEmail());
        Assert.assertEquals("Qweriuq29", registerUserDTO.getPassword());
        Assert.assertEquals(phones, registerUserDTO.getPhones());
    }
}
