<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SUGUKURU管理者</title>
  <link rel="stylesheet" href="./../../../css/main.css">
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
          <div class="navbar-head"> <a href="#" class="navbar-brand">SUGUKURU管理者</a>
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="">トップ</a></li>
            <li><a href="">法人一覧</a></li>
            <li><a href="">法人追加</a></li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">ログイン</h1>
          <form action="/AdminLogin">
            <div class="form-group">
              <label for="namel">管理者ID :</label>
              <input type="text" name="administratorId" class="from_control" id="namel"></input>
            </div>
            <div class="form-group">
              <label for="namel">パスワード :</label>
              <input type="text" name="passwd" class="from_control" id="namel"></input>
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