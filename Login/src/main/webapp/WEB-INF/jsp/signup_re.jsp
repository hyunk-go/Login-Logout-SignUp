<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입_재시도</title>
</head>
<body>
<center>
<h1>
SIGN UP
</h1>
The ID is duplicated. Try again.

<form method="post" action="/signup">
ID:<input type="text" name="id">
PW:<input type="password" name="pw">
<input type="submit" value="SIGNUP">
</center>
</body>
</html>