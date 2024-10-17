package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.response.RegisterResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RegisterResponseTest {

    @Test
    public void givenGetters_whenInstantiating_thenReturnCorrectValues() throws Exception {
        Date date = new Date();
        RegisterResponse user = RegisterResponse.builder()
                .id(1L)
                .created(date)
                .lastLogin(date)
                .token("123ijAkdhuisah324908lajif")
                .isActive(true)
                .build();

        Assert.assertEquals(1L, user.getId().longValue());
        Assert.assertEquals(date, user.getCreated());
        Assert.assertEquals(date, user.getLastLogin());
        Assert.assertEquals("123ijAkdhuisah324908lajif", user.getToken());
        Assert.assertEquals(true, user.getIsActive());

        RegisterResponse user2 = new RegisterResponse(1L, date, date, "123ijAkdhuisah324908lajif", true);
        Assert.assertEquals(true, user.equals(user2));
        Assert.assertEquals(user.hashCode(), user.hashCode());
        Assert.assertNotEquals(0, user.toString().length());
        Assert.assertNotEquals(0, user.builder().toString().length());
    }

    @Test
    public void givenAllArgsConstructor_whenUsingGetters_thenReturnCorrectValues() throws Exception {
        Date date = new Date();
        RegisterResponse user = new RegisterResponse(1L, date, date, "123ijAkdhuisah324908lajif", true);

        Assert.assertEquals(1L, user.getId().longValue());
        Assert.assertEquals(date, user.getCreated());
        Assert.assertEquals(date, user.getLastLogin());
        Assert.assertEquals("123ijAkdhuisah324908lajif", user.getToken());
        Assert.assertEquals(true, user.getIsActive());
    }

    @Test
    public void givenSetters_whenUsingGetters_thenReturnCorrectValues() throws Exception {
        Date date = new Date();
        RegisterResponse user = new RegisterResponse();
        user.setId(1L);
        user.setCreated(date);
        user.setLastLogin(date);
        user.setToken("123ijAkdhuisah324908lajif");
        user.setIsActive(true);

        Assert.assertEquals(1L, user.getId().longValue());
        Assert.assertEquals(date, user.getCreated());
        Assert.assertEquals(date, user.getLastLogin());
        Assert.assertEquals("123ijAkdhuisah324908lajif", user.getToken());
        Assert.assertEquals(true, user.getIsActive());
    }
}
