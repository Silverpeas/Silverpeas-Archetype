#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%--

    Copyright (C) 2000 - 2022 Silverpeas

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    As a special exception to the terms and conditions of version 3.0 of
    the GPL, you may redistribute this Program in connection with Free/Libre
    Open Source Software ("FLOSS") applications as described in Silverpeas's
    FLOSS exception.  You should have received a copy of the text describing
    the FLOSS exception, and it is also available here:
    "https://www.silverpeas.com/legal/licensing"

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

--%>
<%@ include file="check.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.silverpeas.com/tld/viewGenerator" prefix="view"%>
<%@ taglib uri="http://www.silverpeas.com/tld/silverFunctions" prefix="silfn" %>

<c:set var="componentId"         value="${symbol_dollar}{requestScope.browseContext[3]}"/>
<c:set var="currentUserLanguage" value="${symbol_dollar}{requestScope.resources.language}"/>
<fmt:setLocale value="${symbol_dollar}{currentUserLanguage}"/>
<view:setBundle bundle="${symbol_dollar}{requestScope.resources.multilangBundle}"/>
<view:setBundle bundle="${symbol_dollar}{requestScope.resources.iconsBundle}" var="icons"/>

<fmt:message key="${rootArtifactId}.menu.item.subscribe"   var="subscribeLabel"/>
<fmt:message key="${rootArtifactId}.menu.item.unsubscribe" var="unsubscribeLabel"/>

<c:set var="componentId"      value="${symbol_dollar}{requestScope.browseContext[3]}"/>
<c:url var="componentUriBase" value="${symbol_dollar}{requestScope.componentUriBase}"/>
<c:set var="currentUser"      value="${symbol_dollar}{requestScope.currentUser}"/>
<c:set var="highestUserRole"  value="${symbol_dollar}{requestScope.highestUserRole}"/>
<c:set var="isUserSubscribed" value="${symbol_dollar}{requestScope.isUserSubscribed}"/>

<view:sp-page>
  <view:sp-head-part>
    <view:includePlugin name="subscription"/>
    <script type="application/javascript">
      SUBSCRIPTION_PROMISE.then(function() {
        window.spSubManager = new SilverpeasSubscriptionManager({
          componentInstanceId : '${symbol_dollar}{componentId}', labels : {
            subscribe : '${symbol_dollar}{silfn:escapeJs(subscribeLabel)}',
            unsubscribe : '${symbol_dollar}{silfn:escapeJs(unsubscribeLabel)}'
          }
        });
      });
    </script>
  </view:sp-head-part>
  <view:sp-body-part>
    <view:browseBar componentId="${symbol_dollar}{componentId}" path="${symbol_dollar}{requestScope.navigationContext}"/>
    <view:operationPane>
      <c:if test="${symbol_dollar}{isUserSubscribed != null}">
        <view:operationSeparator/>
        <view:operation altText="<span id='subscriptionMenuLabel'></span>" icon="" action="javascript:spSubManager.switchUserSubscription()"/>
      </c:if>
    </view:operationPane>
    <view:window>
      <view:frame>
        Welcome in ${rootArtifactId}.
      </view:frame>
      <view:frame>
        <view:board>
          This component instance is named
          <span class="${rootArtifactId}Name"><c:out value="${symbol_dollar}{requestScope.browseContext[1]}"/></span>.<br/>
          It is in the collaborative space
          <span class="${rootArtifactId}Name"><c:out value="${symbol_dollar}{requestScope.browseContext[0]}"/></span>.
        </view:board>
      </view:frame>
    </view:window>
  </view:sp-body-part>
</view:sp-page>