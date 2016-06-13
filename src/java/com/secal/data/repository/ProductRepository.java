package com.secal.data.repository;

import com.secal.data.entity.Product;
import com.secal.base.BaseRepository;
import java.util.List;
import javax.persistence.Query;

public class ProductRepository extends BaseRepository<Product> {

    public ProductRepository() {
        super(Product.class);
    }

    public List<Product> listProduct_ByCategoryId(long categoryId) {
        String jpql = "select product from Product as product where product.category.categoryId=:categoryId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

}
