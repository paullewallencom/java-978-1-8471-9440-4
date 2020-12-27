As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

===============================================
Sample 01 - Folder ch17\01_Transactions\InOnlyAsync
Transactions
===============================================

To build the sample, change directory to ch17\01_Transactions\InOnlyAsync and execute ant:

cd ch17\01_Transactions\InOnlyAsync
ant

This will build the entire code base for the transaction demonstration. Now we need to take a command prompt and start the ServiceMix in the embedded mode, as follows:

cd ch17\01_Transactions\InOnlyAsync
ant run

In case you want to run the test as a JUnit test case, execute:
ant test

===============================================
Sample 02 - Folder ch17\02_Security\BasicHttp
Security
===============================================

To build the sample, change directory to the ch17\02_Security\BasicHttp folder and execute ant:

cd ch17\02_Security\BasicHttp
ant

Now bring ServiceMix server up by executing

cd ch17\02_Security\BasicHttp
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB.

The browser will challenge with the username/password entry form where you can enter the credentials binil and binil belonging to the secureuser group to access the service.

===============================================
Sample 03 - Folder ch17\03_Clustering
Clustering
===============================================

To build the sample, change directory to ch17\03_Clustering and execute ant:

cd ch17\03_Clustering
ant

This will build the entire code base for the clustering demonstration. Now take three different command prompts and bring up all the server instances in the cluster, in the same order as followed below:

cd ch17\03_Clustering\admin
%SERVICEMIX_HOME%\bin\servicemix servicemixadmin.xml

cd ch17\03_Clustering\managed1
%SERVICEMIX_HOME%\bin\servicemix servicemixmanaged1.xml

cd ch17\03_Clustering\managed2
%SERVICEMIX_HOME%\bin\servicemix servicemixmanaged2.xml

The cluster should be up by now. Now to test the cluster set up, in a different command prompt execute the following:

cd ch17\03_Clustering
ant run

Keep watching on the server side console printouts, especially the console of the managed1 and managed2 servers. Execute ant run a couple of times and understand how the cluster load balances requests targeted to different services.

You may also want to kill one of the managed servers and try the effect of that on new incoming requests. You can later bring this dead server back to join the cluster without disturbing the cluster set up

===============================================
Sample 04 - Folder ch17\04_JMX
JMX
===============================================

To build the sample, change directory to ch17\04_JMX and execute ant:

cd ch17\04_JMX
ant

Now bring ServiceMix server up by executing

cd ch17\04_JMX
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

Click on ‘MC4J Console 1.2b9.exe’ found in the top-level directory of the MC4J installation which will bring up MC4J window

Select "Management > Create Server Connection..." from the menu. This will start "My Wizard". A connection to ServiceMix can be created using the wizard.

In the wizard, enter the following into the text boxes/pull-down menus:

Select your server connection type: JSR160
Name: This can be any name, for example, ServiceMix
Server URL: service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi
(For ServiceMix version 2.x, JMX Service URL alone changes and is: service:jmx:rmi:///jndi/rmi://localhost:1099/defaultJBIJMX)

Accept the defaults for the rest of the fields in the wizard and Click "Next.". Now click "Finish" in the next window. This will make a connection to ServiceMix.

Click on org.apache.servicemix(1). The components of the POJO Binding example will be shown. Right-click on a component (Type=Endpoint) and select "Available dashboards... > Basic MBean View" to see the JMX information available.

Clicking on the loadWSDL button. You may have to uncheck the ‘View as HTML’ button to make the WSDL visible.

Other Settings:
---------------
MC4J Home Page: http://mc4j.sourceforge.net