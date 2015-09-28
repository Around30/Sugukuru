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
			<%for(Object[] row: Dao.getInstance().executeQuery("select order_t.product_id, product_name, number_of from order_detail_t, product_t where order_id = ? and order_t.product_id = product_t.product_id", session.getAttribute("orderId"))){ %>
				<tr>
					<td><%=row[0] %></td>
					<td><%=row[1] %></td>
					<td><%=row[2] %>></td>
				</tr>
			<%}%>
		</table>
	</body>
</html>