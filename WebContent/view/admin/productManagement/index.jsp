<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>商品管理部 | すぐくる</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
</head>
<body>
  <div class="container">
    <div class="row">
      <jsp:include page="/view/layout/admin/header.jsp" />
    </div>
    <div class="row">
      <jsp:include page="/view/layout/admin/nav_pm.jsp" />
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
      <jsp:include page="/view/layout/admin/footer.jsp" />
    </div>
  </div>
</body>

</html>