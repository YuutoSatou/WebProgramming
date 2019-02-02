<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link  rel="stylesheet" href="style.css">
	<title>title</title>
</head>
	<body>
	<div style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333; background-color: #999999; color: #ffffff;">
    ユーザ名 さん     <font color="RED">ログアウト</font>
	</div>
		<h1>ユーザ情報更新</h1>
		<form action="UserUpdateServlet" method="post">
		<br>ログインID <input type="text" name="loginId" id="inputLoginId"
			class="form-control" placeholder="ログインID" required autofocus value="${user.loginId}">
		<br>パスワード <input type="password" name="password"
			id="inputPassword" class="form-control" placeholder="パスワード"
			required>
		<br>パスワード確認 <input type="text" name="password2"
			id="inputPassword" class="form-control" placeholder="パスワード確認"
			required>
		<br>ユーザ名 <input type="text" name="UserName"
			id="UserName" class="form-control" placeholder="ユーザ名" required>
		<br>生年月日 <input type="text" name="Birth" id="Birth"
			class="form-control" placeholder="生年月日" required> <br>
			 <a href=UserListServlet>戻る</a><input type="submit" value="更新">
	</form>
	</body>
</html>