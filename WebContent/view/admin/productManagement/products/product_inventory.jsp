<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>商品管理部 | すぐくる</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
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
          <h1 class="page-header">棚卸結果入力</h1>
          <form action="<%= request.getContextPath() %>/ProductAcceptance" method="post">
	         <table class="table">
	           <tr>
	               <td>商品ID</td>
	               <td>商品名</td>
	               <td>個数</td>
	               <td>単価</td>
	               <td>金額</td>
	           </tr>
	           <%for(int i = 0; i < 10; i++){ %>
	           <tr>
	           		<td>
	               <input type="text" class="from_control" id="namel" name="productId"></input>
	               </td>
	               <td>
	               <input type="text" class="from_control" id="namel" name="productName"></input>
	               </td>
	               <td>
	               <input type="text" class="from_control" id="namel" name="numberOf"></input>
	               </td>
	               <td>
	               <input type="text" class="from_control" id="namel" name="price"></input>
	               </td>
	               <td>
	               <input type="text" class="from_control" id="namel" name="total"></input>
	               </td>
	           </tr>
	           <%} %>
	         </table>
	         <input type="submit" class="btn btn-primary" name="regist" value="登録">
          </form>
        </article>
      </main>
    </div>
    <div class="row">
      <jsp:include page="/view/layout/admin/footer.jsp" />
    </div>
  </div>
</body>

</html>