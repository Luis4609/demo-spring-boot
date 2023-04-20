package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.DemoService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DemoController.class)
public class DemoControllerTest {

    @MockBean
    DemoService demoService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {
        Customer employee = new Customer(32332L, "Gupta");
        List<Customer> employees = Arrays.asList(employee);

        Mockito.when(demoService.findAll()).thenReturn(employees);

        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].firstName", Matchers.is("Lokesh")));
    }
}
