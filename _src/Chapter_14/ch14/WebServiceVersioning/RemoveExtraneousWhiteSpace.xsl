<?xml version="1.0" encoding="utf-8"?>

<!--=======================================================================
	Condense.xsl
	
	Removes comments and extraneous whitespace from a source file.
	Good for optimizing an XSL document. Only pitfalls are that it might
	rearrange attributes, depending on the processor implementation.
	(I haven't actually seen that happen, though), and it will definitely
	not copy DTD information or entity references into the new tree.
	
	Written by: Mike J. Brown <mike@skew.org>
	License: none; use and distribute freely.

	Version 1.0 - 05 Jan 2000: First public version. XSLT 1.0 conformant.
	=======================================================================-->

<!-- beginning of the stylesheet -->
<xsl:stylesheet	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<!-- desired output method -->
	<xsl:output method="xml" version="1.0" indent="no"/>

	<!-- source document whitespace handling -->
	<xsl:strip-space elements="*"/>
	<xsl:preserve-space elements="xsl:text"/>

<!--=======================================================================-->
	<!-- when processing root, element, attribute, or processing-instruction node -->
	<xsl:template match="/|*|@*|processing-instruction()">
		<!-- create a copy of the current node in the result tree -->
		<xsl:copy>
			<!-- its attributes and children will be the result of the following instruction -->
			<!-- go process attributes and any non-comment children of current node -->
			<xsl:apply-templates select="@*|node()[not(self::comment())]"/>
		</xsl:copy>
	</xsl:template>

<!-- end of the stylesheet -->
</xsl:stylesheet>
