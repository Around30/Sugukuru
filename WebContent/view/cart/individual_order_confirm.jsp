<%@page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<p>ご注文はこちらでよろしいでですか？</p>
		<table>
			<tr>
				<th>氏名</th>
				<td></td>
			</tr>
			<tr>
				<th>フリガナ</th>
				<td></td>
			</tr>
			<tr>
				<th>郵便番号</th>
				<td></td>
			</tr>
			<tr>
				<th>住所</th>
				<td></td>
			</tr>
			<tr>
				<th>電話番号</th>
				<td></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td></td>
			</tr>
		</table>
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
		<form action="submit">
			<input type="hidden" name="orderId" value="<%=session.getAttribute("orderId")%>" />
			<input type="hidden" name="revision" value="<%=Dao.getInstance().executeGet("select revision from order_t where order_id = ?", session.getAttribute("orderId"))[0] %>" />
			<input type="submit" value="承認" />
		</form>
	</body>
</html>