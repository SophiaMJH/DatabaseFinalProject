<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "databaseFinal.DBExecutor" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�л�����</title>
<script>
	function check(){
		var fr = document.getElementById("delete_form");
		if(fr.s_id.value.length < 1){
			alert("��ĭ�� �ֽ��ϴ�.");
			return false;
		}
		else
			fr.submit();
	}
</script>
</head>
<body>
	<form id="delete_form" action="master_delete_student_process.jsp" onsubmit="return check()" method="post">
       	<table>
			<tr><td bgcolor="rgb(13,45,132)" height="25" width="80" align="center"><font color="white">�й�</font></td>
			<td><input type="text" name="s_id"  /></tr>
       	</table>
       	<input type = "button" name="cancle_btn" value="���" onclick="self.close()"/>
		<input type="submit" name="submit_btn" value="����"/>
    </form>
</body>
</html>