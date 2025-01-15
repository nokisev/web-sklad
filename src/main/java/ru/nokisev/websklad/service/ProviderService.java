package ru.nokisev.websklad.service;

import ru.nokisev.websklad.entity.Provider;
import ru.nokisev.websklad.error.ProviderNotFoundException;

import java.util.List;

public interface ProviderService {
    public Provider saveProvider(Provider provider);

    public List<Provider> fetchProviderList();

    public Provider fetchProviderById(Long providerId)
            throws ProviderNotFoundException;

    public void deleteProviderById(Long providerId);

    Provider updateProvider(Long providerId, Provider provider);

    Provider fetchProviderByName(String providerName);
}
