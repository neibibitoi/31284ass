<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>All hotels</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Id</th>
        <th>Name</th>
        <th>City</th>
        <th>Country</th>
      </tr>
      <xsl:for-each select="root/hotels/hotel">
      <tr>
        <td><xsl:value-of select="id"/></td>
        <td>
	        <a>
			   <xsl:attribute name="href">Hotel?id=<xsl:value-of select="id" /></xsl:attribute>
			   <xsl:value-of select="name" />
			</a>
       	</td>
        <td><xsl:value-of select="city"/></td>
        <td><xsl:value-of select="country"/></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>

