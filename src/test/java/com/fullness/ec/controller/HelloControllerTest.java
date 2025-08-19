package com.fullness.ec.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * HelloControllerの単体テストドライバ
 */
@WebMvcTest(HelloController.class) 
@AutoConfigureMockMvc(addFilters = false) // Securityフィルタ無効化
public class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /hello で Hello World! が返ること")
    void testHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }
}
