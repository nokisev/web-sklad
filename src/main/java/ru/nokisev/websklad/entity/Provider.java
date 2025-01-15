package ru.nokisev.websklad.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long providerId;
    private String  providerName;
    private String providerAddress;
    private String providerPhone;

    public Provider() {
    }

    public Provider(Long providerId, String providerName, String providerAddress, String providerPhone) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.providerAddress = providerAddress;
        this.providerPhone = providerPhone;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerId=" + providerId +
                ", providerName='" + providerName + '\'' +
                ", providerAddress='" + providerAddress + '\'' +
                ", providerPhone='" + providerPhone + '\'' +
                '}';
    }
}
