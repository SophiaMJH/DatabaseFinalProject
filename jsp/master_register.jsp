<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������</title>
<script>
	function check(){
		var fr = document.getElementById("update_form");
		if((fr.t_day.value.length < 1) || (fr.t_start.value.length < 1) ||
				(fr.t_end.value.length < 1) || (fr.t_max.value.length < 1) || (fr.t_room.value.length < 1)){
			alert("��ĭ�� �ֽ��ϴ�.");
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
       		<tr><td></td>
			<tr><td bgcolor="rgb(13,45,132)" height="50" width="100"align="center"><font color="white">������ȣ</font></td>
			<td><input type="text" name="p_id" height="50" width="500 "/></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="50" width="100"align="center"><font color="white">�����ȣ</font></td>
			<td><input type="text" name="c_id" height="50" width="500 " /></td></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="50" width="100" align="center"><font color="white">����</font></td>
			<td><input type="text" name="t_day" height="50" width="500 " /></tr>
       		<tr><td bgcolor="rgb(13,45,132)" height="50" width="100" align="center"><font color="white">���۽ð�</font></td>
			<td><input type="text" name="t_start" height="50" width="500 " /></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="50" width="100" align="center"><font color="white">����ð�</font></td>
			<td><input type="text" name="t_end" height="50" width="500 " /></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="50" width="100" align="center"><font color="white">����</font></td>
			<td><input type="text" name="t_max" height="50" width="500 " /></tr>
			<tr><td bgcolor="rgb(13,45,132)" height="50" width="100" align="center"><font color="white">����</font></td>
			<td><input type="text" name="t_room" height="50" width="500 " /></tr>
       	</table>
       	<input type = "button" name="cancle_btn" value="���" onclick="javascript:history.back(-1)"/>
		<input type="submit" name="submit_btn" value="���"/>
     </form>
</div>
</body>
</html>