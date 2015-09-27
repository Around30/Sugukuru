<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>法人ログイン | すぐくる</title>
  <link rel="stylesheet" href="./../../css/main.css">
</head>
<body>
  <div class="container">
    <div class="row">
      <header class="header col-md-12">
        <h1>SUGUKURU管理者</h1> 
      </header>
    </div>
    <div class="row">
      <nav class="navbar navbar-inverse col-md-12">
        <div class="container-fluid">
          <div class="navbar-head"> <a href="#" class="navbar-brand">法人ログイン | すぐくる</a> 
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="">トップ</a>
            </li>
            <li><a href="">法人一覧</a>
            </li>
            <li><a href="">注文一覧</a>
            </li>
            <li><a href="">法人追加</a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">法人ログイン</h1>
          <form action="../../CorporationLogin">
            <div class="form-group">
              <label for="namel">法人ID :</label>
              <input type="text" class="from_control" id="namel" name="corporationId"></input>
            </div>
            <div class="form-group">
              <label for="namel">パスワード :</label>
              <input type="text" class="from_control" id="namel" name="passwd"></input>
            </div>
            <button class="btn btn-primary">ログイン</button>
          </form>
        </article>
      </main>
    </div>
    <div class="row">
      <footer class="footer col-md-12">
        <p><small>Around30a</small>
        </p>
      </footer>
    </div>
  </div>
</body>
</html>