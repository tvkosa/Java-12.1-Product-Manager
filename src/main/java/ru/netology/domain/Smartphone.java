package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, String manufacturer) {
        super(id, name);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || manufacturer.contains(search);
    }
}

