package ru.nokisev.websklad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nokisev.websklad.entity.Provider;
import ru.nokisev.websklad.error.ProviderNotFoundException;
import ru.nokisev.websklad.repository.ProviderRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {


    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public List<Provider> fetchProviderList() {
        return providerRepository.findAll();
    }

    @Override
    public Provider fetchProviderById(Long providerId)
            throws ProviderNotFoundException {
        Optional<Provider> provider =
                providerRepository.findById(providerId);
        if (!provider.isPresent()) {
            throw new ProviderNotFoundException("Поставщик с таким индентификатором не найден");
        }

        return provider.get();
    }

    @Override
    public void deleteProviderById(Long providerId) {
        providerRepository.deleteById(providerId);
    }

    @Override
    public Provider updateProvider(Long providerId, Provider provider) {

        Provider provDB = providerRepository.findById(providerId).get();

        if (Objects.nonNull(provider.getProviderName()) &&
                !"".equalsIgnoreCase(provider.getProviderName())) {
            provDB.setProviderName(provider.getProviderName());
        }
        if (Objects.nonNull(provider.getProviderAddress()) &&
                !"".equalsIgnoreCase(provider.getProviderAddress())) {
            provDB.setProviderAddress(provider.getProviderAddress());
        }
        if (Objects.nonNull(provider.getProviderPhone()) &&
                !"".equalsIgnoreCase(provider.getProviderPhone())) {
            provDB.setProviderPhone(provider.getProviderPhone());
        }

        return providerRepository.save(provDB);
    }

    @Override
    public Provider fetchProviderByName(String providerName) {
        return providerRepository.findByProviderNameIgnoreCase(providerName);
    }
}
