<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="review">
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Id</th>
        <td><xsl:value-of select="id"/></td>
      </tr>
      <tr >
        <th>Author Id</th>
        <td><xsl:value-of select="authorId"/></td>
      </tr>
      <tr bgcolor="#9acd32">
        <th>Headline</th>
        <td><xsl:value-of select="headline"/></td>
      </tr>
      <tr>
        <th>Description</th>
        <td><xsl:value-of select="description"/></td>
      </tr>
      <tr bgcolor="#9acd32">
        <th>Ratig</th>
        <td><xsl:value-of select="rating"/></td>
      </tr>
      <tr>
        <th>Date</th>
        <td><xsl:value-of select="date"/></td>
      </tr>
    </table>
</xsl:template>
</xsl:stylesheet>

