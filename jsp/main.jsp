<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����ͺ��̽��� Ȱ���� ������û �ý��� �Դϴ�.</title>
</head>
<body>
<%@ include file="top.jsp" %>
<table width="75%" align="center" height="100%">
<% if (session_id != null) { %>
<tr>
<td align="center"><%=session_id%>�� �湮�� ȯ���մϴ�.</td>
</tr>
<% } else { %>
<tr>
<td align="center">�α��� �� ����ϼ���.</td>
</tr>
<%
}
%>
</table>
</body>
</html>