<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <!-- body -->
    <div class="container">

      <div class="text-right">
        <a href="UserNewEntryServlet">新規登録</a>
      </div>


      <div class="panel-body">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title">検索条件</div>
            </div>
            <div class="panel-body">
              <form method="post" action="#" class="form-horizontal">
                <div class="form-group">
                  <label for="code" class="control-label col-sm-2">ログインID</label>
                  <div class="col-sm-6">
                    <input type="text" name="login-id" id="login-id" class="form-control"/>
                  </div>
                </div>
                <div class="form-group">
                  <label for="name" class="control-label col-sm-2">ユーザ名</label>
                  <div class="col-sm-6">
                    <input type="text" name="user-name" id="user-name" class="form-control"/>
                  </div>
                </div>
                <div class="form-group">
                  <label for="continent" class="control-label col-sm-2">生年月日</label>
                  <div class="row">
                    <div class="col-sm-2">
                      <input type="date" name="date-start" id="date-start" class="form-control" size="30"/>
                    </div>
                    <div class="col-xs-1 text-center">
                      ~
                    </div>
                    <div class="col-sm-2">
                      <input type="date" name="date-end" id="date-end" class="form-control"/>
                    </div>
                </div>
                </div>
                <div class="text-right">
                  <button type="submit" value="検索" class="btn btn-primary form-submit">検索</button>
                </div>
              </form>
            </div>
        </div>

        <div class="table-responsive">
             <table class="table table-striped">
               <thead>
                 <tr>
                   <th>ログインID</th>
                   <th>ユーザ名</th>
                   <th>生年月日</th>
                   <th></th>
                 </tr>
               </thead>
               <tbody>
                 <c:forEach var="user" items="${userList}" >
                   <tr>
                     <td>${user.loginId}</td>
                     <td>${user.name}</td>
                     <td>${user.birthDate}</td>
                     <!-- TODO 未実装；ログインボタンの表示制御を行う -->
                     <td>
                       <a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
                       <a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
                       <a class="btn btn-danger" href="UserDeleteServlet?id=${user.id}">削除</a>
                     </td>
                   </tr>
                 </c:forEach>
               </tbody>
             </table>
           </div>
         </div>
      </div>
    </div>

  </body>
</html>
