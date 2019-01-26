<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link  rel="stylesheet" href="style.css">
	<title>title</title>
</head>
	<body>
		<h1 class="hello">ログイン画面</h1>
	<form class="form-signin" action="LoginServlet" method="post">

		<br>ログインID <input type="text" name="loginid">
		<br>パスワード <input type="text" name="password">
		<br>
		<input type ="submit" value="送信">
	</form>
	</body>
</html>