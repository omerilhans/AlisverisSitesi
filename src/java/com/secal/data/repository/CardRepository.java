package com.secal.data.repository;

import com.secal.data.entity.Card;
import com.secal.base.BaseRepository;

public class CardRepository extends BaseRepository<Card> {

    public CardRepository() {
        super(Card.class);
    }

}
