
package com.bank.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bank.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LookLikeBalance_QNAME = new QName("http://service.bank.com/", "lookLikeBalance");
    private final static QName _LookLikeBalanceResponse_QNAME = new QName("http://service.bank.com/", "lookLikeBalanceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bank.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LookLikeBalance }
     * 
     */
    public LookLikeBalance createLookLikeBalance() {
        return new LookLikeBalance();
    }

    /**
     * Create an instance of {@link LookLikeBalanceResponse }
     * 
     */
    public LookLikeBalanceResponse createLookLikeBalanceResponse() {
        return new LookLikeBalanceResponse();
    }

    /**
     * Create an instance of {@link AccountLimit }
     * 
     */
    public AccountLimit createAccountLimit() {
        return new AccountLimit();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookLikeBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bank.com/", name = "lookLikeBalance")
    public JAXBElement<LookLikeBalance> createLookLikeBalance(LookLikeBalance value) {
        return new JAXBElement<LookLikeBalance>(_LookLikeBalance_QNAME, LookLikeBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookLikeBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bank.com/", name = "lookLikeBalanceResponse")
    public JAXBElement<LookLikeBalanceResponse> createLookLikeBalanceResponse(LookLikeBalanceResponse value) {
        return new JAXBElement<LookLikeBalanceResponse>(_LookLikeBalanceResponse_QNAME, LookLikeBalanceResponse.class, null, value);
    }

}
