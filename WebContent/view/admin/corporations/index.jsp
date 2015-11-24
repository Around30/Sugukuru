<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object[] loginUser = (Object[])session.getAttribute("administratorLogin");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>法人一覧 | すぐくる</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css">
</head>
<body>
  <div class="container">
    <div class="row">
      <jsp:include page="/view/layout/header.jsp" />
    </div>
    <div class="row">
      <jsp:include page="/view/layout/nav.jsp" />
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">法人一覧</h1>
          <table class="table">
<<<<<<< Updated upstream
            <% for(Object[] r: Dao.getInstance().executeQuery("select corporation_id, corporation_name from corporation_t")) { %>
            <tr>
                <td><a href="/Sugukuru/view/admin/corporations/corporation/corporation_detail.jsp?corporation_id=<%=r[0]%>"><%=r[1]%></a></td>
=======
            <tr>
              <td>テスト会社</td>
>>>>>>> Stashed changes
            </tr>
          </table>
        </article>
      </main>
    </div>
    <div class="row">
      <jsp:include page="/view/layout/footer.jsp" />
    </div>
  </div>
</body>
</html>