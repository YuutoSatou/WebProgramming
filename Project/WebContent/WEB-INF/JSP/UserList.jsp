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
	<br>
		<h1>ユーザ一覧</h1>
		<font color="BLUE">新規登録</font>
		<br>ログインID <input type="text" name="loginid">
		<br>ユーザ名 <input type="text" name="UserName">
<br>生年月日 <input type="date" name="Birth" value="年/月/日" max="9999-12-31">～
<input type="date" name="MonthDay" value="年/月/日" max="9999-12-31">
		<br>
		<input type ="submit" value="検索">
		<table border="1">
  <tr>
    <th>ログインID</th>
    <th>ユーザ名</th>
    <th>生年月日</th>
    <th> </th>
  </tr>
  <tr>
    <td>id0001</td>
    <td>田中太郎</td>
    <td>1989年04月21日</td>
   <td> <a href="リンク先のＵＲＬ">詳細 更新 削除</a></td>
  </tr>
  <tr>
    <td>id0002</td>
    <td>佐藤二朗</td>
    <td>2001年11月12日</td>
    <td> <a href="リンク先のＵＲＬ">詳細 更新 削除</a></td>
  </tr>
  	<td>id0003</td>
  	<td>佐川真司</td>
  	<td>2000年01月01日</td>
  	<td> <a href="リンク先のＵＲＬ">詳細 更新 削除</a></td>
</table>

	</body>
</html>