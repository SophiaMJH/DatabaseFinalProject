<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����ͺ��̽��� Ȱ���� ������û �ý��� �Դϴ�.</title>
<link rel="stylesheet" href="master_menu.css">
<link rel="stylesheet" href="master_main.css">
</head>
<body>
<%@ include file="master_menu.jsp" %>
<div id="content" align="center">
<% if (session_id != null) { %>
<h3><%=session_id%>�� �湮�� ȯ���մϴ�.</h3>
<% } else { %>
<h3>�α��� �� ����ϼ���.</h3>
<%
}
%>
</div>
</body>
</html>