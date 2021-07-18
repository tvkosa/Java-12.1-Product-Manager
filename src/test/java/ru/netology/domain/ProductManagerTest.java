package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager manager = new ProductManager(productRepository);

    private Book item1 = new Book(1, "Полет Дракона", "Энн Маккефри");
    private Book item2 = new Book(2, "Странствия Дракона", "Энн Маккефри");
    private Book item3 = new Book(3, "Все вейры Перна", "Энн Маккефри");
    private Book item4 = new Book(4, "Стальная крыса", "Гарри Гаррисон");
    private Smartphone item5 = new Smartphone(6, "Poco X3", "Xiaomi");
    private Smartphone item6 = new Smartphone(7, "Mi 11", "Xiaomi");
    private Smartphone item7 = new Smartphone(8, "iPhone 12", "Apple");

    @BeforeEach
    public void setUp() {
        manager.addProduct(item1);
        manager.addProduct(item2);
        manager.addProduct(item3);
        manager.addProduct(item4);
        manager.addProduct(item5);
        manager.addProduct(item6);
        manager.addProduct(item7);
    }

    @Test
    public void shouldFindBookByAuthorIfManyProducts() {
        Product[] actual = manager.searchBy("Гарри Гаррисон");
        Product[] expected = new Product[]{item4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullWhenFindBookByAuthorIfNoProducts() {
        Product[] actual = manager.searchBy("Розовые розы");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullWhenFindSmartphoneByManufacturerIfNoProducts() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAllProducts() {
        String text = "Xiaomi";

        Product[] expected = new Product[]{item5, item6};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
}
