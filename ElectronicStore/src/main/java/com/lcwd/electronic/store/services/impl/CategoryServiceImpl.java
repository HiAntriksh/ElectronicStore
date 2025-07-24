package com.lcwd.electronic.store.services.impl;

import com.lcwd.electronic.store.dtos.CategoryDto;
import com.lcwd.electronic.store.dtos.PageableResponse;
import com.lcwd.electronic.store.entities.Category;
import com.lcwd.electronic.store.exceptions.ResourceNotFoundException;
import com.lcwd.electronic.store.helper.Helper;
import com.lcwd.electronic.store.repositories.CategoryRepository;
import com.lcwd.electronic.store.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        Category saveCategory = categoryRepository.save(category);
        return mapper.map(saveCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {
        // get category of given id
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found Exception"));

        // Update category details from DTO
        category.setTitle(categoryDto.getTitle());
        category.setDescrition(categoryDto.getDescription());
        category.setCoverImage(categoryDto.getCoverImage());
        // Save updated category
        Category updatedCategory = categoryRepository.save(category);
        // Return updated DTO
        return mapper.map(updatedCategory, CategoryDto.class);
    }

    @Override
    public void delete(String categoryId) {
        // 1. Fetch the category from the database
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + categoryId));
        // 2. Delete the category
        categoryRepository.delete(category);
    }

    @Override
    public PageableResponse<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        // 1. Create Sort object
        Sort sort = (sortDir.equalsIgnoreCase("desc")) ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();
        // 2. Create Pageable object
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        // 3. Get Page<Category>
        Page<Category> page = categoryRepository.findAll(pageable);
        // 4. Convert to PageableResponse using helper method
        PageableResponse<CategoryDto> pageableResponse = Helper.getPagebleResponse(page, CategoryDto.class);
        return pageableResponse;
    }

    @Override
    public CategoryDto get(String categoryId) {
        // 1. Get category from DB or throw exception
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + categoryId));
        // 2. Convert entity to DTO using mapper
        return mapper.map(category, CategoryDto.class);
    }

}
