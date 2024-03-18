package org.nqh.asm2.service.impl;

import org.nqh.asm2.pojo.Category;
import org.nqh.asm2.repository.CategoryRepository;
import org.nqh.asm2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }
}
