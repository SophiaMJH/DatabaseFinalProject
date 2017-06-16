<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>수업등록</title>
<script>
	function errorAndBack() {
		alert("에러");
		window.history.back();
	}
</script>
</head>
<body>
<%
	String mySQL = null;
	DBExecutor aDBExecutor = new DBExecutor();
	int result = 0;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String p_id = request.getParameter("p_id");
	String c_id = request.getParameter("c_id");
	String c_id_no = null;
	double t_year = 0;
	double t_semester = 0;
	String t_day = request.getParameter("t_day");
	t_day = new String(t_day.getBytes("8859_1"), "EUC-KR");
	String t_start = request.getParameter("t_start");
	String t_end = request.getParameter("t_end");
	double t_max = Double.parseDouble(request.getParameter("t_max"));
	String t_room = request.getParameter("t_room");
	t_room = new String(t_room.getBytes("8859_1"), "EUC-KR");
	
	Calendar c = Calendar.getInstance();
	t_year = (double)c.get(Calendar.YEAR);
	int t_month = c.get(Calendar.MONTH);
	if(t_month >= 1 && t_month <= 6)
		t_semester = 1;
	else
		t_semester = 2;	
	
	// p_id 가 Professor에 있는지 검
	mySQL = "SELECT * FROM professor WHERE p_id=" + p_id;
	rs = aDBExecutor.queryString(mySQL);
	if(!rs.next()) {%>
		<script>window.errorAndBack()</script>	
<%	}
	rs.close();
	aDBExecutor.closeStatementAndConnection();
	
	// c_id 가 Course에 있는지 검사
	String c_name = null;
	double c_unit = 0;
	mySQL = "SELECT c_id_no, c_name, c_unit FROM course WHERE c_id=" + c_id + " ORDER BY c_id_no DESC";
	rs = aDBExecutor.queryString(mySQL);
	if(rs.next()) {
		c_id_no = String.format("%03d", (Integer.parseInt(rs.getString(1)) + 1));
		c_name = rs.getString(2);
		c_unit = rs.getDouble(3);
		System.out.println(c_id_no);
	} else { %>
		<script>window.errorAndBack()</script>
<%	}
	rs.close();
	aDBExecutor.closeStatementAndConnection();
	
	// course table에 새로운 분반 삽입
	mySQL = "INSERT INTO course(c_id, c_id_no, c_name, c_unit) VALUES(?, ?, ?, ?)";
	pstmt = aDBExecutor.getPreparedStatement(mySQL);
	pstmt.setString(1, c_id);
	pstmt.setString(2, c_id_no);
	pstmt.setString(3, c_name);
	pstmt.setDouble(4, c_unit);
	result = aDBExecutor.updatePreparedStatement(pstmt); 
	result = 0;
	pstmt.close();
	aDBExecutor.closePreparedStatementAndConnection(pstmt);
	
	// teach table에 삽입
	mySQL = "INSERT INTO teach(p_id, c_id, c_id_no, t_year, t_semester, t_day, t_start, t_end, t_max, t_room) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
	pstmt = aDBExecutor.getPreparedStatement(mySQL);
	pstmt.setString(1, p_id);
	pstmt.setString(2, c_id);
	pstmt.setString(3, c_id_no);
	pstmt.setDouble(4, t_year);
	pstmt.setDouble(5, t_semester);
	pstmt.setString(6, t_day);
	pstmt.setString(7, t_start);
	pstmt.setString(8, t_end);
	pstmt.setDouble(9, t_max);
	pstmt.setString(10, t_room);
	result = aDBExecutor.updatePreparedStatement(pstmt); 
	pstmt.close();
	aDBExecutor.closePreparedStatementAndConnection(pstmt);
	if(result == 1) {%>
		<jsp:forward page="master_main.jsp" />
<%	} else { %>
		<script>window.errorAndBack()</script>
<%	}
%>
</body>
</html>