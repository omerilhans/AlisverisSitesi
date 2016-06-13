
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

    private final static QName _GetUpdateBalance_QNAME = new QName("http://service.bank.com/", "getUpdateBalance");
    private final static QName _GetUpdateBalanceResponse_QNAME = new QName("http://service.bank.com/", "getUpdateBalanceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bank.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUpdateBalance }
     * 
     */
    public GetUpdateBalance createGetUpdateBalance() {
        return new GetUpdateBalance();
    }

    /**
     * Create an instance of {@link GetUpdateBalanceResponse }
     * 
     */
    public GetUpdateBalanceResponse createGetUpdateBalanceResponse() {
        return new GetUpdateBalanceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUpdateBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bank.com/", name = "getUpdateBalance")
    public JAXBElement<GetUpdateBalance> createGetUpdateBalance(GetUpdateBalance value) {
        return new JAXBElement<GetUpdateBalance>(_GetUpdateBalance_QNAME, GetUpdateBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUpdateBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bank.com/", name = "getUpdateBalanceResponse")
    public JAXBElement<GetUpdateBalanceResponse> createGetUpdateBalanceResponse(GetUpdateBalanceResponse value) {
        return new JAXBElement<GetUpdateBalanceResponse>(_GetUpdateBalanceResponse_QNAME, GetUpdateBalanceResponse.class, null, value);
    }

}
