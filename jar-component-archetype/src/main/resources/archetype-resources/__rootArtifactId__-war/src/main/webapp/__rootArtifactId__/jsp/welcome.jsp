#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ include file="check.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.silverpeas.com/tld/viewGenerator" prefix="view"%>
<html>
  <head>
    <view:looknfeel />
  </head>
  <c:set var="componentId" value="${symbol_dollar}{requestScope.componentId}" />
  <c:set var="sessionController">Silverpeas_${className}_<c:out value="${symbol_dollar}{componentId}" /></c:set>
  <fmt:setLocale value="${symbol_dollar}{sessionScope[sessionController].language}" />
  <view:setBundle bundle="${symbol_dollar}{requestScope.resources.multilangBundle}" />
  <view:setBundle bundle="${symbol_dollar}{requestScope.resources.iconsBundle}" var="icons" />
  <c:set var="browseContext" value="${symbol_dollar}{requestScope.browseContext}" />
  <body bgcolor="#ffffff" leftmargin="5" topmargin="5" marginwidth="5" marginheight="5">
    <view:window>
      <view:frame>
        Bienvenue sur le composant ${rootArtifactId}.
      </view:frame>
      <view:frame>
        <view:board>
          Cette instance s'appele <b><c:out value="${symbol_dollar}{browseContext[1]}" /></b>.<br/>
          Elle se situe dans l'espace <b><c:out value="${symbol_dollar}{browseContext[0]}" /></b>.
        </view:board>
      </view:frame>
    </view:window>
  </body>
</html>