#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

<%@ include file="check.jsp" %>
<html>
<head>
<%
	out.println(gef.getLookStyleSheet());
%>
</head>
<body bgcolor="#ffffff" leftmargin="5" topmargin="5" marginwidth="5" marginheight="5">
Bienvenue sur le composant ${rootArtifactId}.<br><br>
Cette instance est nommée <b><%=componentLabel%></b>.<br>
Elle est située dans l\'espace <b><%=spaceLabel%></b>.
</body>
</html>