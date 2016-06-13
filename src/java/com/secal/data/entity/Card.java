package com.secal.data.entity;

import com.secal.base.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Card extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardId")
    private long cardId;
    @Column(name = "cardNumber")
    private long cardNumber;
    @Column(name = "customerName")
    private String customerName;
    private String nameOf_Bank;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Satis> satisList;

    //<editor-fold defaultstate="collapsed" desc="Getter - Setter">
    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Satis> getSatisList() {
        return satisList;
    }

    public void setSatisList(List<Satis> satisList) {
        this.satisList = satisList;
    }
    public String getNameOf_Bank() {
        return nameOf_Bank;
    }

    public void setNameOf_Bank(String nameOf_Bank) {
        this.nameOf_Bank = nameOf_Bank;
    }
//</editor-fold>

    
    
            
}
