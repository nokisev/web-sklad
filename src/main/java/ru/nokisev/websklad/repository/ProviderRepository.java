package ru.nokisev.websklad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nokisev.websklad.entity.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    public Provider findByProviderName(String providerName);

    public Provider findByProviderNameIgnoreCase(String providerName);
}
