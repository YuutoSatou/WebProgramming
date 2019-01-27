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

		<br>ログインID : id0001
		<br>を本当に削除してよろしいでしょうか。
		<br><a href=UserListServlet>キャンセル</a>
		<button type="button"
		onclick="location.reload()">
		削除
		</button>

	</body>
</html>