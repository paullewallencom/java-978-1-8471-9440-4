/**
 * HelloServiceBIServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.binildas.esb.bindejb;

public class HelloServiceBIServiceLocator extends org.apache.axis.client.Service implements com.binildas.esb.bindejb.HelloServiceBIService {

    public HelloServiceBIServiceLocator() {
    }


    public HelloServiceBIServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloServiceBIServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloServiceBI
    private java.lang.String HelloServiceBI_address = "http://localhost:8192/Services/HelloWebService/";

    public java.lang.String getHelloServiceBIAddress() {
        return HelloServiceBI_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloServiceBIWSDDServiceName = "HelloServiceBI";

    public java.lang.String getHelloServiceBIWSDDServiceName() {
        return HelloServiceBIWSDDServiceName;
    }

    public void setHelloServiceBIWSDDServiceName(java.lang.String name) {
        HelloServiceBIWSDDServiceName = name;
    }

    public com.binildas.esb.bindejb.JsrEjbEPPortType getHelloServiceBI() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloServiceBI_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloServiceBI(endpoint);
    }

    public com.binildas.esb.bindejb.JsrEjbEPPortType getHelloServiceBI(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.binildas.esb.bindejb.HelloServiceBIBindingStub _stub = new com.binildas.esb.bindejb.HelloServiceBIBindingStub(portAddress, this);
            _stub.setPortName(getHelloServiceBIWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloServiceBIEndpointAddress(java.lang.String address) {
        HelloServiceBI_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.binildas.esb.bindejb.JsrEjbEPPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.binildas.esb.bindejb.HelloServiceBIBindingStub _stub = new com.binildas.esb.bindejb.HelloServiceBIBindingStub(new java.net.URL(HelloServiceBI_address), this);
                _stub.setPortName(getHelloServiceBIWSDDServiceName());
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
        if ("HelloServiceBI".equals(inputPortName)) {
            return getHelloServiceBI();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://binildas.com/esb/bindejb", "HelloServiceBIService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://binildas.com/esb/bindejb", "HelloServiceBI"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloServiceBI".equals(portName)) {
            setHelloServiceBIEndpointAddress(address);
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
