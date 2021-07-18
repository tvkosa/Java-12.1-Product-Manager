package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class Book extends Product {
    private String bookAuthor;

    public Book(int id, String name, String bookAuthor) {
        super(id, name);
        this.bookAuthor = bookAuthor;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || bookAuthor.contains(search);
    }
}
