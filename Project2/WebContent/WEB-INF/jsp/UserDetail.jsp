<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ユーザ情報詳細参照</title>
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
	<!-- body -->
	<div class="container">
		<div class="panel-body">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="form-group row">
						<label for="code" class="control-label col-sm-2">ログインID</label>
						<div class="col-sm-6">${user.loginId}</div>
					</div>
					<div class="form-group row">
						<label for="name" class="control-label col-sm-2">ユーザ名</label>
						<div class="col-sm-6">${user.name}</div>
					</div>
					<div class="form-group row">
						<label for="continent" class="control-label col-sm-2">生年月日</label>
						<div class="col-sm-6">${user.birthDate}</div>
					</div>
					<div class="form-group row">
						<label for="continent" class="control-label col-sm-2">登録日時</label>
						<div class="col-sm-6">${user.createDate}</div>
					</div>
					<div class="form-group row">
						<label for="continent" class="control-label col-sm-2">更新日時</label>
						<div class="col-sm-6">${user.updateDate}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<a href=UserListServlet>戻る</a>
	<!-- /body -->
</body>
</html>
