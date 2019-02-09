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
		<h1>ユーザ削除確認</h1>
		<form action="UserDeleteServlet" method="post">
        <br>ログインID <input type="text" name="loginId" id="inputLoginId"
			class="form-control" placeholder="ログインID" required autofocus value="${user.loginId}">
		<br>を本当に削除してよろしいでしょうか。
		<br><a href=UserListServlet>キャンセル</a>
		<input type="submit" value="削除">
	</form>
	</body>
</html>