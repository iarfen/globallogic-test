package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.model.Phone;
import com.globalLogicTest.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PhoneTest {

    @Test
    public void givenGetters_whenInstantiating_thenReturnCorrectValues() throws Exception {
        Phone phone = Phone.builder().id(1L).number(11234322L).citycode(9L).countrycode(56L).build();

        Assert.assertEquals(1L, phone.getId().longValue());
        Assert.assertEquals(11234322L, phone.getNumber().longValue());
        Assert.assertEquals(9L, phone.getCitycode().longValue());
        Assert.assertEquals(56L, phone.getCountrycode().longValue());

        Phone phone2 = new Phone(1L,11234322L, 9L,56L);
        Assert.assertEquals(true, phone.equals(phone2));
        Assert.assertEquals(phone.hashCode(), phone.hashCode());
        Assert.assertNotEquals(0, phone.toString().length());
        Assert.assertNotEquals(0, phone.builder().toString().length());
    }

    @Test
    public void givenSetters_whenUsingGetters_thenReturnCorrectValues() throws Exception {
        Phone phone = new Phone();
        phone.setId(1L);
        phone.setNumber(11234322L);
        phone.setCitycode(9L);
        phone.setCountrycode(56L);

        Assert.assertEquals(1L, phone.getId().longValue());
        Assert.assertEquals(11234322L, phone.getNumber().longValue());
        Assert.assertEquals(9L, phone.getCitycode().longValue());
        Assert.assertEquals(56L, phone.getCountrycode().longValue());
    }
}
