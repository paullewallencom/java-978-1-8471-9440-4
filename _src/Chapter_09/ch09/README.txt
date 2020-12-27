As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

===========================================================
Sample 01 - Folder ch09\Jsr181BindPojo
POJO Binding Sample
===========================================================

First, build the artifacts to be deployed into ServiceMix ESB. For that execute:

cd ch09\Jsr181BindPojo
ant

We can bring up ServiceMix by running following commands.

cd ch09\Jsr181BindPojo
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB. ServiceMix ESB in turn will route the message to the EJB binding in the BEA Weblogic server. The EJB will be invoked and any response is send back through the ESB to the Client.

Run an Axis Client:
------------------

cd ch09\Jsr181BindPojo\03_AxisClient
ant

This will generate the required Axis client side stubs and compile the client classes. Now to run the client, execute

ant run

===========================================================
Sample 02 - Folder ch09\Jsr181PojoAccessBus
Accessing the JBI Bus Sample
===========================================================

First, build the artifacts to be deployed into ServiceMix ESB. For that execute:

cd ch09\Jsr181PojoAccessBus
ant

We can bring up ServiceMix by running following commands.

cd ch09\Jsr181PojoAccessBus
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB. ServiceMix ESB in turn will route the message to the EJB binding in the BEA Weblogic server. The EJB will be invoked and any response is send back through the ESB to the Client.

Run an Axis Client:
------------------

cd ch09\Jsr181PojoAccessBus\04_AxisClient
ant

This will generate the required Axis client side stubs and compile the client classes. Now to run the client, execute

ant run
