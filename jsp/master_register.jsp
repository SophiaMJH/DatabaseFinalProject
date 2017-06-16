<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>수업등록</title>
<link rel="stylesheet" href="master_menu.css">
<link rel="stylesheet" href="master_main.css">
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
<%@ include file="master_menu.jsp" %>
<div id="content" align="center">
	<form id="update_form" action="master_insert.jsp" onsubmit="return check()" method="post">
       	<table>
			<tr><td style="background-color: rgb(13,45,132)" height="50" width="100"align="center"><font color="white">교수번호</font></td>
			<td><input type="text" name="p_id" size="100"/></tr>
			<tr><td style="background-color: rgb(13,45,132)" height="50" width="100" align="center"><font color="white">과목번호</font></td>
			<td><input type="text" name="c_id" size="100"/></td></tr>
			<tr><td style="background-color: rgb(13,45,132)" height="50" width="100"align="center"><font color="white">요일</font></td>
			<td><input type="text" name="t_day" size="100"/></tr>
       		<tr><td style="background-color: rgb(13,45,132)" height="50" width="100" align="center"><font color="white">시작시간</font></td>
			<td><input type="text" name="t_start" size="100"/></tr>
			<tr><td style="background-color: rgb(13,45,132)" height="50" width="100" align="center"><font color="white">종료시간</font></td>
			<td><input type="text" name="t_end" size="100"/></tr>
			<tr><td style="background-color: rgb(13,45,132)" height="50" width="100" align="center"><font color="white">정원</font></td>
			<td><input type="text" name="t_max" size="100"/></tr>
			<tr><td style="background-color: rgb(13,45,132)" height="50" width="100" align="center"><font color="white">교실</font></td>
			<td><input type="text" name="t_room" size="100"/></tr>
       	</table>
       	<input type = "button" name="cancle_btn" value="취소" onclick="javascript:history.back(-1)"/>
		<input type="submit" name="submit_btn" value="등록"/>
     </form>
</div>
</body>
</html>