As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

===========================================================
Sample 01 - Folder ch05\01_XFireServletWebService
Web Service Using XFireConfigurableServlet
===========================================================

To build the sample, change directory to ch05\01_XFireServletWebService and execute ant:

cd ch05\01_XFireServletWebService
ant

Now copy ch05\01_XFireServletWebService\dist\HelloXFire.war file to the webapps folder of tomcat (or any other relevant web server) and restart the server. The web service would have been exposed by now and the service definition of the same can be accessed using the following URL:
http://localhost:8080/HelloXFire/services/Hello?WSDL

To run the client, execute ant as follows:

ant run

===========================================================
Sample 02 - Folder ch05\02_XFireExportWebService
Web Service Using XFire Spring XFireExporter
===========================================================

To build the sample, change directory to ch05\02_XFireExportWebService and execute ant:

cd ch05\02_XFireExportWebService
ant

Now copy \ch05\02_XFireExportWebService\dist\HelloXFireExport.war file to the webapps folder of tomcat (or any other relevant web server) and restart the server. The web service would have been exposed by now and the service definition of the same can be accessed using the following URL:
http://localhost:8080/HelloXFireExport/services/HelloService?WSDL

To run the client, execute ant as follows:

ant run

===========================================================
Sample 03 - Folder ch05\03_XFireJsr181BindWebService
Web Service Using XFire Spring Jsr181 Handler
===========================================================

To build the sample, change directory to ch05\03_XFireJsr181BindWebService and execute ant:

cd ch05\03_XFireJsr181BindWebService
ant

Now copy ch05\03_XFireJsr181BindWebService\dist\XFireJsr181.war file to the webapps folder of tomcat (or any other relevant web server) and restart the server. The web service would have been exposed by now and the service definition of the same can be accessed using the following URL:
http://localhost:8080/XFireJsr181/services/OrderService?WSDL

To run the client, execute ant as follows:

ant run

===========================================================
Sample 04 - Folder ch05\04_XFireExportAndBindEjb
XFire Export and Bind EJB
===========================================================

Bring up BEA Weblogic Server:
-----------------------------
Assuming you are using BEA Weblogic Server (If you use any other server, follow that server's documentation on how to build the EJB), to quick start the server we can use the examples domain coming along with the default installation. To start examples domain, invoke: 

%WL_HOME%\samples\domains\examples\startExamplesServer.cmd

Refer to http://edocs.bea.com/wls/docs81/adminguide/startquickref.html for any Server startup guidelines.

Build the EJB
-------------

Open a command prompt and change directory to ch05\04_XFireExportAndBindEjb\ejb and execute the following:

cd ch05\04_XFireExportAndBindEjb\ejb
%wl.home%\samples\domains\examples\setExamplesEnv.bat
%wl.home%\server\bin\ant

This will build the EJB and hot deploy the EJB into Weblogic. You can even test whether your EJB deployment went fine by executing a test client, like:

%wl.home%\server\bin\ant run

XFire export and Bind EJB
-------------------------

To build the sample, change directory to ch05\04_XFireExportAndBindEjb\XFireBind and execute ant:

cd ch05\04_XFireExportAndBindEjb\XFireBind
ant

Now copy ch05\04_XFireExportAndBindEjb\XFireBind\dist\XFireBindEjb.war file to the webapps folder of tomcat (or any other relevant web server) and restart the server. The web service would have been exposed by now and the service definition of the same can be accessed using the following URL:
http://localhost:8080/XFireBindEjb/services/InvokeService?WSDL

Run the Client:
--------------

A client (Client.java) is provided in ch05\04_XFireExportAndBindEjb\XFireBind. To run this client, execute the following:

ant run

Other Settings:
--------------

In case your web server is complaining about some missing libraries, include the following jars into ${tomcat.home}/lib folder:

xalan*.jar from Xalan-Java Download.