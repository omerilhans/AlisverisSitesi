package com.secal.data.faces;

import com.secal.data.entity.Category;
import com.secal.data.repository.CategoryRepository;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class LifeBean {

    public List<Category> getCategoryList() {
        System.out.println("LifeBean'den Geçti");
        String jpql = "select category from Category as category";
        CategoryRepository repo = new CategoryRepository();
        List<Category> categoryList = repo.list();
        repo.close();
        return categoryList;
    }
}
