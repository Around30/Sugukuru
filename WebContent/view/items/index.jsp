<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object[] cData = (Object[])session.getAttribute("corporationLogin");
	boolean corporationFlg = (cData == null) ? true : false;  // headerをincludeするために必要
%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <title>すぐくる</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
  <!--font-awesome-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body>
  <jsp:include page="/view/layout/user/header.jsp" >
    <jsp:param name="corporationFlg" value="corporationFlg" />
  </jsp:include>
  <main>
    <article>
      <div class="itemLists boxList container-fluid">
        <div class="itemLists_head">
          <div class="itemLists_head_title">カテゴリ一覧</div>
        </div>
        <div class="itemList row">
          <% 
          	if(request.getParameter("product_genre_id") == null) {
        	  for(Object[] r: Dao.getInstance().executeQuery("select product_genre_id, product_genre_name from product_genre_t where rownum <= 44")){ 
       	  %>
          <div class="itemList_item boxList_item col-lg-3 col-md-3 col-sm-4">
            <a href="index.jsp?product_genre_id=<%=r[0]%>" class="itemList_item_newItemWrap">
              <div class="itemList_item_head"><%=r[1]%></div>
              <div class="itemList_item_img">
                <img src="<%= request.getContextPath() %>/assets/img/stationery/_01.jpg" alt="" class="img-responsive" />
              </div>
              <div class="itemList_item_detail">
                <h3 class="itemList_item_name"></h3>
              </div>
            </a>
          </div>
          <% 
	          }
          	} else {
          		for(Object[] o: Dao.getInstance().executeQuery(
          				"select * from product_t where product_genre_id = " + request.getParameter("product_genre_id"))) {
          %>
          <div class="itemList_item boxList_item col-lg-3 col-md-3 col-sm-4">
            <a href="item/index.jsp?product_id=<%=o[0]%>" class="itemList_item_newItemWrap">
              <div class="itemList_item_head"><%=o[0]%></div>
              <div class="itemList_item_img">
                <img src="<%= request.getContextPath() %>/assets/img/stationery/_01.jpg" alt="" class="img-responsive" />
              </div>
              <div class="itemList_item_detail">
                <h3 class="itemList_item_name"><%=o[1]%></h3>
              </div>
            </a>
          </div>
          <%
          		}
          	}
          %>
        </div>
      </div>
    </article>
  </main>
  <jsp:include page="/view/layout/user/footer.jsp" />
  <script src="<%= request.getContextPath() %>/js/main.js"></script>
  <script src="<%= request.getContextPath() %>/js/plugins.js"></script>
  <script src="<%= request.getContextPath() %>/js/vendor.js"></script>
</body>

</html>
