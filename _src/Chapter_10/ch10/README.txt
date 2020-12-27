As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

===========================================================
Folder ch10\ServiceMixHttpBinding
Bind Web Service Using HTTP
===========================================================

Build the Web Service
----------------------

Open a command prompt and change directory to ch10\ServiceMixHttpBinding and then execute ant

cd ch10\ServiceMixHttpBinding
ant

This will build the Web Service and the ServiceMix bindings as well. This will generate the web archive (AxisEndToEnd.war) and place that in the dist folder inside ch10\ServiceMixHttpBinding\01_ws which can be deployed in the webapps folder of tomcat (or any other relevant web server) and restart the server. You can access the service WSDL using the URL: http://localhost:8080/AxisEndToEnd/services/HelloWebService?WSDL

Now to make sure that your web service deployment works fine, we have provided a web service test client. To invoke the test client:

cd ch10\ServiceMixHttpBinding\01_ws
ant run

Bind the Web Service in ServiceMix
----------------------------------

The previous build should have also built the ServiceMix bindings. Assuming that the web service is already deployed and the web server is up and running, you can now bring up ServiceMix by running following commands.

cd ch10\ServiceMixHttpBinding
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB. ServiceMix ESB in turn will route the message to the external Web Service bound to the ESB. The Web Service will be invoked and any response is send back through the ESB to the Client.

Run an Axis Client:
------------------

Assuming that the web service is already deployed and the web server is up and running and subsequently the ServiceMix ESB is also brought up, you can generate the Axis client side artifacts to access the web service as follows:

ch10\ServiceMixHttpBinding\03_AxisClient
ant

This will generate the required Axis client side stubs and compile the client classes. Now to run the client, execute

ant run