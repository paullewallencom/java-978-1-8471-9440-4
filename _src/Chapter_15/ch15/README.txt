As a pre-requisite, find examples.properties file and change the paths accordingly to match your development environment.

===============================================
Pattern 01 - Folder ch15\01_ContentBasedRouter
Content Based Router
===============================================

To build the sample, change directory to ch18\01_ContentBasedRouter and execute ant:

cd ch15\01_ContentBasedRouter
ant

Bring ServiceMix up by executing:

cd ch15\01_ContentBasedRouter
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

To test the pattern, execute ant run:

cd ch15\01_ContentBasedRouter
ant run

===============================================
Pattern 02 - Folder ch15\02_ContentEnricher
Content Enricher
===============================================

To build the sample, change directory to ch15\02_ContentEnricher and execute ant:

cd ch15\02_ContentEnricher
ant

Bring ServiceMix up by executing:

cd ch15\02_ContentEnricher
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

To test the pattern, execute ant run:

cd ch15\02_ContentEnricher
ant run

===============================================
Pattern 03 - Folder ch15\03_XPathSplitter
XPath Splitter
===============================================

To build the sample, change directory to ch15\03_XPathSplitter and execute ant:

cd ch15\03_XPathSplitter
ant

Bring ServiceMix up by executing:

cd ch15\03_XPathSplitter
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

To test the pattern, execute ant run:

cd ch15\03_XPathSplitter
ant run

===============================================
Pattern 04 - Folder ch15\04_StaticRecipientList
Static Recipient List
===============================================

To build the sample, change directory to ch15\04_StaticRecipientList and execute ant:

cd ch15\04_StaticRecipientList
ant

Bring ServiceMix up by executing:

cd ch15\04_StaticRecipientList
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

To test the pattern, execute ant run:

cd ch15\04_StaticRecipientList
ant run

===============================================
Pattern 05 - Folder ch15\05_WireTap
Wire Tap
===============================================

To build the sample, change directory to ch15\05_WireTap and execute ant:

cd ch15\05_WireTap
ant

Bring ServiceMix up by executing:

cd ch15\05_WireTap
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

To test the pattern, execute ant run:

cd ch15\05_WireTap
ant run

===============================================
Pattern 06 - Folder ch15\06_MessageFilter
Message Filter
===============================================

To build the sample, change directory to ch15\06_MessageFilter and execute ant:

cd ch15\06_MessageFilter
ant

Bring ServiceMix up by executing:

cd ch15\06_MessageFilter
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

To test the pattern, execute ant run:

cd ch15\06_MessageFilter
ant run

===============================================
Pattern 07 - Folder ch15\07_SplitAggregator
Split Aggregator
===============================================

To build the sample, change directory to ch15\07_SplitAggregator and execute ant:

cd ch15\07_SplitAggregator
ant

Now, to bring ServiceMix up and to test the pattern, execute ant run:

cd ch15\07_SplitAggregator
ant run

===============================================
Pattern 08 - Folder ch15\08_Pipeline
Pipeline
===============================================

To build the sample, change directory to ch15\08_Pipeline and execute ant:

cd ch15\08_Pipeline
ant

Bring ServiceMix up by executing:

cd ch15\08_Pipeline
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

To test the pattern, execute ant run:

cd ch15\08_Pipeline
ant run

===============================================
Pattern 09 - Folder ch15\09_StaticRoutingSlip
Static Routing Slip
===============================================

To build the sample, change directory to ch15\09_StaticRoutingSlip and execute ant:

cd ch15\09_StaticRoutingSlip
ant

Bring ServiceMix up by executing:

cd ch15\09_StaticRoutingSlip
%SERVICEMIX_HOME%\bin\servicemix servicemix.xml

To test the pattern, execute ant run:

cd ch15\09_StaticRoutingSlip
ant run

Other Settings:
---------------
Perform the following environment settings to run samples in this chapter, if you haven't done them earlier:

First plugin Saxon XPath Factory class to the java runtime of ServiceMix. For this, follow the below steps:-

1. Copy servicemix-jms-3.1.1-incubating.jar from %SERVICEMIX_HOME%\components\lib\servicemix-jms-3.1.1-incubating-installer.zip to %SERVICEMIX_HOME%\lib\optional
2. Copy servicemix-eip-3.1.1-incubating.jar from %SERVICEMIX_HOME%\components\lib\servicemix-eip-3.1.1-incubating-installer.zip to %SERVICEMIX_HOME%\lib\optional
3. Copy saxon*.jar from Saxon Distribution to %SERVICEMIX_HOME%\lib\optional
4. Saxon can be downloaded from: http://www.saxonica.com/download/saxonsa8-9j.zip (Saxon Home Page: http://saxon.sourceforge.net/)

Add the following line to %SERVICEMIX_HOME%\bin\servicemix.bat file:

set BOOT_OPTS=%BOOT_OPTS% -Djavax.xml.xpath.XPathFactory:http://java.sun.com/jaxp/xpath/dom="net.sf.saxon.xpath.XPathFactoryImpl"