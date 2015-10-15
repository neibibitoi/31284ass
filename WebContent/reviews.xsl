<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<h2>All Reviews</h2>
		<table border="1">
			<tr bgcolor="#9acd32">
				<th>Id</th>
				<th>Author Id</th>
				<th>Headline</th>
				<th>Description</th>
				<th>Rating</th>
				<th>Date</th>
			</tr>
			<xsl:for-each select="root/reviews/review">
				<tr>
					<td>
						<a>
							<xsl:attribute name="href">Review?id=<xsl:value-of
								select="id" /></xsl:attribute>
							<xsl:value-of select="id" />
						</a>
					</td>
					<td>
						<xsl:value-of select="authorId" />
					</td>
					<td>
						<xsl:value-of select="headline" />
					</td>
					<td>
						<xsl:value-of select="description" />
					</td>
					<td>
						<xsl:value-of select="rating" />
					</td>
					<td>
						<xsl:value-of select="date" />
					</td>

				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
</xsl:stylesheet>

