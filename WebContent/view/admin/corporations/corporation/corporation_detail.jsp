<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object[] corporationDetail = Dao.getInstance().corporationDetail(Integer.parseInt(request.getParameter("corporation_id")));
	Object[] loginUser = (Object[])session.getAttribute("administratorLogin");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
<title>法人詳細 | すぐくる</title>
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
          <h1 class="page-header">法人詳細 : <%=corporationDetail[1] %></h1>
          <form action="<%= request.getContextPath() %>/CorporationRegist" method="post">
            <div class="form-group">
              <label for="namel">法人ID :</label>
              <span><%=corporationDetail[0]%></span>
            </div>
            <div class="form-group">
              <label for="namel">法人名 :</label>
              <input type="text" class="from_control" id="namel" name="corporationName" value="<%=corporationDetail[1]%>"></input>
            </div>
            <div class="form-group">
              <label for="namel">郵便番号 :</label>
              <input type="text" class="from_control" id="namel" name="postalCode" value="<%=corporationDetail[2]%>"></input>
            </div>
            <div class="form-group">
              <label for="namel">法人所在地 :</label>
              <input type="text" class="from_control" id="namel" name="address" value="<%=corporationDetail[3]%>"></input>
            </div>
            <div class="form-group">
              <label for="namel">電話番号 :</label>
              <input type="text" class="from_control" id="namel" name="phoneNumber" value="<%=corporationDetail[4]%>"></input>
            </div>
            <%
            	//与信限度額設定フラグ = 0の場合このフォームを表示させない
            	if (Integer.parseInt((String)loginUser[2]) != 0) {
            %>
            <div class="form-group">
              <label for="namel">与信限度額 :</label>
              <input type="text" class="from_control" id="namel" name="creditLimit" value="<%=corporationDetail[5]%>"></input>
            </div>
            <%
            	}
            %>
            <div class="form-group">
              <label for="namel">登録日 :</label>
              <span><%=corporationDetail[6]%></span>
            </div>
            <%
            	// 与信限度額設定フラグ = 0の場合hiddenで与信限度額を設定
            	if (Integer.parseInt((String)loginUser[2]) == 0) {
         	%>
            <input type="hidden" name="creditLimit" value="<%=corporationDetail[5]%>">
            <% } %>
            <input type="hidden" name="corporationId" value="<%=corporationDetail[0]%>" />
            <input type="submit" class="btn btn-primary" name="edit" value="編集">
          </form>
        </article>
        <article>
          <h2 class="page-header">注文履歴</h1>
        </article>
      </main>
    </div>
    <div class="row">
      <footer class="footer col-md-12">
        <p> <small>Around30a</small>
        </p>
      </footer>
    </div>
  </div>
</body>
</html>