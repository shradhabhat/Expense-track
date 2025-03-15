package com.practice.restful_web_services.entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.restful_web_services.repository.CategoryRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryDataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public CategoryDataInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<CategoryEntity> defaultCategories = Arrays.stream(Category.values())
                    .map(cat -> new CategoryEntity(cat.name(), cat.getIconClass()))
                    .toList();
            categoryRepository.saveAll(defaultCategories);
            System.out.println("Default categories have been initialized.");
        } else {
            System.out.println("Categories already exist. Skipping initialization.");
        }
    }
}
