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
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css">
<title>法人詳細 | すぐくる</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <header class="header col-md-12">
        <h1>SUGUKURU管理者/</h1>
      </header>
    </div>
    <div class="row">
      <nav class="navbar navbar-inverse col-md-12">
        <div class="container-fluid">
          <div class="navbar-head"> <a href="#" class="navbar-brand">商品詳細 | すぐくる</a>
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="">トップ</a></li>
            <li><a href="">商品一覧</a></li>
            <li><a href="">商品登録</a></li>
            <li><a href="">棚卸結果入力</a></li>
            <li><a href="">サンプル品持出内容入力</a></li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="row">
      <main class="main col-md-12">
        <article>
          <h1 class="page-header">商品詳細 : <%=productDetail[1] %></h1>
          <form action="<%= request.getContextPath() %>/ProductRegist" method="post">
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
              <select name ="makerId" onchange = "selectedChange(makerId, <%=productDetail[4]%>)">
	              <% for(Object[] r: Dao.getInstance().executeQuery("select maker_id, maker_name from maker_t")){ %>
	              	<option  value  ="<%=r[0] %>" label="<%=r[0] %>,<%=r[1] %>"></option>
	              <% } %>
              </select>
            </div>
            <div class="form-group">
              <label for="namel">商品ジャンル :</label>
              <select name ="productGenreId" onchange = "selectedChange(productGenreId, <%=productDetail[5]%>)">
	              <% for(Object[] r: Dao.getInstance().executeQuery("select product_genre_id, product_genre_name from product_genre_t")){ %>
	              	<option value ="<%=r[0] %>" label="<%=r[0] %>,<%=r[1] %>" ></option>
	              <% } %>

              </select>
            </div>
            <div class="form-group">
              <label for="namel">原産地 :</label>
              <select name ="countryId" onchange = "selectedChange(countryId, <%=productDetail[6]%>)">
	              <% for(Object[] r: Dao.getInstance().executeQuery("select country_id, cuontry_name from country_t")){ %>
	              	<option value ="<%=r[0] %>" label="<%=r[0] %>,<%=r[1] %>"></option>
	              <% } %>
              </select>
            </div>
            <div class="form-group">
              <label for="namel">サイズ :</label>
              W<input type="text" class="from_control" id="namel" name="productX" value="<%=productDetail[7]%>">×</input>
              H<input type="text" class="from_control" id="namel" name="productY" value="<%=productDetail[8]%>">×</input>
              D<input type="text" class="from_control" id="namel" name="productZ" value="<%=productDetail[9]%>"></input>

            </div>
            <div class="form-group">
            重さ<input type="text" class="from_control" id="namel" name="productWeight" value="<%=productDetail[10]%>"></input>
            </div>
            <div class="form-group">
              <label for="namel">商品説明 :</label>
              <input type="text" class="from_control" id="namel" name="productDetail" value="<%=productDetail[11]%>"></input>
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
      <footer class="footer col-md-12">
        <p> <small>Around30a</small>
        </p>
      </footer>
       <script src="./../js/selected.js"></script>
    </div>
  </div>
</body>
</html>