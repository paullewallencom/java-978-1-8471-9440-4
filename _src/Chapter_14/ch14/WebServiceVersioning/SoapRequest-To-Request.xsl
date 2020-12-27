
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <xsl:output method="xml"/>

    <xsl:template match="/">
                <xsl:copy-of select="soapenv:Envelope/soapenv:Body/*" />
    </xsl:template>

</xsl:stylesheet>