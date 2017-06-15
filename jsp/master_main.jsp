<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>데이터베이스를 활용한 수강신청 시스템 입니다.</title>
<link rel="stylesheet" href="master_menu.css">
<link rel="stylesheet" href="master_main.css">
</head>
<body>
<%@ include file="master_menu.jsp" %>
<div id="content" align="center">
<% if (session_id != null) { %>
<h3><%=session_id%>님 방문을 환영합니다.</h3>
<% } else { %>
<h3>로그인 후 사용하세요.</h3>
<%
}
%>
</div>
</body>
</html>