package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int cost, String manufacturer) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }
    public Smartphone(String manufacturer) {
        this.manufacturer = manufacturer;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Smartphone that = (Smartphone) o;
//        return Objects.equals(manufacturer, that.manufacturer);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), manufacturer);
//    }
}

