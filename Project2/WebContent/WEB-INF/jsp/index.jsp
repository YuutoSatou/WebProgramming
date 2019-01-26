<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ログイン画面</title>
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- オリジナルCSS読み込み -->
    <link href="css/original/common.css" rel="stylesheet">
    <!-- Jqeryの読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
    <!-- レイアウトカスタマイズ用個別CSS -->

  </head>
  <body>

    <!-- header -->
    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand" href="index.html">ユーザ管理システム</a>
      		</div>

      	</div>
      </nav>
    </header>
    <!-- /header -->

    <!-- body -->
    <div class="container">

	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

      <div class="card card-container">
        <img id="profile-img" class="profile-img-card" src="./img/dammy_icon.png" />
        <p id="profile-name" class="profile-name-card"></p>
        <form class="form-signin" action="LoginServlet" method="post">
          <span id="reauth-email" class="reauth-email"></span>
          <input type="text" name="loginId" id="inputLoginId" class="form-control" placeholder="ログインID" required autofocus>
          <input type="password" name="password" id="inputPassword" class="form-control" placeholder="パスワード" required>
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">ログイン</button>
        </form><!-- /form -->
      </div><!-- /card-container -->
    </div><!-- /container -->


  </body>
</html>
