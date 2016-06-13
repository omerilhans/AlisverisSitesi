package com.secal.data.entity;

import com.secal.data.entity.Satis;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-06T15:30:58")
@StaticMetamodel(Card.class)
public class Card_ { 

    public static volatile ListAttribute<Card, Satis> satisList;
    public static volatile SingularAttribute<Card, Long> cardId;
    public static volatile SingularAttribute<Card, Long> cardNumber;
    public static volatile SingularAttribute<Card, String> customerName;
    public static volatile SingularAttribute<Card, String> nameOf_Bank;

}