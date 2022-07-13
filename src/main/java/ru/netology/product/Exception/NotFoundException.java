package ru.netology.product.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String a) {
        super(a);
    }
}
