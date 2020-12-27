As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

Now open a command prompt and change directory to ch16\voipservice and then execute ant

cd ch16\voipservice
ant

This will build the entire sample.

We can bring up ServiceMix by running following commands.

cd ch16\voipservice
%SERVICEMIX_HOME%/bin/servicemix servicemix.xml

To run the demo, there is a Client.html provided again in the top folder. Double click this file to open it in your favorite browser. In Internet Explorer, the browser will show the following warning:

"To help protect your security, Internet Explorer has restricted this file from showing active content that could access your computer. Click here for options..."

Right Click this message and select "Allow Blocked Content..."

Now clicking Send will route the request message to the ServiceMix ESB.