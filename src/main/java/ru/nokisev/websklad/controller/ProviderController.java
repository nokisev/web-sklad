package ru.nokisev.websklad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nokisev.websklad.entity.Provider;
import ru.nokisev.websklad.service.ProviderService;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping("/providers")
    public Provider saveProvider(@RequestBody Provider provider) {
        return providerService.saveProvider(provider);
    }

    @GetMapping("/providers")
    public List<Provider> fetchProviderList() {
        return providerService.fetchProviderList();
    }

    @GetMapping("/providers/{id}")
    public Provider fetchProviderById(@PathVariable("id") Long providerId) {
        return providerService.fetchProviderById(providerId);
    }

    @DeleteMapping("/providers/{id}")
    public String deleteProviderById(@PathVariable("id") Long providerId) {
        providerService.deleteProviderById(providerId);
        return "Provider deleted Successfully!";
    }

    @PutMapping("/providers/{id}")
    public Provider updateProvider(@PathVariable("id") Long providerId,
                                   @RequestBody Provider provider) {
        return providerService.updateProvider(providerId, provider);
    }

    @GetMapping("/provider/name/{name}")
    public Provider fetchProviderByName(@PathVariable("name") String providerName) {
        return providerService.fetchProviderByName(providerName);
    }


}
