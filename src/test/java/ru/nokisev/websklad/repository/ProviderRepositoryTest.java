package ru.nokisev.websklad.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.nokisev.websklad.entity.Provider;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class ProviderRepositoryTest {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Provider provider =
                Provider.builder()
                .providerName("ROSE")
                .providerAddress("Новый Арбат ул., 68, Москва, 176744")
                .providerPhone("+7960 198 89 74")
                .build();

        entityManager.persist(provider);
    }

    @Test
    public void whenFindById_thenReturnProvider() {
        Provider provider = providerRepository.findById(1L).get();

        assertEquals(provider.getProviderName(), "ROSE");
    }
}