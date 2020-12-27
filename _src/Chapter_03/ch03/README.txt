As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

Build the HTTP Service
----------------------

Open a command prompt and change directory to ch03\Servlet and then execute ant

cd ch03\Servlet
ant

This will build the HTTP Service. This will generate the web archive (EsbServlet.war) and place that in the dist folder inside ch03\Servlet which can be deployed in the webapps folder of tomcat (or any other relevant web server) and restart the server. You can test this service using the URL: http://localhost:8080/EsbServlet/hello/

Build the HTTP Binding
----------------------

We can bring up ServiceMix by running following commands.

cd ch03\HttpBinding
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

By bringing up ServiceMix itself, you have successfully invoked an external HTTP service through ServiceMix ESB. Now, executing ant run will send another message through ServiceMix ESB to the HTTP service

cd ch03\Servlet
ant run

Other Settings:
---------------

The HTTP Service should be up and running first before you bring up the ServiceMix ESB.

Copy %SERVICEMIX_HOME%\components\lib\servicemix-components-3.1.1-incubating.jar to %SERVICEMIX_HOME%\lib\optional
Copy quartz.jar from Quartz distribution (http://www.opensymphony.com/quartz/) to %SERVICEMIX_HOME%\lib\optional
Open %SERVICEMIX_HOME%\components\servicemix-http-3.1.1-incubating-installer.zip and copy the following jars to %SERVICEMIX_HOME%\lib\optional:
   jetty*.jar
   commons-codec*.jar
   commons-httpclient*.jar
   
