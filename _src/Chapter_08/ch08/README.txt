As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

Bring up BEA Weblogic Server:
----------------------------
Assuming you are using BEA Weblogic Server (If you use any other server, follow that server's documentation on how to build the EJB), to quick start the server we can use the examples domain coming along with the default installation. To start examples domain, invoke: 

%WL_HOME%\samples\domains\examples\startExamplesServer.cmd

Refer to http://edocs.bea.com/wls/docs81/adminguide/startquickref.html for any Server startup guidelines.

Build the EJB
-------------

Open a command prompt and change directory to ch04\AxisSoapBindEjb\ejb and execute the following:

ch08\BindEjb\01_Ejb
%wl.home%\samples\domains\examples\setExamplesEnv.bat
%wl.home%\server\bin\ant

This will build the EJB and hot deploy the EJB into Weblogic. You can even test whether your EJB deployment went fine by executing a test client, like:

%wl.home%\server\bin\ant run

Bind EJB in ServiceMix ESB
--------------------------

First, build the artifacts to be deployed into ServiceMix ESB. For that execute:

cd ch08\BindEjb\02_BindInEsb
ant

Copy following libraries too to %SERVICEMIX_HOME%/lib/optional folder

servicemix-http-3.1.1-incubating.jar from %SERVICEMIX_HOME%/components/servicemix-http-3.1.1-incubating-installer.zip
servicemix-common-3.1.1-incubating.jar from %SERVICEMIX_HOME%/components/servicemix-shared-3.1.1-incubating-installer.zip
servicemix-soap-3.1.1-incubating.jar from %SERVICEMIX_HOME%/components/servicemix-shared-3.2-incubating-SNAPSHOT-installer.zip
servicemix-jsr181-3.1.1-incubating.jar from %SERVICEMIX_HOME%/components/servicemix-jsr181-3.1.1-incubating-installer.zip
xfire-all-*.jar from XFire Download
xfire-aegis-*.jar from XFire Download
jdom-*.jar from XFire Download
spring*.jar from XFire Download

We can bring up ServiceMix by running following commands.

cd ch08\BindEjb\02_BindInEsb
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB. ServiceMix ESB in turn will route the message to the EJB binding in the BEA Weblogic server. The EJB will be invoked and any response is send back through the ESB to the Client.

Run an Axis Client:
------------------

cd ch08\BindEjb\03_AxisClient
ant

This will generate the required Axis client side stubs and compile the client classes. Now to run the client, execute

ant run