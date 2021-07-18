package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int idToFind) {
        for (Product item : items) {
            if (item.getId() == idToFind) {
                return item;
            }
        }
        return null;
    }

    public Product removeById(int idToRemove) {
        if (idToRemove > items.length) {
            System.out.println("Не найден продукт с ID");
            return null;
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != idToRemove) {
                tmp[index] = item;
                index++;
            }
        }
        return null;
    }
}