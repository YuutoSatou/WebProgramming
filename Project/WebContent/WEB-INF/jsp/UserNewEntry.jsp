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
		<h1>ユーザ新規登録</h1>
		<br>ログインID <input type="text" name="loginid">
		<br>パスワード <input type="text" name="password">
		<br>パスワード確認 <input type="text" name="PasswordConfirmation">
		<br>ユーザ名 <input type="text" name="UserName">
		<br>生年月日 <input type="text" name="Seinengappi">
		<br>
		<input type ="submit" value="登録">
		<br>戻る

	</body>
</html>