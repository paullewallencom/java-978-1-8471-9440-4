As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

===========================================================
Folder ch12\JavaXmlBinding
XStream in Normalized Message Router Sample
===========================================================

First, build the artifacts to be deployed into ServiceMix ESB. For that execute:

cd ch12\JavaXmlBinding
ant

We can bring up ServiceMix by running following commands.

cd ch12\JavaXmlBinding
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB. ServiceMix ESB in turn will route the message to the Interceptor component first and then to the Inspector. The Inspector echoes back the message which is passed back through the Interceptor to the client.

Other Settings:
---------------
Copy xpp3_min*.jar from XStream Distribution (http://xstream.codehaus.org/) to %SERVICEMIX_HOME%\lib\optional
Copy saaj.jar (or Saaj-impl jar) from Apache Axis Distribution (http://www.apache.org/dyn/closer.cgi/ws/axis/1_4/) to %SERVICEMIX_HOME%\lib\optional