<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="hotel">
  <html>
  <body>
  <h2>Hotel Detail</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Id</th>
        <td><xsl:value-of select="id"/></td>
      </tr>
      <tr >
        <th>Name</th>
        <td><xsl:value-of select="name"/></td>
      </tr>
      <tr bgcolor="#9acd32">
        <th>City</th>
        <td><xsl:value-of select="city"/></td>
      </tr>
      <tr >
        <th>Country</th>
        <td><xsl:value-of select="country"/></td>
      </tr>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>

