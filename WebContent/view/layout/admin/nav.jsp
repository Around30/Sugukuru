<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse col-md-12">
  <div class="container-fluid">
    <div class="navbar-head">
      <a href="#" class="navbar-brand">法人一覧 | すぐくる</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="<%= request.getContextPath() %>/view/admin/corporations/index.jsp">トップ</a></li>
      <li><a href="<%= request.getContextPath() %>/view/admin/corporations/index.jsp">法人一覧</a></li>
      <li><a href="">注文一覧</a></li>
      <li><a href="<%= request.getContextPath() %>/view/admin/corporations/corporation/corporation_regist.jsp">法人追加</a></li>
    </ul>
  </div>
</nav>