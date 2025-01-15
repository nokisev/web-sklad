package ru.nokisev.websklad.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import ru.nokisev.websklad.entity.Provider;
import ru.nokisev.websklad.repository.ProviderRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProviderServiceTest {

    @Autowired
    private ProviderService providerService;

    @MockitoBean
    private ProviderRepository providerRepository;

    @BeforeEach
    void setUp() {
        Provider provider =
                Provider.builder()
                        .providerName("ROSE")
                        .providerAddress("Новый Арбат ул., 68, Москва, 176744")
                        .providerPhone("+7 (495)-444-44-44")
                        .providerId(1L)
                        .build();

        Mockito.when(providerRepository.findByProviderNameIgnoreCase("ROSE"))
                .thenReturn(provider);
    }

    @Test
    @DisplayName("Get Data based on Valid Provider Name")
    public void whenValueProviderName_thenProviderShouldFound() {
        String providerName = "ROSE";
        Provider found =
                providerService.fetchProviderByName(providerName);

        assertEquals(providerName, found.getProviderName());
    }
}