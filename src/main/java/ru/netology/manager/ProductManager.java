package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static java.lang.System.arraycopy;

public class ProductManager {
    public ProductManager(ProductRepository repository, Product[] items) {
        this.repository = repository;
        this.items = items;
    }
    private ProductRepository repository = new ProductRepository();
    private Product[] items = new Product[0];

    public ProductManager(ProductRepository repository) {
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] getItems() {
        return items;
    }

    public void setItems(Product[] items) {
        this.items = items;
    }

    public void addProduct(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}

