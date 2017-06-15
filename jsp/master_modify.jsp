<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>학생정보수정</title>
<script>
	function check(){
		var fr = document.getElementById("update_form");
		if((fr.t_day.value.length < 1) || (fr.t_start.value.length < 1) ||
				(fr.t_end.value.length < 1) || (fr.t_max.value.length < 1) || (fr.t_room.value.length < 1)){
			alert("빈칸이 있습니다.");
			return false;
		}
		else
			fr.submit();
	}
</script>
</head>
<body>
<%
	String p_id = request.getParameter("p_id");
	String c_id = request.getParameter("c_id");
	String c_id_no = request.getParameter("c_id_no");

	String mySQL = "SELECT COUNT(*) FROM teach";
	DBExecutor aDBExecutor = new DBExecutor();
	mySQL = "select t.p_id, t.c_id, t.c_id_no, p_name, c_name, t_day, t_start, t_end, t_max, t_room " + 
			"FROM teach t, course c, professor p " + 
			"WHERE t.p_id = p.p_id AND t.c_id = c.c_id AND t.c_id_no = c.c_id_no AND t.p_id="+ p_id + " AND t.c_id=" + c_id +" AND t.c_id_no=" + c_id_no;
	ResultSet rs = aDBExecutor.queryString(mySQL);
	if(rs.next()) {
		String p_name = rs.getString("p_name");
		String c_name = rs.getString("c_name");
		String t_day = rs.getString("t_day");
		String t_start = rs.getString("t_start");
		String t_end = rs.getString("t_end");
		String t_max = rs.getString("t_max");
		String t_room = rs.getString("t_room");
		
%>
		<form id="update_form" action="master_update.jsp" onsubmit="return check()" method="post">
       	<table>
			<td><input type="hidden" name="p_id" value="<%=p_id %>" /></td></tr>
			<td><input type="hidden" name="c_id" value="<%=c_id %>" /></td></tr>
			<td><input type="hidden" name="c_id_no" value="<%=c_id_no %>" /></td></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="25" align="center"><font color="white">교수명</font></td>
			<td><input type="text" name="p_name" value="<%=p_name %>" readonly="readonly" /></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="25" align="center"><font color="white">과목명</font></td>
			<td><input type="text" name="c_name" value="<%=c_name %>" readonly="readonly"/></td></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="25" width="80" align="center"><font color="white">요일</font></td>
			<td><input type="text" name="t_day" value="<%=t_day %>" /></tr>
       		<tr><td bgcolor="rgb(13,45,132)" height="25" width="80" align="center"><font color="white">시작시간</font></td>
			<td><input type="text" name="t_start" value="<%=t_start %>" /></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="25" width="80" align="center"><font color="white">종료시간</font></td>
			<td><input type="text" name="t_end" value="<%=t_end %>" /></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="25" width="80" align="center"><font color="white">정원</font></td>
			<td><input type="text" name="t_max" value="<%=t_max %>" /></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="25" width="80" align="center"><font color="white">교실</font></td>
			<td><input type="text" name="t_room" value="<%=t_room %>" /></tr>
       	</table>
       	<input type = "button" name="cancle_btn" value="취소" onclick="self.close()"/>
		<input type="submit" name="submit_btn" value="수정"/>
       	</form>
  <%} %>

</body>
</html>