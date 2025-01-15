package ru.nokisev.websklad.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.nokisev.websklad.entity.Provider;
import ru.nokisev.websklad.error.ProviderNotFoundException;
import ru.nokisev.websklad.service.ProviderService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProviderController.class)
class ProviderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProviderService providerService;

    private Provider provider;

    @BeforeEach
    void setUp() {

        provider = Provider.builder()
                .providerName("ROSE")
                .providerAddress("Новый Арбат ул., 68, Москва, 176744")
                .providerPhone("+7960 198 89 74")
                .providerId(1L)
                .build();
    }

    @Test
    void saveProvider() throws Exception {
        Provider inputProvider = Provider.builder()
                .providerName("ROSE")
                .providerAddress("Новый Арбат ул., 68, Москва, 176744")
                .providerPhone("+7960 198 89 74")
                .build();

        Mockito.when(providerService.saveProvider(inputProvider))
                .thenReturn(provider);

        mockMvc.perform(post("/providers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"providerName\": \"ROSE\",\n" +
                        "    \"providerAddress\": \"Новый Арбат ул., 68, Москва, 176744\",\n" +
                        "    \"providerPhone\": \"+7960 198 89 74\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchProviderById() throws Exception {
        Mockito.when(providerService.fetchProviderById(1L))
                .thenReturn(provider);

        mockMvc.perform(get("/providers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.providerName").
                        value(provider.getProviderName()));
    }
}