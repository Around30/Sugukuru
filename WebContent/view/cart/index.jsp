<%@page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Object[] cData = (Object[])session.getAttribute("corporationLogin");
	boolean corporationFlg = (cData == null) ? true : false;  // headerをincludeするために必要
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>すぐくる</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/bower_components/normalize-css/normalize.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  </head>
	<body>
	<jsp:include page="/view/layout/user/header.jsp" >
      <jsp:param name="corporationFlg" value="corporationFlg" />
    </jsp:include>
		<table>
			<tr>
				<th>商品ID</th>
				<th>商品名</th>
				<th>個数</th>
			</tr>
			<%for(Object[] row: Dao.getInstance().executeQuery("select order_detail_t.product_id, product_name, number_of from order_detail_t, product_t where order_id = ? and order_detail_t.product_id = product_t.product_id", session.getAttribute("orderId"))){ %>
			<tr>
				<td><%=row[0] %></td>
				<td><%=row[1] %></td>
				<td><%=row[2] %></td>
			</tr>
			<%}%>
		</table>
		<p><a href="individual_order.jsp">個人注文画面へ</a> <a href="corporation_order.jsp">法人注文画面へ</a></p>
		<jsp:include page="/view/layout/user/footer.jsp" />
	</body>
</html>