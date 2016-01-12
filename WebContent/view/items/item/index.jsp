<%@page import="jp.ac.hal.Model.Product"%>
<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int product_id = Integer.parseInt(request.getParameter("product_id"));
	Object[] o = Dao.getInstance().productDetail(product_id);
	for (int i = 0 ; i < o.length ; i++) {
		System.out.println(o[i]);
	}
	
	// 受け取ったproduct_idよりProduct型のオブジェクトを取得する
	Product product = Dao.getInstance().getProductFromProdutId(product_id);
	System.out.println("受け取ったproductの名前は" + product.getProductName());
	
	
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
      <div class="item boxList container-fluid">
        <div class="row">
          <!-- 商品イメージ -->
          <div class="item_img boxList_item col-lg-5 col-md-5 col-sm-5">
            <div class="item_img_main">
              <img src="<%= request.getContextPath() %>/assets/img/stationery/_08.jpg" alt="" class="img-responsive">
              <div class="container-fluid">
                <div class="row">
                  <div class="item_img_small col-lg-4 col-md-4 col-sm-4">
                    <img src="<%= request.getContextPath() %>/assets/img/_detail01.jpg" alt="" class="img-responsive">
                  </div>
                  <div class="item_img_small col-lg-4 col-md-4 col-sm-4">
                    <img src="<%= request.getContextPath() %>/assets/img/stationery/_detail02.jpg" alt="" class="img-responsive">
                  </div>
                  <div class="item_img_small col-lg-4 col-md-4 col-sm-4">
                    <img src="<%= request.getContextPath() %>/assets/img/stationery/_detail03.jpg" alt="" class="img-responsive">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- / 商品イメージ -->
          <!-- 商品詳細 -->
          <div class="item_detail col-lg-7 col-md-7 col-sm-7">
            <div class="item_detail_title"><%=o[1] %></div>
            <div class="item_detail_price">税込<%=o[3] %>円</span>
            </div>
            <div class="item_detail_info">
              <p><%=o[11] %></p>
            </div>
            <dl class="item_detail_category"> <dt>カテゴリ</dt>
              <dd><%=o[14] %></dd>
            </dl>
            <dl class="item_detail_place"> <dt>原産地</dt>
              <dd><%=o[16] %></dd>
            </dl>
            <dl class="item_detail_size"> <dt>サイズ</dt>
              <dd>W<%=o[8]%>×H<%=o[9]%>×D<%=o[10]%></dd>
            </dl>
            <div class="item_cart">
              <form action="<%= request.getContextPath() %>/AddToCart" method="post">
                <div class="item_cart_cntWrap">
                  <input type="hidden" name="productId" value="<%=o[0] %>" />
                  <input type="button" value="-" id="minus1" class="item_cart_form_minus">
                  <input type="text" name="numberOf" value="1" id="qty" class="item_cart_form_qty">
                  <input type="button" value="+" id="plus1" class="item_cart_form_plus">
                </div>
                <input type="submit" value="カートに入れる" class="item_cart_submit">
              </form>
            </div>
          </div>
        </div>
        <!-- / 商品詳細 -->
      </div>
    </article>
  </main>
  <jsp:include page="/view/layout/user/footer.jsp" />
  <script src="<%= request.getContextPath() %>/js/main.js"></script>
  <script src="<%= request.getContextPath() %>/js/plugins.js"></script>
  <script src="<%= request.getContextPath() %>/js/vendor.js"></script>
</body>

</html>