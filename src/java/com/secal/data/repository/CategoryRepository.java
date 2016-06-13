package com.secal.data.repository;

import com.secal.data.entity.Category;
import com.secal.base.BaseRepository;

public class CategoryRepository extends BaseRepository<Category> {

    public CategoryRepository() {
        super(Category.class);
    }

}
