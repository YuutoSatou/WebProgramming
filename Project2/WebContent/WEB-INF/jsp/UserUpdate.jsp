<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ユーザ一覧画面</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- オリジナルCSS読み込み -->
<link href="css/original/common.css" rel="stylesheet">
<!-- Jqeryの読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<!-- BootstrapのJS読み込み -->
	<script src="js/bootstrap.min.js">
</script>
<!-- レイアウトカスタマイズ用個別CSS -->

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
					<li class="navbar-text">${userInfo.name}さん</li>
					<li class="dropdown"><a href="LogoutServlet"
						class="navbar-link logout-link">ログアウト</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- /header -->
<body>
	<h1>ユーザ情報更新</h1>
	<form action="UserUpdateServlet" method="post">
		<br>ログインID <input type="text" name="loginId" id="inputLoginId"
			class="form-control" placeholder="ログインID" required autofocus
			value="${user.loginId}"> <br>パスワード <input
			type="password" name="password" id="inputPassword"
			class="form-control" placeholder="パスワード" required> <br>パスワード確認
		<input type="text" name="password2" id="inputPassword"
			class="form-control" placeholder="パスワード確認" required> <br>ユーザ名
		<input type="text" name="UserName" id="UserName" class="form-control"
			placeholder="ユーザ名" required> <br>生年月日 <input type="text"
			name="Birth" id="Birth" class="form-control" placeholder="生年月日"
			required> <br> <a href=UserListServlet>戻る</a><input
			type="submit" value="更新">
	</form>
</body>
</html>