package com.example.testapp.services;

import com.example.testapp.models.Product;
import com.example.testapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

// 1. Аннотация, помечающая класс как Spring-бин сервиса
@Service
public class ProductService {

    // 2. Внедрение зависимости ProductRepository
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional
    public Product createProduct(String name, Double price, String category, Integer stock) {
        return productRepository.save(new Product(name, price, category, stock));
    }


    // Получение продукта по ID
    @Transactional(readOnly = true) // Оптимизация: только для чтения данных
    public Optional<Product> getProductById(Long id) {
        // Используем метод findById() из JpaRepository
        return productRepository.findById(id);
    }

    // Получение всех продуктов
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        // Используем метод findAll() из JpaRepository
        return productRepository.findAll();
    }

    // Поиск продуктов по имени (partial, case-insensitive)
    @Transactional(readOnly = true)
    public List<Product> findProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional(readOnly = true)
    public Optional<Product> findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    // Обновление продукта
    @Transactional
    public Product updateProductPrice(Long id, Double newPrice) {
        // Сначала находим сущность
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Продукт с ID " + id + " не найден"));

        // Изменяем поле
        product.setPrice(newPrice);

        // Сохраняем измененную сущность.
        // Метод save() также используется для обновления, если объект имеет существующий ID.
        return productRepository.save(product);
    }

    // Удаление продукта
    @Transactional
    public boolean deleteProduct(Long id) {
        try{
        // Используем метод deleteById() из JpaRepository
            Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Продукт с ID " + id + " не найден"));
            productRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }


}