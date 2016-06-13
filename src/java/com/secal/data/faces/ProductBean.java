package com.secal.data.faces;

import com.secal.data.entity.Category;
import com.secal.data.entity.Product;
import com.secal.data.repository.CategoryRepository;
import com.secal.data.repository.ProductRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class ProductBean {

    ProductRepository productRepo;
    CategoryRepository categoryRepo;

    private List<Product> productList;
    private Product product;

    private long selectedCategoryId;
    private double fiyat;

    public ProductBean() {
        System.out.println("ProductBean'den Geçti");

        productRepo = new ProductRepository();
        categoryRepo = new CategoryRepository();
        productList = productRepo.list();

        product = new Product();
        long productId = 0;
        long categoryId = 0;

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();

        if (request.getParameter("productId") != null) {
            productId = Long.parseLong(request.getParameter("productId"));
        }
        if (request.getParameter("categoryId") != null) {
            categoryId = Long.parseLong(request.getParameter("categoryId"));
        }
        if (productId != 0) {
            product = productRepo.find(productId);
        }
        if (categoryId != 0) {
            productList = productRepo.listProduct_ByCategoryId(categoryId);
        }
    }

    public void save() {
        productRepo = new ProductRepository();
        setting_CategoryOfProduct();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        long productId = 0;
        if (request.getParameter("productId") != null) {
            productId = Long.parseLong(request.getParameter("productId"));
        }
        if (productId == 0) {
            productRepo.persist(product);
        } else {
            productRepo.merge(product);
        }
        productRepo.close();
    }

    public void delete() {
        productRepo = new ProductRepository();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        long productId = 0;
        if (request.getParameter("productId") != null) {
            productId = Long.parseLong(request.getParameter("productId"));
        }
        if (productId != 0) {
            productRepo.remove(productId);
            if (selectedCategoryId == 0) {
                productList = productRepo.list();
            } else {
                productList = productRepo.listProduct_ByCategoryId(selectedCategoryId);
            }
            productRepo.close();
        }
    }

    public void setting_CategoryOfProduct() {
        categoryRepo = new CategoryRepository();
        if (selectedCategoryId != 0) {
            Category kategori = categoryRepo.find(selectedCategoryId);
            product.setCategory(kategori);
        }
        categoryRepo.close();
    }

    //<editor-fold defaultstate="collapsed" desc="Get - Set">
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getSelectedCategoryId() {
        return selectedCategoryId;
    }

    public void setSelectedCategoryId(long selectedCategoryId) {
        this.selectedCategoryId = selectedCategoryId;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
//</editor-fold>
}
