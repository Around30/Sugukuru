<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.ac.hal.Controller.*, jp.ac.hal.Dao.*, jp.ac.hal.Model.*, jp.ac.hal.Util.*"
    import="java.util.*"%>
<%
	Object[] loginUser = (Object[])session.getAttribute("administratorLogin");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>法人登録 | すぐくる</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css">
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
          <div class="navbar-head"> <a href="#" class="navbar-brand">法人登録 | すぐくる</a>
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="">トップ</a></li>
            <li><a href="">法人一覧</a></li>
            <li><a href="">注文一覧</a></li>
            <li><a href="">法人追加</a></li>
            <li>ログインユーザ : <%=loginUser[1] %>様</li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">法人登録</h1>
          <form action="<%= request.getContextPath() %>/CorporationRegist" method="post">
            <div class="form-group">
              <label for="namel">法人名 :</label>
              <input type="text" class="from_control" id="namel" name="corporationName"></input>
            </div>
            <div class="form-group">
              <label for="namel">郵便番号 :</label>
              <input type="text" class="from_control" id="namel" name="postalCode"></input>
            </div>
            <div class="form-group">
              <label for="namel">法人所在地 :</label>
              <input type="text" class="from_control" id="namel" name="address"></input>
            </div>
            <div class="form-group">
              <label for="namel">電話番号 :</label>
              <input type="text" class="from_control" id="namel" name="phoneNumber"></input>
            </div>
            <%
            	//与信限度額設定フラグ = 0の場合このフォームを表示させない
            	if (Integer.parseInt((String)loginUser[2]) != 0) {
            %>
            <div class="form-group">
              <label for="namel">与信限度額 :</label>
              <input type="text" class="from_control" id="namel" name="creditLimit" ></input>
            </div>
            <%
            	}
            %>
            <%
            	// 与信限度額設定フラグ = 0の場合hiddenで与信限度額を設定
            	if (Integer.parseInt((String)loginUser[2]) == 0) {
         	%>
            <input type="hidden" name="creditLimit">
            <% } %>
            <input type="submit" class="btn btn-primary" name="regist" value="登録">
          </form>
        </article>
      </main>
    </div>
    <div class="row">
      <footer class="footer col-md-12">
        <p> <small>Around30a</small>
        </p>
      </footer>
    </div>
  </div>
</body>
</html>