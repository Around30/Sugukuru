<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>商品管理部 | すぐくる</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css">
</head>
<body>
  <div class="container">
    <div class="row">
      <header class="header col-md-12">
        <h1>SUGUKURU管理者/商品管理部</h1>
      </header>
    </div>
    <div class="row">
      <nav class="navbar navbar-inverse col-md-12">
        <div class="container-fluid">
          <div class="navbar-head"> <a href="#" class="navbar-brand">商品一覧 | すぐくる</a>
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="">トップ</a></li>
            <li><a href="">商品一覧</a></li>
            <li><a href="">商品登録</a></li>
            <li><a href="">棚卸結果入力</a></li>
            <li><a href="">サンプル品持出内容入力</a></li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">商品一覧</h1>
          <table class="table">
            <% for(Object[] r: Dao.getInstance().executeQuery("select product_id, product_name from product_t")){ %>
            <tr>
                <td><a href="products/product_detail.jsp?product_id=<%=r[0]%>"><%=r[1]%></a></td>
            </tr>
            <% } %>
          </table>
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