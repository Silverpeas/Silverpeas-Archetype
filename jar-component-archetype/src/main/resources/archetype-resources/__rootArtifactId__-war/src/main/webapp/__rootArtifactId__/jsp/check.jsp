<%
response.setHeader("Cache-Control","no-store"); //HTTP 1.1
response.setHeader("Pragma","no-cache");        //HTTP 1.0
response.setDateHeader ("Expires",-1);          //prevents caching at the proxy server
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="../../admin/jsp/errorpageMain.jsp"%>