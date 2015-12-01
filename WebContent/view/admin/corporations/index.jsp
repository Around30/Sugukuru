<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object[] loginUser = (Object[])session.getAttribute("administratorLogin");
	System.out.println("getContextPathは" + request.getContextPath());
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>法人一覧 | すぐくる</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
</head>
<body>
  <div class="container">
    <div class="row">
      <jsp:include page="/view/layout/admin/header.jsp" />
    </div>
    <div class="row">
      <jsp:include page="/view/layout/admin/nav.jsp" />
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">法人一覧</h1>
          <table class="table">
            <% for(Object[] r: Dao.getInstance().executeQuery( "select corporation_id, corporation_name from corporation_t")) { %>
            <tr>
                            <td><a href="<%= request.getContextPath() %>/view/admin/corporations/corporation/corporation_detail.jsp?corporation_id=<%=r[0]%>"><%=r[1]%></a></td>
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