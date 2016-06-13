package com.secal.data.entity;

import com.secal.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDITCARD")
public class CreditCard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accnt_id")
    private long accnt_id;
    @Column(name = "cardOwnerName")
    private String cardOwnerName;
    @Column(name = "cardBalance")
    private int cardBalance;
    @Column(name = "cardLimit")
    private int cardLimit;
    @Column(name = "cardType")
    private String cardType;


    //<editor-fold defaultstate="collapsed" desc="Getter - Setter">  
    public long getAccnt_id() {
        return accnt_id;
    }

    public void setAccnt_id(long accnt_id) {
        this.accnt_id = accnt_id;
    }

    public String getCardOwnerName() {
        return cardOwnerName;
    }

    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }

    public int getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(int cardLimit) {
        this.cardLimit = cardLimit;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
//</editor-fold>

}
