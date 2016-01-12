<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
      <div class="container">
		<form action="<%= request.getContextPath() %>/CorporationWebOrder" method="post">
			<div class="form-group">
				<label>ID</label>
				<input type="text" name="id" class="form-control"/>
			</div>
			<div class="form-group">
				<label>パスワード</label>
				<input type="password" name="password" class="form-control" value="<%=request.getSession().getAttribute("administratorLogin") != null? "管理者代行中": "" %>"/>
			</div>
			<div>
				<button type="submit" name="order" value="order" ><%=request.getSession().getAttribute("administratorLogin") != null? "注文確認メール送信": "注文確認画面へ" %></button>
				<button type="submit" name="order" value="estimate" ><%=request.getSession().getAttribute("administratorLogin") != null? "見積確認メール送信": "見積確認画面へ" %></button>
			</div>
		</form>
	  </div>

	  <jsp:include page="/view/layout/user/footer.jsp" />
	</body>
</html>