<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "list.jsp" %>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>데이터베이스를 활용한 수강신청 시스템 입니다.</title>
<link rel="stylesheet" href="master_menu.css">
<link rel="stylesheet" href="master_main.css">
<script>
function check() {
	var fr = document.getElemntById(master_course);
		fr.submit();
}
</script>
</head>
<body>
<%@ include file="master_menu.jsp" %>
<div id="content" align="center">
<form id = "master_course" action = "master_course_process" onsubmit="return check()">
	<table>
			<tr height="5"><td width="5"></td></tr>
			<tr style = "border-color: rgb(13,45,132); border-style: solid; text-align: center; color: black">
				<td height = "28" width = "100">과목 번호</td>
				<td>분반</td>
				<td>과목명</td>
				<td>학점</td>
			</tr>
				<%
				String mySQL = "SELECT COUNT(*) FROM course";
				DBExecutor aDBExecutor = new DBExecutor();
				ResultSet rs = aDBExecutor.queryString(mySQL);
				if(rs.next())
					lastRow = rs.getInt(1);
				
				if(lastRow > 0) {
					mySQL = "select * FROM course ORDER BY c_id";
					rs = aDBExecutor.queryString(mySQL);
					for(i = 1; rs.next(); i++) {
						if(i >= startRow && i <= endRow) {
							String c_id = rs.getString("c_id");
							String c_id_no = rs.getString("c_id_no");
							String c_name = rs.getString("c_name");
							double c_unit = rs.getDouble("c_unit");
						
						%>
						<tr>
						<td align = "center"><%=c_id %></td>
						<td align = "center"><%=c_id_no %></td>
						<td align = "center"><%=c_name %></td>
						<td align = "center"><%=c_unit %></td>
						<td align="center"><a href="modify_master_course.jsp?c_id=<%=c_id%>&c_id_no=<%=c_id_no%>">수정</a></td>
						<td align="center"><a href="delete_master_course.jsp?c_id=<%=c_id%>&c_id_no=<%=c_id_no%>">삭제</a></td>
						
						</tr>
						<%
						}
					}
					
				}
			
				%>
				</table>
</form>
</div>
</body>
</html>