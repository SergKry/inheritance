package ru.netology.product.Repository;

import ru.netology.product.Product.Product;
import ru.netology.product.Exception.NotFoundException;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] getAll() {
        return products.clone();
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Товара с id " + id + "нет в катологе товаров");
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


}



