<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>LogIn</title>
</head>
<body>
<table width="75%" align="center" bgcolor="#FFFF99" border>
<tr><td><div align="center"> ���̵�� �н����带 �Է��ϼ���</table>
<table width="75%" align="center" border>
<FORM method="post" action="login_verify.jsp" >
<tr><td><div align="center">���̵�</div></td>
<td><div align="center"><input type="text" name="userID"></div></td>
</tr>
<tr><td><div align="center">�н�����</div></td>
<td><div align="center"><input type="password"
name="userPassword">
</div></td>
</tr>
<tr>
<td colspan=2><div align="center">
<INPUT TYPE="SUBMIT" NAME="Submit" VALUE="�α���">
<INPUT TYPE="RESET" VALUE="���">
</div></td>
</tr>
</table>
</FORM>
</body>
</html>