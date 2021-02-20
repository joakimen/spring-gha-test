package com.example.springghatest.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greet_withNoName_shouldReturnDefaultGreeting() throws Exception {
        final var expected = "Hello World";
        mockMvc.perform(get("/greet").accept(APPLICATION_JSON)).andExpect(content().string(containsString(expected)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Jerry", "Newman"})
    void greet_withName_returnsPersonalizedGreeting(String name) throws Exception {
        final var expected = String.format("Hello %s", name);
        mockMvc.perform(get("/greet").param("name", name).accept(APPLICATION_JSON)).andExpect(content().string(containsString(expected)));
    }

    

}
