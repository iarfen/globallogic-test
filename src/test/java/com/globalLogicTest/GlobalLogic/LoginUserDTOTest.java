package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.dto.LoginUserDTO;
import com.globalLogicTest.dto.RegisterUserDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class LoginUserDTOTest {

    @Test
    public void givenGetters_whenInstantiating_thenReturnCorrectValues() throws Exception {
        LoginUserDTO loginUserDTO = new LoginUserDTO("user1@gmail.com","Qweriuq29");

        Assert.assertEquals("user1@gmail.com", loginUserDTO.getEmail());
        Assert.assertEquals("Qweriuq29", loginUserDTO.getPassword());

        LoginUserDTO loginUserDTO2 = new LoginUserDTO("user1@gmail.com","Qweriuq29");
        Assert.assertEquals(true, loginUserDTO.equals(loginUserDTO2));
        Assert.assertEquals(loginUserDTO.hashCode(), loginUserDTO.hashCode());
        Assert.assertNotEquals(0, loginUserDTO.toString().length());
    }

    @Test
    public void givenSetters_whenUsingGetters_thenReturnCorrectValues() throws Exception {
        LoginUserDTO loginUserDTO = new LoginUserDTO();
        loginUserDTO.setEmail("user1@gmail.com");
        loginUserDTO.setPassword("Qweriuq29");

        Assert.assertEquals("user1@gmail.com", loginUserDTO.getEmail());
        Assert.assertEquals("Qweriuq29", loginUserDTO.getPassword());
    }
}
