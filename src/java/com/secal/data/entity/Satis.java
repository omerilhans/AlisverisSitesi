package com.secal.data.entity;

import com.secal.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SATIS")
public class Satis extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "satisId")
    private long satisId;

    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;

    @Column(name = "productId")
    private long productId;

    @Column(name = "satisAdet")
    private int satisAdet;

    @Column(name = "toplamTutar")
    private double toplamTutar;

    @Column(name = "birimFiyat")
    private double birimFiyat;

    //<editor-fold defaultstate="collapsed" desc="Getter-Setter">
    public long getSatisId() {
        return satisId;
    }

    public void setSatisId(long satisId) {
        this.satisId = satisId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getSatisAdet() {
        return satisAdet;
    }

    public void setSatisAdet(int satisAdet) {
        this.satisAdet = satisAdet;
    }

    public double getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(double toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public void setBirimFiyat(double birimFiyat) {
        this.birimFiyat = birimFiyat;
    }

    public double getBirimFiyat() {
        return birimFiyat;
    }
//</editor-fold>
}
