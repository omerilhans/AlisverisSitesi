package com.secal.data.entity;

import com.secal.data.entity.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-06T15:30:58")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> productQuantity;
    public static volatile SingularAttribute<Product, Long> productId;
    public static volatile SingularAttribute<Product, Double> salesPrice;
    public static volatile SingularAttribute<Product, Category> category;
    public static volatile SingularAttribute<Product, String> productName;

}