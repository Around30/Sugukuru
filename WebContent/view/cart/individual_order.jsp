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
	<div class="container">
		<form action="<%=request.getContextPath()%>/IndividualWebOrder"
			method="post">
			<div class="form-group">
				<label>氏名</label>
				<input type="text" name="name" class="form-control" />
			</div>

			<div class="form-group">
				<label>フリガナ</label>
				<input type="text" name="phonetic" class="form-control" />
			</div>

			<div class="form-group">
				<label>郵便番号</label>
				<input type="text" name="postalCode" class="form-control" />
			</div>

			<div class="form-group">
				<label>住所</label>
				<input type="text" name="address" class="form-control" />
			</div>

			<div class="form-group">
				<label>電話番号</label>
				<input type="text" name="phoneNumber" class="form-control" />
			</div>

			<div class="form-group">
				<label>メールアドレス</label>
				<input type="text" name="mailAddress" class="form-control" />
			</div>
			<p>
				<input type="submit" value="注文確認画面へ" />
			</p>
		</form>
	</div>

	<jsp:include page="/view/layout/user/footer.jsp" />
</body>
</html>