package com.secal.data.faces;

import com.secal.data.entity.Category;
import com.secal.data.repository.CategoryRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class CategoryBean {

    CategoryRepository categoryRepo;

    private List<Category> categoryList;
    private Category category;

    public CategoryBean() {
        categoryRepo = new CategoryRepository();
        category = new Category();
        System.out.println("CategoryBean'den Geçti");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        long categoryId = 0;
        if (request.getParameter("categoryId") != null) {
            categoryId = new Long(request.getParameter("categoryId"));
        }
        if (categoryId == 0) {
            category.setCategoryId(0);
            category.setCategoryName("Adsiz");
        } else {
            category = categoryRepo.find(categoryId);
        }
        categoryList = categoryRepo.list();
    }

    public void save() {
        categoryRepo = new CategoryRepository();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        long categoryId = 0;
        if (request.getParameter("categoryId") != null) {
            categoryId = Long.parseLong(request.getParameter("categoryId"));
        }
        if (categoryId == 0) {
            categoryRepo.persist(category);
        } else {
            categoryRepo.merge(category);
        }
        categoryRepo.close();
    }

    public void delete() {
        categoryRepo = new CategoryRepository();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        long categoryId = 0;
        if (request.getParameter("categoryId") != null) {
            categoryId = Long.parseLong(request.getParameter("categoryId"));
        }
        if (categoryId != 0) {
            categoryRepo.remove(categoryId);
            categoryList = categoryRepo.list();
            categoryRepo.close();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getter - Setter">
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
//</editor-fold>
}
