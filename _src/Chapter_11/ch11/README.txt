As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

===========================================================
Folder ch11\WebServiceInJmsChannel
Access Web Service using JMS Channel
===========================================================

Build the Web Service
----------------------

Open a command prompt and change directory to ch11\WebServiceInJmsChannel and then execute ant

cd ch11\WebServiceInJmsChannel
ant

This will build the Web Service and the ServiceMix bindings as well. This will generate the web archive (AxisEndToEnd.war) and place that in the dist folder inside ch11\WebServiceInJmsChannel\01_ws which can be deployed in the webapps folder of tomcat (or any other relevant web server) and restart the server. You can access the service WSDL using the URL: http://localhost:8080/AxisEndToEnd/services/HelloWebService?WSDL

Now to make sure that your web service deployment works fine, we have provided two web service test clients. To invoke the test client execute ant as follows:

cd ch11\ServiceMixHttpBinding\01_ws
ant run

and/or

ant test

Bind the Web Service in ServiceMix
----------------------------------

The previous build should have also built the ServiceMix bindings. Assuming that the web service is already deployed and the web server is up and running, you can now bring up ServiceMix by running following commands.

cd ch11\WebServiceInJmsChannel
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

Run a JMS Client - Document style
----------------------------------

To run the JMS client for accessing the web service, change directory to ch11\WebServiceInJmsChannel\03_BindJms and execute ant like:

cd ch11\WebServiceInJmsChannel\03_BindJms
ant run

Run an Axis Client - RPC Style
----------------------------------

To run the Axis client for accessing the web service, change directory to ch11\WebServiceInJmsChannel\05_AxisClient and execute ant like:

cd ch11\WebServiceInJmsChannel\05_AxisClient
ant run

Other Settings:
---------------

The HTTP Service should be up and running first before you bring up the ServiceMix ESB.

Copy servicemix-jms-3.1.1-incubating.jar from %SERVICEMIX_HOME%\components\lib\servicemix-jms-3.1.1-incubating-installer.zip to %SERVICEMIX_HOME%\lib\optional
