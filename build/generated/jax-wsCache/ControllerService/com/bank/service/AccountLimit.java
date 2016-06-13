
package com.bank.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountLimit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountLimit"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="balanceCard" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="limitCard" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="nameOf_Bank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountLimit", propOrder = {
    "balanceCard",
    "limitCard",
    "nameOfBank"
})
public class AccountLimit {

    protected long balanceCard;
    protected long limitCard;
    @XmlElement(name = "nameOf_Bank")
    protected String nameOfBank;

    /**
     * Gets the value of the balanceCard property.
     * 
     */
    public long getBalanceCard() {
        return balanceCard;
    }

    /**
     * Sets the value of the balanceCard property.
     * 
     */
    public void setBalanceCard(long value) {
        this.balanceCard = value;
    }

    /**
     * Gets the value of the limitCard property.
     * 
     */
    public long getLimitCard() {
        return limitCard;
    }

    /**
     * Sets the value of the limitCard property.
     * 
     */
    public void setLimitCard(long value) {
        this.limitCard = value;
    }

    /**
     * Gets the value of the nameOfBank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfBank() {
        return nameOfBank;
    }

    /**
     * Sets the value of the nameOfBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfBank(String value) {
        this.nameOfBank = value;
    }

}
