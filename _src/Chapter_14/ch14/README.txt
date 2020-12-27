As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

Build the Web Service
----------------------

Open a command prompt and change directory to ch14\WebServiceVersioning and then execute ant

cd ch14\WebServiceVersioning
ant

This will build two versions of web service and place the deployable war file in the dist folder as shown below:

ch14\WebServiceVersioning\01_WebService20061231\dist\AxisEndToEnd20061231.war
ch14\WebServiceVersioning\02_WebService20070101\dist\AxisEndToEnd20070101.war


The above war files can be deployed in the webapps folder of tomcat (or any other relevant web server) and restart the server. You can access the service WSDL using the URL: 

http://localhost:8080/AxisEndToEnd20061231/services/HelloWebService20061231?WSDL
http://localhost:8080/AxisEndToEnd20070101/services/HelloWebService20070101?WSDL

Now to make sure that your web service deployment works fine, we have provided web service test clients.

To test version 20061231 of the service

cd ch14\WebServiceVersioning\01_WebService20061231
ant run

To test version 20061231 of the service

cd ch14\WebServiceVersioning\02_WebService20070101
ant run

Bind the Web Service in ServiceMix
----------------------------------

The previous build should have also built the ServiceMix bindings. Assuming that the web service is already deployed and the web server is up and running, you can now bring up ServiceMix.

First plugin Saxon XPath Factory class to the java runtime of ServiceMix. For this, follow the below steps:

1. Copy servicemix-jms-3.1.1-incubating.jar from %SERVICEMIX_HOME%\components\lib\servicemix-jms-3.1.1-incubating-installer.zip to %SERVICEMIX_HOME%\lib\optional
2. Copy servicemix-eip-3.1.1-incubating.jar from %SERVICEMIX_HOME%\components\lib\servicemix-eip-3.1.1-incubating-installer.zip to %SERVICEMIX_HOME%\lib\optional
3. Copy saxon*.jar from Saxon Distribution to %SERVICEMIX_HOME%\lib\optional

Add the following line to %SERVICEMIX_HOME%\bin\servicemix.bat file:

set BOOT_OPTS=%BOOT_OPTS% -Djavax.xml.xpath.XPathFactory:http://java.sun.com/jaxp/xpath/dom="net.sf.saxon.xpath.XPathFactoryImpl"

Now bring up ServiceMix by:

cd ch14\WebServiceVersioning
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

Test the web service versioning
--------------------------------

Two clients are provided to test the web service. You can test them by executing following commands:

cd ch14\WebServiceVersioning
ant run1

and 

cd ch14\WebServiceVersioning
ant run2

Other Settings:
---------------

1. The HTTP Services should be up and running first before you bring up the ServiceMix ESB.
2. Saxon can be downloaded from: http://www.saxonica.com/download/saxonsa8-9j.zip (Saxon Home Page: http://saxon.sourceforge.net/)


