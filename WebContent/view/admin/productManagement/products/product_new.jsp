<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
<title>商品登録 | すぐくる</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <jsp:include page="/view/layout/admin/header.jsp" />
    </div>
    <div class="row">
      <jsp:include page="/view/layout/admin/nav_pm.jsp" />
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">商品新規登録</h1>
          <form action="<%= request.getContextPath() %>/ProductRegist" method="post">

            <div class="form-group">
              <label for="namel">商品名 :</label>
              <input type="text" class="from_control" id="namel" name="productName"></input>
            </div>
            <div class="form-group">
              <label for="namel">フリガナ :</label>
              <input type="text" class="from_control" id="namel" name="productPhonetic"></input>
            </div>
            <div class="form-group">
              <label for="namel">価格 :</label>
              <input type="text" class="from_control" id="namel" name="price">円</input>
            </div>
            <div class="form-group">
              <label for="namel">メーカー :</label>
              <select name ="makerId">
              		<option value="">選択して下さい</option>
	              <% for(Object[] r: Dao.getInstance().executeQuery("select maker_id, maker_name from maker_t")){ %>
	              	<option  value  ="<%=r[0] %>" label="<%=r[0] %>,<%=r[1] %>"></option>
	              <% } %>
              </select>
            </div>
            <div class="form-group">
              <label for="namel">商品ジャンル :</label>
              <select name ="productGenreId">
              		<option value="">選択して下さい</option>
	              <% for(Object[] r: Dao.getInstance().executeQuery("select product_genre_id, product_genre_name from product_genre_t")){ %>
	              	<option value ="<%=r[0] %>" label="<%=r[0] %>,<%=r[1] %>" ></option>
	              <% } %>

              </select>
            </div>
            <div class="form-group">
              <label for="namel">原産地 :</label>
              <select name ="countryId">
             		 <option value="">選択して下さい</option>
	              <% for(Object[] r: Dao.getInstance().executeQuery("select country_id, cuontry_name from country_t")){ %>
	              	<option value ="<%=r[0] %>" label="<%=r[0] %>,<%=r[1] %>"></option>
	              <% } %>
              </select>
            </div>
            <div class="form-group">
              <label for="namel">サイズ :</label>
              W<input type="number" class="from_control" id="namel" name="productX">×</input>
              H<input type="number" class="from_control" id="namel" name="productY">×</input>
              D<input type="number" class="from_control" id="namel" name="productZ"></input>

            </div>
            <div class="form-group">
            重さ<input type="text" class="from_control" id="namel" name="productWeight"></input>
            </div>
            <div class="form-group">
              <label for="namel">商品説明 :</label>
               <textarea name="productDetail" class="from_control" id="namel" cols="40" rows="5" maxlength="200"></textarea>
            </div>
             <div class="form-group">
              <label for="namel">JANコード :</label>
              <input type="text" class="from_control" id="namel" name="janCode"></input>
            </div>
            <input type="submit" class="btn btn-primary" name="regist" value="登録">
          </form>
          <%if (msg != null) { %>
          <%= msg %>
          <%} %>
        </article>

      </main>
    </div>
    <div class="row">
      <jsp:include page="/view/layout/admin/footer.jsp" />
    </div>
  </div>

</body>
</html>