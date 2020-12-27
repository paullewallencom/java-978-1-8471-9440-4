/**
 * MyConsumerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.binildas.apache.axis.AxisEndToEnd;

public class MyConsumerServiceLocator extends org.apache.axis.client.Service implements com.binildas.apache.axis.AxisEndToEnd.MyConsumerService {

    public MyConsumerServiceLocator() {
    }


    public MyConsumerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MyConsumerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloWebService
    private java.lang.String HelloWebService_address = "http://localhost:8081/services/HelloWebService/";

    public java.lang.String getHelloWebServiceAddress() {
        return HelloWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloWebServiceWSDDServiceName = "HelloWebService";

    public java.lang.String getHelloWebServiceWSDDServiceName() {
        return HelloWebServiceWSDDServiceName;
    }

    public void setHelloWebServiceWSDDServiceName(java.lang.String name) {
        HelloWebServiceWSDDServiceName = name;
    }

    public com.binildas.apache.axis.AxisEndToEnd.IHelloWeb getHelloWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloWebService(endpoint);
    }

    public com.binildas.apache.axis.AxisEndToEnd.IHelloWeb getHelloWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.binildas.apache.axis.AxisEndToEnd.HelloWebServiceBindingStub _stub = new com.binildas.apache.axis.AxisEndToEnd.HelloWebServiceBindingStub(portAddress, this);
            _stub.setPortName(getHelloWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloWebServiceEndpointAddress(java.lang.String address) {
        HelloWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.binildas.apache.axis.AxisEndToEnd.IHelloWeb.class.isAssignableFrom(serviceEndpointInterface)) {
                com.binildas.apache.axis.AxisEndToEnd.HelloWebServiceBindingStub _stub = new com.binildas.apache.axis.AxisEndToEnd.HelloWebServiceBindingStub(new java.net.URL(HelloWebService_address), this);
                _stub.setPortName(getHelloWebServiceWSDDServiceName());
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
        if ("HelloWebService".equals(inputPortName)) {
            return getHelloWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://AxisEndToEnd.axis.apache.binildas.com", "MyConsumerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://AxisEndToEnd.axis.apache.binildas.com", "HelloWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloWebService".equals(portName)) {
            setHelloWebServiceEndpointAddress(address);
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
