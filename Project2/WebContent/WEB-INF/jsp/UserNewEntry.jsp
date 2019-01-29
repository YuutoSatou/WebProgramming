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
	<!-- header -->
    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand" href="userCreate.html">ユーザ管理システム</a>
      		</div>

          <ul class="nav navbar-nav navbar-right">
            <li class="navbar-text">${userInfo.name} さん </li>
  			<li class="dropdown">
  			  <a href="LogoutServlet" class="navbar-link logout-link">ログアウト</a>
            </li>
  		  </ul>
      	</div>
      </nav>
    </header>
    <!-- /header -->
	<div style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333; background-color: #999999; color: #ffffff;">
	</div>
		<h1>ユーザ新規登録</h1>
		<form method="post" action="UserNewEntryServlet">

		<br>ログインID <input type="text" name="loginId" id="inputLoginId" class="form-control" placeholder="ログインID" required autofocus>
		<br>パスワード <input type="password" name="password" id="inputPassword" class="form-control" placeholder="パスワード" required>
		<br>パスワード確認 <input type="text" name="PasswordConfirmation" id="inputPassword" class="form-control" placeholder="パスワード確認" required>
		<br>ユーザ名 <input type="text" name="UserName" id="UserName" class="form-control" placeholder="ユーザ名" required>
		<br>生年月日 <input type="text" name="Birth" id="Birth" class="form-control" placeholder="生年月日" required>
		<br><input type ="submit" value="登録">
		<br><a href=UserListServlet>戻る</a>
		</form>

	</body>
</html>