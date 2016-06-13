package com.secal.data.entity;

import com.secal.data.entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-06T15:30:58")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> categoryName;
    public static volatile SingularAttribute<Category, Long> categoryId;
    public static volatile ListAttribute<Category, Product> productList;

}