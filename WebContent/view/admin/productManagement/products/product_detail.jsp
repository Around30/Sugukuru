<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object[] productDetail = Dao.getInstance().productDetail(Integer.parseInt(request.getParameter("product_id")));
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
<title>商品詳細 | すぐくる</title>
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
          <h1 class="page-header">商品詳細 : <%=productDetail[1] %></h1>
          <form action="<%= request.getContextPath() %>/ProductRegist" method="post" id ="f0">
            <div class="form-group">
              <label for="namel">商品ID :</label>
              <span><%=productDetail[0]%></span>
            </div>
            <div class="form-group">
              <label for="namel">商品名 :</label>
              <input type="text" class="from_control" id="namel" name="productName" value="<%=productDetail[1]%>"></input>
            </div>
            <div class="form-group">
              <label for="namel">フリガナ :</label>
              <input type="text" class="from_control" id="namel" name="productPhonetic" value="<%=productDetail[2]%>"></input>
            </div>
            <div class="form-group">
              <label for="namel">価格 :</label>
              <input type="text" class="from_control" id="namel" name="price" value="<%=productDetail[3]%>">円</input>
            </div>
            <div class="form-group">
              <label for="namel">メーカー :</label>
              <select name ="makerId">
	              <% for(Object[] r: Dao.getInstance().executeQuery("select maker_id, maker_name from maker_t")){ %>
	              	<option  value  ="<%=r[0] %>" label="<%=r[0] %>,<%=r[1] %>"></option>
	              <% } %>
              </select>
            </div>
            <div class="form-group">
              <label for="namel">商品ジャンル :</label>
              <select name ="productGenreId">
	              <% for(Object[] r: Dao.getInstance().executeQuery("select product_genre_id, product_genre_name from product_genre_t")){ %>
	              	<option value ="<%=r[0] %>" label="<%=r[0] %>,<%=r[1] %>" ></option>
	              <% } %>

              </select>
            </div>
            <div class="form-group">
              <label for="namel">原産地 :</label>
              <select name ="countryId">
	              <% for(Object[] r: Dao.getInstance().executeQuery("select country_id, cuontry_name from country_t")){ %>
	              	<option value ="<%=r[0] %>" label="<%=r[0] %>,<%=r[1] %>"></option>
	              <% } %>
              </select>
            </div>
            <div class="form-group">
              <label for="namel">サイズ :</label>
              W<input type="number" class="from_control" id="namel" name="productX" maxlength="8" value="<%=productDetail[7]%>">×</input>
              H<input type="number" class="from_control" id="namel" name="productY" maxlength="8" value="<%=productDetail[8]%>">×</input>
              D<input type="number" class="from_control" id="namel" name="productZ" maxlength="8" value="<%=productDetail[9]%>"></input>

            </div>
            <div class="form-group">
            重さ<input type="number" class="from_control" id="namel" name="productWeight" maxlength="8" value="<%=productDetail[10]%>"></input>
            </div>
            <div class="form-group">
              <label for="namel">商品説明 :</label>
              <textarea name="productDetail" class="from_control" id="namel" cols="40" rows="5" maxlength="200"><%=productDetail[11]%></textarea>
            </div>
             <div class="form-group">
              <label for="namel">JANコード :</label>
              <input type="text" class="from_control" id="namel" name="janCode" value="<%=productDetail[12]%>"></input>
            </div>

            <input type="hidden" name="productId" value="<%=productDetail[0]%>" />
            <input type="submit" class="btn btn-primary" name="edit" value="編集">
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
  <script src="./../../../../js/selected.js"></script>
  <script type="text/javascript" charset="utf-8">
	  window.onload=function(){
		  var f=document.getElementById("f0");
		  var ymd=new Date();
		  checkSelect(f.elements["makerId"],<%=productDetail[4]%>);
		  checkSelect(f.elements["productGenreId"],<%=productDetail[5]%>);
		  checkSelect(f.elements["countryId"],<%=productDetail[6]%>);
	  }
  </script>
</body>
</html>