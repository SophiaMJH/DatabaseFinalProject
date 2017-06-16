<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>수업삭제</title>
</head>
<body>
<%
	String p_id = request.getParameter("p_id");
	String c_id = request.getParameter("c_id");
	String c_id_no = request.getParameter("c_id_no");
	if(p_id == null) {
		
	} else {
		String mySQL;
		DBExecutor aDBExecutor = new DBExecutor();
		int result = 0;
		
		mySQL = "DELETE FROM course WHERE c_id=" + c_id + " AND c_id_no=" + c_id_no;
		result = aDBExecutor.updateString(mySQL);
		aDBExecutor.closeStatementAndConnection();
		%>
		<jsp:forward page="master_main.jsp" />
		<%
	}
%>
</body>
</html>