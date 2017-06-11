<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>데이터베이스를 활용한 수강신청 시스템 입니다.</title>
</head>
<body>
<%@ include file="top.jsp" %>
<table width="75%" align="center" height="100%">
<% if (session_id != null) { %>
<tr>
<td align="center"><%=session_id%>님 방문을 환영합니다.</td>
</tr>
<% } else { %>
<tr>
<td align="center">로그인 후 사용하세요.</td>
</tr>
<%
}
%>
</table>
</body>
</html>