package com.globalLogicTest.GlobalLogic;

import com.globalLogicTest.GlobalLogicTestApplication;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ServletInitializerTest {

    @MockBean
    private SpringApplicationBuilder springApplicationBuilder;

    @Test
    public void testServletInitializer() {
        ServletInitializer servletInitializer = new ServletInitializer();
        when(springApplicationBuilder.sources(GlobalLogicTestApplication.class)).thenReturn(springApplicationBuilder);

        SpringApplicationBuilder result = servletInitializer.configure(springApplicationBuilder);

        verify(springApplicationBuilder).sources(GlobalLogicTestApplication.class);
        Assert.assertEquals(springApplicationBuilder,result);
    }
}
