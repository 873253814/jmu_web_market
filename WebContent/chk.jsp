<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   String[] chk = request.getParameterValues("pro");
   String [] nums = request.getParameterValues("totalCount");
   
   out.print(Arrays.toString(chk)+"<br/>"+Arrays.toString(nums));



%>