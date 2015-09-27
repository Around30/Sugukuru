<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.ac.hal.Controller.*, jp.ac.hal.Dao.*, jp.ac.hal.Model.*, jp.ac.hal.Util.*"
    import="java.util.*"%>
<%
	ArrayList<String> msg = (ArrayList<String>)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>法人ログイン | すぐくる</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css">
</head>
<body>
  <div class="container">
    <div class="row">
      <header class="header col-md-12">
        <h1>法人ログイン</h1>
      </header>
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">法人ログイン</h1>
          <form action="<%= request.getContextPath() %>/CorporationLogin" method="post">
            <div class="form-group">
              <label for="namel">法人アカウントID :</label>
              <input type="text" class="from_control" id="namel" name="corporationId"></input>
            </div>
            <div class="form-group">
              <label for="namel">パスワード :</label>
              <input type="text" class="from_control" id="namel" name="passwd"></input>
            </div>
            <button class="btn btn-primary">ログイン</button>
          </form>
          <%if (msg != null) { %>
          <%=msg.get(0) %>
          <%} %>
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