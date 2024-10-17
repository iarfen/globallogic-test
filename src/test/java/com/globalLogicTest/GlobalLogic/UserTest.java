package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.dto.RegisterUserDTO;
import com.globalLogicTest.model.Phone;
import com.globalLogicTest.model.User;
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
public class UserTest {

    @Test
    public void givenGetters_whenInstantiating_thenReturnCorrectValues() throws Exception {
        Phone phone1 = Phone.builder().number(11234322L).citycode(9L).countrycode(56L).build();
        List<Phone> userPhones = new ArrayList<>();
        userPhones.add(phone1);
        Date date = new Date();
        User user = User.builder()
                .id(1L)
                .name("user1")
                .email("user1@gmail.com")
                .password("Qweriuq29")
                .phones(userPhones)
                .createdAt(date)
                .lastLogin(date)
                .isActive(true)
                .build();

        Assert.assertEquals(1L, user.getId().longValue());
        Assert.assertEquals("user1", user.getName());
        Assert.assertEquals("user1@gmail.com", user.getEmail());
        Assert.assertEquals("Qweriuq29", user.getPassword());
        Assert.assertEquals(userPhones, user.getPhones());
        Assert.assertEquals(date, user.getCreatedAt());
        Assert.assertEquals(date, user.getLastLogin());
        Assert.assertEquals(true, user.getIsActive());

        User user2 = new User(1L, "user1","user1@gmail.com","Qweriuq29",userPhones,date,date,true);
        Assert.assertEquals(true, user.equals(user2));
        Assert.assertEquals(user.hashCode(), user.hashCode());
        Assert.assertNotEquals(0, user.toString().length());
        Assert.assertNotEquals(0, user.builder().toString().length());
    }

    @Test
    public void givenSetters_whenUsingGetters_thenReturnCorrectValues() throws Exception {
        Phone phone1 = Phone.builder().number(11234322L).citycode(9L).countrycode(56L).build();
        List<Phone> userPhones = new ArrayList<>();
        userPhones.add(phone1);
        Date date = new Date();
        User user = new User();
        user.setId(1L);
        user.setName("user1");
        user.setEmail("user1@gmail.com");
        user.setPassword("Qweriuq29");
        user.setPhones(userPhones);
        user.setCreatedAt(date);
        user.setLastLogin(date);
        user.setIsActive(true);

        Assert.assertEquals(1L, user.getId().longValue());
        Assert.assertEquals("user1", user.getName());
        Assert.assertEquals("user1@gmail.com", user.getEmail());
        Assert.assertEquals("Qweriuq29", user.getPassword());
        Assert.assertEquals(userPhones, user.getPhones());
        Assert.assertEquals(date, user.getCreatedAt());
        Assert.assertEquals(date, user.getLastLogin());
        Assert.assertEquals(true, user.getIsActive());
    }

    @Test
    public void givenUserDetails_whenInstantiating_thenReturnCorrectValues() throws Exception {
        Phone phone1 = Phone.builder().number(11234322L).citycode(9L).countrycode(56L).build();
        List<Phone> userPhones = new ArrayList<>();
        userPhones.add(phone1);
        Date date = new Date();
        User user = User.builder()
                .id(1L)
                .name("user1")
                .email("user1@gmail.com")
                .password("Qweriuq29")
                .phones(userPhones)
                .createdAt(date)
                .lastLogin(date)
                .isActive(true)
                .build();

        Assert.assertEquals(0, user.getAuthorities().size());
        Assert.assertEquals("user1@gmail.com", user.getUsername());
        Assert.assertEquals(true, user.isAccountNonExpired());
        Assert.assertEquals(true, user.isAccountNonLocked());
        Assert.assertEquals(true, user.isCredentialsNonExpired());
        Assert.assertEquals(true, user.isEnabled());
    }
}
