<%--

    Copyright (C) 2000 - 2011 Silverpeas

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    As a special exception to the terms and conditions of version 3.0 of
    the GPL, you may redistribute this Program in connection with Free/Libre
    Open Source Software ("FLOSS") applications as described in Silverpeas's
    FLOSS exception.  You should have received a copy of the text describing
    the FLOSS exception, and it is also available here:
    "http://repository.silverpeas.com/legal/licensing"

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

--%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../admin/jsp/importFrameSet.jsp" %>
<%@ page import="com.stratelia.silverpeas.peasCore.URLManager"%>
<%@ page import="${package}.Look${className}Helper"%>
<%@ page import="com.silverpeas.look.TopItem"%>

<%
Look${className}Helper helper = (Look${className}Helper) session.getAttribute("Silverpeas_LookHelper");
ResourceLocator settings = gef.getFavoriteLookSettings();

String currentComponentId 	= helper.getComponentId();
String currentSpaceId		= helper.getSpaceId();

boolean goToFavoriteSpaceOnHomeLink = settings.getBoolean("home.target.favoriteSpace", false);
String goToHome = "frameBottom${className}.jsp?FromTopBar=1";
if (goToFavoriteSpaceOnHomeLink) {
  goToHome += "&SpaceId="+m_MainSessionCtrl.getFavoriteSpace();
}

List topItems = helper.getTopItems();

String homePage = settings.getString("defaultHomepage");

boolean isAnonymousAccess = helper.isAnonymousAccess();

String wallPaper = helper.getSpaceWallPaper();
if (wallPaper == null) {
	wallPaper = gef.getIcon("wallPaper");
}
if (wallPaper == null) {
	wallPaper = "/weblib/${rootArtifactId}/images/bandeauTop.jpg";
}
	
boolean outilDisplayed = false;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>entete</title>
<%
	out.println(gef.getLookStyleSheet());
%>
<style type="text/css">
#shortcuts {
	bottom: 25px;
	position: absolute;
<% if(helper.isBackOfficeVisible()) { %>
	right: 120px;
<% } else { %>
	right: 0px;
<% } %>
	height: 20px;
	width: auto;
}
body {  
	background-image: url(<%=wallPaper%>); 
	background-repeat: no-repeat; 
	background-position: left top;
}
</style>
<script type="text/javascript" src="<%=m_sContext%>/util/javaScript/animation.js"></script>
<script type="text/javascript" src="<%=m_sContext%>/util/javaScript/lookV5/ticker.js"></script>
<script type="text/javascript" src="<%=m_sContext%>/util/javaScript/lookV5/connectedUsers.js"></script>
<script type="text/javascript" src="<%=m_sContext%>/util/javaScript/lookV5/tools.js"></script>
<script type="text/javascript" src="<%=m_sContext%>/util/javaScript/lookV5/topBar.js"></script>
<script type="text/javascript">
function goToHome()
{
	top.bottomFrame.location.href = "<%=goToHome%>";
}

function displayPDCFrame()
{
	return <%=helper.displayPDCFrame()%>;
}

function getConnectedUsersLabel(nb)
{
	if (nb == 1)
		return " <%=helper.getString("look${className}.connectedUser")%>";
	else
		return " <%=helper.getString("look${className}.connectedUsers")%>";
}

function getContext()
{
	return "<%=m_sContext%>";
}

function getDomainsBarPage()
{
	return "DomainsBar${className}.jsp";
}

function getTopBarPage()
{
	return "TopBar${className}.jsp";
}

function loadThisPage()
{
	setConnectedUsers(<%=helper.getNBConnectedUsers()%>);
}

function reloadTopBar()
{
	//Silverpeas V4 compatibility
}
//-->
</script>
</head>
<body bgcolor="#FFFFFF" onload="loadThisPage()">
<div id="topBar">
	<div style="position: absolute; right: 0px; top: 0px; background-color: #FFFFFF; width: 100%"><img src="icons/silverpeasV5/px.gif" border="0" height="0" id="space2Expand" align="middle" alt=""/></div>
	<div style="position: absolute; right: 0px; top: 2px"><a href="javascript:resizeFrame();"><img src="icons/silverpeasV5/reductTopBar.gif" border="0" align="middle" name="expandReduce" alt="<%=helper.getString("look${className}.reductExtend")%>" title="<%=helper.getString("look${className}.reductExtend")%>"/></a></div>
    <div id="backHome">
        <a href="javaScript:goToHome();"><img src="icons/silverpeasV5/px.gif" width="220" height="105" border="0" id="pxUrlHome" alt=""/></a></div>
        <script type="text/javascript">
			var xmlfile="/weblib/ticker/tickercontent_<%=language%>.txt" //path to ticker txt file on your server.
			//ajax_ticker(xmlfile, divId, divClass, delay, optionalfadeornot)
			new ajax_ticker(xmlfile, "ticker", "someclass", 3500, "fade");
		</script>
        <div id="outils">
        	<a href="#" onclick="javascript:onClick=openConnectedUsers();" style="visibility:hidden" id="connectedUsers"></a>
        <% if (!isAnonymousAccess && helper.getSettings("directoryVisible", true)) {
		    outilDisplayed = true; 
		%>
			<a href="<%=m_sContext%>/Rdirectory/jsp/Main" target="MyMain"><%=helper.getString("look${className}.directory")%></a>
		<% } %> 
		<% if (helper.getSettings("glossaryVisible", false)) {
				outilDisplayed = true; 
		%>
				<a href="javascript:onClick=openPdc()"><%=helper.getString("look${className}.glossaire")%></a> 
		<% } %> 
		<% if (helper.getSettings("mapVisible", true)) {
		    	if (outilDisplayed)
		    		out.print(" | ");
		    	outilDisplayed = true;
		    %>
				<a href="<%=m_sContext + "/admin/jsp/Map.jsp"%>" target="MyMain"><%=helper.getString("look${className}.Map")%></a> 
		<% } %>
		<% if (helper.getSettings("helpVisible", true)) { 
			if (outilDisplayed)
		    	out.print(" | ");
		    outilDisplayed = true;
		%>
			<a href="<%=helper.getSettings("helpURL", "/help_fr/Silverpeas.htm")%>" target="_blank"><%=helper.getString("look${className}.Help")%></a>
		<% } %> 
		<% if (!isAnonymousAccess && helper.getSettings("logVisible", true)) {
			if (outilDisplayed)
		    	out.print(" | ");
		    outilDisplayed = true; 
		%>
			<a href="<%=m_sContext + "/LogoutServlet"%>" target="_top"><%=helper.getString("look${className}.logout")%></a>
		<% } %>
        </div>

    <% if (topItems.size() > 0) { %>
    <div id="shortcuts">
        <table border="0" cellspacing="0" cellpadding="0">
        	<tr>
              <td class="gaucheShortcuts">&nbsp;</td>
              <td nowrap="nowrap" align="center"><img src="icons/silverpeasV5/px.gif" width="40" height="1" border="0"/></td>
              <%
            	TopItem item 		= null; 
            	String 	cssStyle 	= "";
            	String	componentId	= "";
            	String	spaceId		= "";
            	String 	subSpaceId	= "";
            	for (int c=0; c<topItems.size(); c++) {
            		item = (TopItem) topItems.get(c);
            		
            		//le composant est-il celui s�lectionn�
            		cssStyle = "";
            		if (item.getId().equals(currentComponentId) || item.getId().equals(currentSpaceId))
            			cssStyle = "activeShortcut";
            	%>
            		<td nowrap="nowrap" align="center" id="item<%=item.getId()%>" class="<%=cssStyle%>"><nobr><a href="javaScript:goToItem('<%=item.getSpaceId()%>', '<%=item.getSubSpaceId()%>', '<%=item.getComponentId()%>', '<%=m_sContext%><%=item.getUrl()%>', '<%=item.getId()%>', false);"><%=item.getLabel()%></a></nobr></td>
            		<td nowrap="nowrap" align="center"><img src="icons/silverpeasV5/px.gif" width="40" height="1" border="0"/></td>
            	<% } %>
                <td class="droiteShortcuts">&nbsp;</td>
            </tr>
        </table>
    </div>
    <% } %>
    
    <% if(helper.isBackOfficeVisible()) { %>
    <div id="administration">
       <table border="0" cellspacing="0" cellpadding="0">
       		<tr>
            	<td>
                <a href="<%=m_sContext + URLManager.getURL(URLManager.CMP_JOBMANAGERPEAS)%>Main" target="_top"><%=helper.getString("look${className}.backOffice")%></a>
                </td>
            </tr>
        </table>
    </div>
    <% } %>
</div>
<form name="searchForm" action="">
<input type="hidden" name="query"/>
</form>
</body>
</html>