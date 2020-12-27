As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

===========================================================
Sample 01 - Folder ch13\JdkProxy
JDK Proxy Sample
===========================================================

To build the sample, first change directory to ch13\JdkProxy folder and execute ant.

cd ch13\JavaXmlBinding
ant

To run the sample, execute:

ant run

===========================================================
Sample 02 - Folder ch13\JbiProxy\01_CompatibleInterface
JBI Proxy Sample implementing compatible interface
===========================================================

To build the sample, first change directory to ch13\JbiProxy\01_CompatibleInterface folder and execute ant.

cd ch13\JbiProxy\01_CompatibleInterface
ant

This will build the entire sample.

We can bring up ServiceMix by running following commands.

cd ch13\JbiProxy\01_CompatibleInterface
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB.

===========================================================
Sample 03 - Folder ch13\JbiProxy\02_IncompatibleInterface
JBI Proxy Sample implementing in-compatible interface
===========================================================

To build the sample, first change directory to ch13\JbiProxy\02_IncompatibleInterface folder and execute ant.

cd ch13\JbiProxy\02_IncompatibleInterface
ant

This will build the entire sample.

We can bring up ServiceMix by running following commands.

cd ch13\JbiProxy\02_IncompatibleInterface
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB.

===========================================================
Sample 04 - Folder ch13\JbiProxy\03_AccessExternalWebService
Invoke external web service from ServiceMix
===========================================================

Build the Web Service
----------------------

Open a command prompt and change directory to ch13\JbiProxy\03_AccessExternalWebService and then execute ant

cd ch13\JbiProxy\03_AccessExternalWebService
ant

This will build the Web Service and the ServiceMix bindings as well. This will generate the web archive (AxisEndToEnd.war) and place that in the dist folder inside ch13\JbiProxy\03_AccessExternalWebService\01_ws which can be deployed in the webapps folder of tomcat (or any other relevant web server) and restart the server. You can access the service WSDL using the URL: http://localhost:8080/AxisEndToEnd/services/HelloWebService?WSDL

Now to make sure that your web service deployment works fine, we have provided a web service test client. To invoke the test client:

cd ch13\JbiProxy\03_AccessExternalWebService\01_ws
ant run

Bind the Web Service in ServiceMix
----------------------------------

The previous build should have also built the ServiceMix bindings. Assuming that the web service is already deployed and the web server is up and running, you can now bring up ServiceMix by running following commands.

cd ch13\JbiProxy\03_AccessExternalWebService
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB. ServiceMix ESB in turn will route the message through the JBI Proxy to the external Web Service bound to the ESB. The Web Service will be invoked and any response is send back through the ESB to the Client.


Other Settings:
===============
Copy commons*.jar from XFire Distribution to %SERVICEMIX_HOME%/lib/optional folder

