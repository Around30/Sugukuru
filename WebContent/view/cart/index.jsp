<%@page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
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
		<p><a href="individual_order.jsp">個人注文</a> <a href="corporation_order.jsp">法人注文</a></p>
	</body>
</html>