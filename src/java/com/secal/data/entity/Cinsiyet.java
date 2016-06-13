
package com.secal.data.entity;

import com.secal.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="Cinsiyet")
public class Cinsiyet extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cId")
    private short cId;
    @Column(name = "cinsiyet")
    private char cinsiyet;

    //<editor-fold defaultstate="collapsed" desc="Getter - Setter">
    public short getcId() {
        return cId;
    }
    
    public void setcId(short cId) {
        this.cId = cId;
    }
    
    public char getCinsiyet() {
        return cinsiyet;
    }
    
    public void setCinsiyet(char cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
//</editor-fold>
}
