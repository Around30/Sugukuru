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
      <jsp:include page="<%= request.getContextPath() %>/view/layout/header.jsp" />
    </div>
    <div class="row">
      <jsp:include page="<%= request.getContextPath() %>/view/layout/nav.jsp" />
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">法人一覧</h1>
          <table class="table">
            <% for(Object[] r: Dao.getInstance().executeQuery( "select corporation_id, corporation_name from corporation_t")) { %>
            <tr>
                <td><%= request.getContextPath() %></td>
            </tr>
            <% } %>
          </table>
        </article>
      </main>
    </div>
    <div class="row">
      <jsp:include page="<%= request.getContextPath() %>/view/layout/footer.jsp" />
    </div>
  </div>
</body>
</html>