package ru.nokisev.websklad.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long providerId;

    @NotBlank(message = "Похоже Вы не указали название поставщика.")
    private String providerName;
    private String providerAddress;
    private String providerPhone;

}
