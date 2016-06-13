
package com.bank.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ControllerService", targetNamespace = "http://service.bank.com/", wsdlLocation = "http://localhost:8080/BankService/ControllerService?WSDL")
public class ControllerService
    extends Service
{

    private final static URL CONTROLLERSERVICE_WSDL_LOCATION;
    private final static WebServiceException CONTROLLERSERVICE_EXCEPTION;
    private final static QName CONTROLLERSERVICE_QNAME = new QName("http://service.bank.com/", "ControllerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/BankService/ControllerService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONTROLLERSERVICE_WSDL_LOCATION = url;
        CONTROLLERSERVICE_EXCEPTION = e;
    }

    public ControllerService() {
        super(__getWsdlLocation(), CONTROLLERSERVICE_QNAME);
    }

    public ControllerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONTROLLERSERVICE_QNAME, features);
    }

    public ControllerService(URL wsdlLocation) {
        super(wsdlLocation, CONTROLLERSERVICE_QNAME);
    }

    public ControllerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONTROLLERSERVICE_QNAME, features);
    }

    public ControllerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ControllerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Controller
     */
    @WebEndpoint(name = "ControllerPort")
    public Controller getControllerPort() {
        return super.getPort(new QName("http://service.bank.com/", "ControllerPort"), Controller.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Controller
     */
    @WebEndpoint(name = "ControllerPort")
    public Controller getControllerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.bank.com/", "ControllerPort"), Controller.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONTROLLERSERVICE_EXCEPTION!= null) {
            throw CONTROLLERSERVICE_EXCEPTION;
        }
        return CONTROLLERSERVICE_WSDL_LOCATION;
    }

}