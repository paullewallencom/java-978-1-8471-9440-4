As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

Bring up BEA Weblogic Server:
-----------------------------
Assuming you are using BEA Weblogic Server (If you use any other server, follow that server's documentation on how to build the EJB), to quick start the server we can use the examples domain coming along with the default installation. To start examples domain, invoke: 

%WL_HOME%\samples\domains\examples\startExamplesServer.cmd

Refer to http://edocs.bea.com/wls/docs81/adminguide/startquickref.html for any Server startup guidelines.

Build the EJB
-------------

Open a command prompt and change directory to ch04\AxisSoapBindEjb\ejb and execute the following:

cd ch04\AxisSoapBindEjb\ejb
%wl.home%\samples\domains\examples\setExamplesEnv.bat
%wl.home%\server\bin\ant

This will build the EJB and hot deploy the EJB into Weblogic. You can even test whether your EJB deployment went fine by executing a test client, like:

%wl.home%\server\bin\ant run

Bring up SOAP Server
--------------------

Download Apache SOAP (soap-bin-2.3.1[1].zip) from http://archive.apache.org/dist/ws/soap/version-2.3.1/. Open this archive and copy soap.war to the webapps folder of your favorite web server (Apache Tomcat). You also need to copy the following files and make them available in the lib folder of your web server:

%wl.home%\server\lib\weblogic.jar
%wl.home%\samples\server\examples\build\clientclasses\sample_statelessSession_client.jar

Now restart your web server.

SOAP Bind the EJB
-----------------

To bind the previously deployed EJB service to SOAP Server, execute the following:

cd ch04\AxisSoapBindEjb\SoapBind
ant deploy

You can verify whether the above binding is successful by executing:

cd ch04\AxisSoapBindEjb\SoapBind
ant list

Run the Client:
--------------

A client (SoapTest.java) is provided in ch04\AxisSoapBindEjb\SoapBind. To run this client, execute the following:

cd ch04\AxisSoapBindEjb\SoapBind
ant run

Other Settings:
--------------

In case your web server is complaining about some missing libraries, include the following jars into ${tomcat.home}/lib folder:

${soap.home}/lib/soap.jar
${jaf.home}/activation.jar
${java.mail.home}/mail.jar