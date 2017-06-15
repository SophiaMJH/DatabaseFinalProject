<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "list.jsp" %>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>학생정보수정</title>
</head>
<body>
<%
	String p_id = request.getParameter("p_id");
	String c_id = request.getParameter("c_id");
	String c_id_no = request.getParameter("c_id_no");
	String t_day = request.getParameter("t_day");
	t_day = new String(t_day.getBytes("8859_1"), "EUC-KR");
	String t_start = request.getParameter("t_start");
	String t_end = request.getParameter("t_end");
	String t_max = request.getParameter("t_max");
	String t_room = request.getParameter("t_room");
	t_room = new String(t_room.getBytes("8859_1"), "EUC-KR");
	
	String mySQL = "UPDATE teach SET t_day=" + t_day +",t_start=" + t_start + ",t_end=" + t_end + ",t_max='" + t_max + "',t_room=" + t_room 
	+ "WHERE p_id=" + p_id + " AND c_id=" + c_id + " AND c_id_no=" + c_id_no;
	System.out.println(mySQL);
	DBExecutor aDBExecutor = new DBExecutor();
	int success = aDBExecutor.updateString(mySQL);
	aDBExecutor.close();
	if(success == 1) {
		%>
		<jsp:forward page="master_main.jsp" />
	<%
	} else {
		
	}
%>
</body>
</html>