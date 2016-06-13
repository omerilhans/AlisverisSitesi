
package com.bank.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lookLikeBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lookLikeBalance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numberCard" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lookLikeBalance", propOrder = {
    "numberCard"
})
public class LookLikeBalance {

    protected long numberCard;

    /**
     * Gets the value of the numberCard property.
     * 
     */
    public long getNumberCard() {
        return numberCard;
    }

    /**
     * Sets the value of the numberCard property.
     * 
     */
    public void setNumberCard(long value) {
        this.numberCard = value;
    }

}
