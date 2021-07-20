package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager manager = new ProductManager(productRepository);

    private Book item1 = new Book(1, "Полет Дракона", 500, "Энн Маккефри");
    private Book item2 = new Book(2, "Странствия Дракона", 600, "Энн Маккефри");
    private Book item3 = new Book(3, "Все вейры Перна", 700, "Энн Маккефри");
    private Book item4 = new Book(4, "Стальная крыса", 800, "Гарри Гаррисон");
    private Smartphone item5 = new Smartphone(6, "Poco X3", 900, "Xiaomi");
    private Smartphone item6 = new Smartphone(7, "Mi 11", 1000, "Xiaomi");
    private Smartphone item7 = new Smartphone(8, "iPhone 12", 2000, "Apple");

    @BeforeEach
    public void setUp() {
        productRepository.save(item1);
        productRepository.save(item2);
        productRepository.save(item3);
        productRepository.save(item4);
        productRepository.save(item5);
        productRepository.save(item6);
        productRepository.save(item7);
    }

    @Test
    public void shouldSearchBookByAuthor() {
        Product[] actual = manager.searchBy("Гарри Гаррисон");
        Product[] expected = new Product[]{item4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByName() {
        Product[] actual = manager.searchBy("Дракона");
        Product[] expected = new Product[]{item1, item2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByAuthorIfNoProducts() {
        Product[] actual = manager.searchBy("Розовые розы");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByNameIfNoProducts() {
        Product[] actual = manager.searchBy("Незнайка на луне");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName() {
        Product[] actual = manager.searchBy("iPhone 12");
        Product[] expected = new Product[]{item7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByManufacturer() {
        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = new Product[]{item5, item6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByNameIfNoProducts() {
        Product[] actual = manager.searchBy("Nokia 360");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByManufacturerIfNoProducts() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}
