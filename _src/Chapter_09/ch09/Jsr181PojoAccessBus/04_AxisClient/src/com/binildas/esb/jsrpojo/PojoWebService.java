/**
 * PojoWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.binildas.esb.jsrpojo;

public interface PojoWebService extends javax.xml.rpc.Service {
    public java.lang.String getPojoWebServiceEPAddress();

    public com.binildas.esb.jsrpojo.BridgeServicePortType getPojoWebServiceEP() throws javax.xml.rpc.ServiceException;

    public com.binildas.esb.jsrpojo.BridgeServicePortType getPojoWebServiceEP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
