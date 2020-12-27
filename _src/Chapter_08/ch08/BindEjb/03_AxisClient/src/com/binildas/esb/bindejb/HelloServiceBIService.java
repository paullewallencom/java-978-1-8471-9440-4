/**
 * HelloServiceBIService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.binildas.esb.bindejb;

public interface HelloServiceBIService extends javax.xml.rpc.Service {
    public java.lang.String getHelloServiceBIAddress();

    public com.binildas.esb.bindejb.JsrEjbEPPortType getHelloServiceBI() throws javax.xml.rpc.ServiceException;

    public com.binildas.esb.bindejb.JsrEjbEPPortType getHelloServiceBI(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
