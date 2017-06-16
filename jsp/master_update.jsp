<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>수업정보수정</title>
<script>
	function returnToParent() {
		opener.parent.location.reload();
		window.close();
	}
</script>
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
	double t_max = Double.parseDouble(request.getParameter("t_max"));
	String t_room = request.getParameter("t_room");
	t_room = new String(t_room.getBytes("8859_1"), "EUC-KR");
	
	String mySQL = "UPDATE teach SET t_day= ?, t_start=?, t_end=?, t_max = ?, t_room =? WHERE p_id=? AND c_id=? AND c_id_no=?"; 
	DBExecutor aDBExecutor = new DBExecutor();
	PreparedStatement pstmt = aDBExecutor.getPreparedStatement(mySQL);
	pstmt.setString(1, t_day);
	pstmt.setString(2, t_start);
	pstmt.setString(3, t_end);
	pstmt.setDouble(4, t_max);
	pstmt.setString(5, t_room);
	pstmt.setString(6, p_id);
	pstmt.setString(7, c_id);
	pstmt.setString(8, c_id_no);
	int result = aDBExecutor.updatePreparedStatement(pstmt); 
	aDBExecutor.closePreparedStatementAndConnection(pstmt);
	if(result == 1) {%>
		<script>window.returnToParent()</script>
<%	} else { %>
		<script>alert("에러")</script>
<%	}
%>
</body>
</html>