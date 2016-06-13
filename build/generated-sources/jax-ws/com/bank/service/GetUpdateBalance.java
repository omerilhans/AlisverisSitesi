
package com.bank.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getUpdateBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUpdateBalance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hesapNumarasi" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="hesapTutari" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUpdateBalance", propOrder = {
    "hesapNumarasi",
    "hesapTutari"
})
public class GetUpdateBalance {

    protected int hesapNumarasi;
    protected int hesapTutari;

    /**
     * Gets the value of the hesapNumarasi property.
     * 
     */
    public int getHesapNumarasi() {
        return hesapNumarasi;
    }

    /**
     * Sets the value of the hesapNumarasi property.
     * 
     */
    public void setHesapNumarasi(int value) {
        this.hesapNumarasi = value;
    }

    /**
     * Gets the value of the hesapTutari property.
     * 
     */
    public int getHesapTutari() {
        return hesapTutari;
    }

    /**
     * Sets the value of the hesapTutari property.
     * 
     */
    public void setHesapTutari(int value) {
        this.hesapTutari = value;
    }

}
