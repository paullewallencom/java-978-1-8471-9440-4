/**
 * PojoWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.binildas.esb.jsrpojo;

public class PojoWebServiceLocator extends org.apache.axis.client.Service implements com.binildas.esb.jsrpojo.PojoWebService {

    public PojoWebServiceLocator() {
    }


    public PojoWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PojoWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PojoWebServiceEP
    private java.lang.String PojoWebServiceEP_address = "http://localhost:8081/services/PojoService/";

    public java.lang.String getPojoWebServiceEPAddress() {
        return PojoWebServiceEP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PojoWebServiceEPWSDDServiceName = "PojoWebServiceEP";

    public java.lang.String getPojoWebServiceEPWSDDServiceName() {
        return PojoWebServiceEPWSDDServiceName;
    }

    public void setPojoWebServiceEPWSDDServiceName(java.lang.String name) {
        PojoWebServiceEPWSDDServiceName = name;
    }

    public com.binildas.esb.jsrpojo.BridgeServicePortType getPojoWebServiceEP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PojoWebServiceEP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPojoWebServiceEP(endpoint);
    }

    public com.binildas.esb.jsrpojo.BridgeServicePortType getPojoWebServiceEP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.binildas.esb.jsrpojo.PojoWebServiceEPBindingStub _stub = new com.binildas.esb.jsrpojo.PojoWebServiceEPBindingStub(portAddress, this);
            _stub.setPortName(getPojoWebServiceEPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPojoWebServiceEPEndpointAddress(java.lang.String address) {
        PojoWebServiceEP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.binildas.esb.jsrpojo.BridgeServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.binildas.esb.jsrpojo.PojoWebServiceEPBindingStub _stub = new com.binildas.esb.jsrpojo.PojoWebServiceEPBindingStub(new java.net.URL(PojoWebServiceEP_address), this);
                _stub.setPortName(getPojoWebServiceEPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PojoWebServiceEP".equals(inputPortName)) {
            return getPojoWebServiceEP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://binildas.com/esb/jsrpojo", "PojoWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://binildas.com/esb/jsrpojo", "PojoWebServiceEP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PojoWebServiceEP".equals(portName)) {
            setPojoWebServiceEPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
