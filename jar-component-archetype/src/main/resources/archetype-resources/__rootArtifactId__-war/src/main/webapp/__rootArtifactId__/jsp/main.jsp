#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%--

    Copyright (C) 2000 - 2014 Silverpeas

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    As a special exception to the terms and conditions of version 3.0 of
    the GPL, you may redistribute this Program in connection with Free/Libre
    Open Source Software ("FLOSS") applications as described in Silverpeas's
    FLOSS exception.  You should have received a copy of the text describing
    the FLOSS exception, and it is also available here:
    "http://www.silverpeas.com/legal/licensing"

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

--%>
<%@ include file="check.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.silverpeas.com/tld/viewGenerator" prefix="view"%>

<c:set var="componentId"         value="${symbol_dollar}{requestScope.browseContext[3]}"/>
<c:set var="currentUserLanguage" value="${symbol_dollar}{requestScope.resources.language}"/>
<fmt:setLocale value="${symbol_dollar}{currentUserLanguage}"/>
<view:setBundle bundle="${symbol_dollar}{requestScope.resources.multilangBundle}"/>
<view:setBundle bundle="${symbol_dollar}{requestScope.resources.iconsBundle}" var="icons"/>

<fmt:message key="${rootArtifactId}.menu.item.subscribe"   var="subscribeLabel"/>
<fmt:message key="${rootArtifactId}.menu.item.unsubscribe" var="unsubscribeLabel"/>

<c:set var="isUserSubscribed" value="${requestScope.isUserSubscribed}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
  <head>
    <view:looknfeel />
    <script type="application/javascript">
      function successUnsubscribe() {
        setSubscriptionMenu('<view:encodeJs string="${symbol_dollar}{subscribeLabel}" />', 'subscribe');
      }

      function successSubscribe() {
        setSubscriptionMenu('<view:encodeJs string="${symbol_dollar}{unsubscribeLabel}" />', 'unsubscribe');
      }
      function setSubscriptionMenu(label, actionMethodName) {
        var ${symbol_dollar}menuLabel = $("#subscriptionMenuLabel");
        ${symbol_dollar}menuLabel.html(label);
        ${symbol_dollar}menuLabel.parents('a').attr('href', "javascript:" + actionMethodName + "();");
      }

      function unsubscribe() {
        ${symbol_dollar}.post('<c:url value="/services/unsubscribe/${componentId}" />', successUnsubscribe(),
            'json');
      }

      function subscribe() {
        ${symbol_dollar}.post('<c:url value="/services/subscribe/${componentId}" />', successSubscribe(), 'json');
      }
    </script>
    </script>
  </head>
  <body>
  <view:operationPane>
    <c:if test="${symbol_dollar}{isUserSubscribed != null}">
      <c:choose>
        <c:when test="${symbol_dollar}{isUserSubscribed}">
          <view:operation altText="<span id='subscriptionMenuLabel'>${symbol_dollar}{unsubscribeLabel}</span>" icon="" action="javascript:unsubscribe();"/>
        </c:when>
        <c:otherwise>
          <view:operation altText="<span id='subscriptionMenuLabel'>${symbol_dollar}{subscribeLabel}</span>" icon="" action="javascript:subscribe();"/>
        </c:otherwise>
      </c:choose>
    </c:if>
  </view:operationPane>
    <view:window>
      <view:frame>
        Bienvenue sur l'application ${rootArtifactId}.
      </view:frame>
      <view:frame>
        <view:board>
          Cette instance s'appelle <span class="${rootArtifactId}Name"><c:out value="${symbol_dollar}{requestScope.browseContext[1]}" /></span>.<br/>
          Elle se situe dans l'espace <span class="${rootArtifactId}Name"><c:out value="${symbol_dollar}{requestScope.browseContext[0]}" /></span>.
        </view:board>
      </view:frame>
    </view:window>
  </body>
</html>