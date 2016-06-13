package com.secal.data.repository;

import com.secal.base.BaseRepository;
import com.secal.data.entity.CreditCard;

public class CreditCardRepository extends BaseRepository<CreditCard> {

    public CreditCardRepository() {
        super(CreditCard.class);
    }

}
