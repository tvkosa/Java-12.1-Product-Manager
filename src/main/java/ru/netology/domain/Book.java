package ru.netology.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String bookAuthor;

    public Book(int id, String name, int cost, String bookAuthor) {
        super(id, name, cost);
        this.bookAuthor = bookAuthor;
    }

    public Book(String author) {
        this.bookAuthor = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(bookAuthor, book.bookAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bookAuthor);
    }
}
