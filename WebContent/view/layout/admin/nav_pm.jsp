<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse col-md-12">
  <div class="container-fluid">
    <div class="navbar-head">
      <a href="#" class="navbar-brand">商品管理部 | すぐくる</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="<%= request.getContextPath() %>/view/admin/productManagement/index.jsp">トップ</a></li>
      <li><a href="<%= request.getContextPath() %>/view/admin/productManagement/index.jsp">商品一覧</a></li>
      <li><a href="<%= request.getContextPath() %>/view/admin/productManagement/products/product_new.jsp">新規登録</a></li>
      <li><a href="">商品受入</a></li>
      <li><a href="<%= request.getContextPath() %>/view/admin/productManagement/products/product_acceptance.jsp">棚卸</a></li>
      <li><a href="">サンプル品持出</a></li>
      <li><a href="">緊急発注</a></li>
    </ul>
  </div>
</nav>