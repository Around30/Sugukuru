<%@page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>すぐくる</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/bower_components/normalize-css/normalize.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/main.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="/view/layout/user/header.jsp">
		<jsp:param name="corporationFlg" value="corporationFlg" />
	</jsp:include>
	<p>見積内容はこちらでよろしいでですか？</p>
	<table class="table">
	<tbody>
		<%
			Object[] o = Dao.getInstance().executeGet(
					"select corporation_name, corporation_account_name from corporation_order_t, corporation_account_t, corporation_t where corporation_order_t.corporation_account_id = corporation_account_t.corporation_account_id and corporation_account_t.corporation_id = corporation_t.corporation_id and order_id = ?",
					session.getAttribute("orderId"));
		%>
		<tr>
			<th>企業名</th>
			<td><%=o[0]%></td>
		</tr>
		<tr>
			<th>アカウント名</th>
			<td><%=o[1]%></td>
		</tr>
		</tbody>
	</table>
	<table class="table">
	<tbody>
		<tr>
			<th>商品ID</th>
			<th>商品名</th>
			<th>個数</th>
		</tr>
		<%
			for (Object[] row : Dao.getInstance().executeQuery(
					"select order_detail_t.product_id, product_name, number_of from order_detail_t, product_t where order_id = ? and order_detail_t.product_id = product_t.product_id",
					session.getAttribute("orderId"))) {
		%>
		<tr>
			<td><%=row[0]%></td>
			<td><%=row[1]%></td>
			<td><%=row[2]%></td>
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
	<form action="submit"
		action="<%=request.getContextPath()%>/ConfirmEstimate" method="post">
		<input type="hidden" name="orderId"
			value="<%=session.getAttribute("orderId")%>" /> <input type="submit"
			value="承認" />
	</form>
	<jsp:include page="/view/layout/user/footer.jsp" />
</body>
</html>