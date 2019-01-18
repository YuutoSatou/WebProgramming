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

		<br>ログインID id0001
		<br>
		<br>パスワード <input type="text" name="password">
		<br>
		<br>パスワード(確認)<input type="text" name="PasswordConfirmation">
		<br>
		<br>ユーザ名 <div style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333;">
    	田中太郎
		</div>
		<br>生年月日<div style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333;">
   		1989 / 04 /26
		</div>
		<input type ="submit" value="更新">
		<br>戻る

	</body>
</html>