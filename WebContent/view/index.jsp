<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.ac.hal.Controller.*, jp.ac.hal.Dao.*, jp.ac.hal.Model.*, jp.ac.hal.Util.*, java.util.*"%>
<%
	Object[] cData = (Object[])session.getAttribute("corporationLogin");
	boolean corporationFlg = (cData == null) ? true : false;  // headerをincludeするために必要
	
	Dao dao = Dao.getInstance();
	List<Product> newProducts = dao.getNewItems(7);
	
	for(Product product : newProducts) {
		System.out.println(product.getJanCode());
	}
%>
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
  <!-- flexslider -->
  <div class="flexslider">
    <ul class="slides">
      <li>
        <img src="<%= request.getContextPath() %>/assets/img/slideImg/slide07.jpg" alt="">
      </li>
      <li>
        <img src="<%= request.getContextPath() %>/assets/img/slideImg/slide08.jpg" alt="">
      </li>
      <li>
        <img src="<%= request.getContextPath() %>/assets/img/slideImg/slide09.jpg" alt="">
      </li>
    </ul>
  </div>
  <!-- / flexslider -->
  <main>
    <article>
      <div class="itemLists container-fluid">
        <div class="itemList row">
          <!-- news -->
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4 news">
            <h2 class="itemList_item_head">NEWS</h2>
            <dl> <dt>2015.08.07</dt>
              <dd><a href="http://www.emme.jp/?p=1364">夏季・休業期間のお知らせ</a>
              </dd> <dt>2015.05.01</dt>
              <dd><a href="http://www.emme.jp/?p=1351">NEWタンポナートシリーズ一部プライス　変更のお知らせ</a>
              </dd> <dt>2015.04.28</dt>
              <dd><a href="http://www.emme.jp/?p=1344">GW休業日のお知らせ</a>
              </dd>
            </dl>
          </div>
          <!-- / news -->
          <!-- recommend_item -->
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap recommend">
              <div class="itemList_item_head">オススメ商品01</div>
              <div class="itemList_item_img">
                <img src="<%= request.getContextPath() %>/assets/img/stationery/_01.jpg" alt="" class="img-responsive" />
              </div>
              <div class="itemList_item_detail">
                <h3 class="itemList_item_name">『夜の木』レターセット ＜からみあう木＞</h3>
                <div class="itemList_item_price">Price：¥ 540</div>
              </div>
            </a>
          </div>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap recommend">
              <div class="itemList_item_head">オススメ商品02</div>
              <div class="itemList_item_img">
                <img src="<%= request.getContextPath() %>/assets/img/stationery/_01.jpg" alt="" class="img-responsive" />
              </div>
              <div class="itemList_item_detail">
                <h3 class="itemList_item_name">『夜の木』レターセット ＜からみあう木＞</h3>
                <div class="itemList_item_price">Price：¥ 540</div>
              </div>
            </a>
          </div>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="<%= request.getContextPath() %>/view/items" class="itemList_item_newItemWrap textBtn">
              <div class="itemList_item_onlyText">全てのオススメ商品を見る</div>
            </a>
          </div>
          <!-- / recommend_item -->
          
          <!-- 新商品 -->
          <% for(int i = 0; i < newProducts.size(); i++) { %>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap">
            <% String twoCharactersCharacter = String.format("%1$02d", (i + 1) ); // 2ケタのindex番号を作成 %>
              <div class="itemList_item_head">New Item<%= twoCharactersCharacter %></div>
              <div class="itemList_item_img">
                <img src="<%= request.getContextPath() %>/assets/img/stationery/_<%= twoCharactersCharacter %>.jpg" alt="" class="img-responsive" />
              </div>
              <div class="itemList_item_detail">
                <h3 class="itemList_item_name"><%= newProducts.get(i).getProductName() %></h3>
                <div class="itemList_item_price">Price：¥ <%= newProducts.get(i).getPrice() %></div>
              </div>
            </a>
          </div>
          <% } %>
          <!-- / 新商品 -->
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="<%= request.getContextPath() %>/view/items" class="itemList_item_newItemWrap textBtn">
              <div class="itemList_item_onlyText">全ての新作商品を見る</div>
            </a>
          </div>
        </div>
      </div>
    </article>
  </main>
  <jsp:include page="/view/layout/user/footer.jsp" />
  <script src="<%= request.getContextPath() %>/assets/bower_components/jquery/dist/jquery.min.js"></script>
  <script src="<%= request.getContextPath() %>/assets/bower_components/javascripts/bootstrap.min.js"></script>
  <script src="<%= request.getContextPath() %>/assets/bower_components/angular/angular.min.js"></script>
  <script src="<%= request.getContextPath() %>/assets/bower_components/flexslider/jquery.flexslider-min.js"></script>
  <script type="text/javascript" charset="utf-8">
    // スライドショーの設定
      $(window).load(function()
      {
        $('.flexslider').flexslider(
        {
          directionNav: false, // 左・右の矢印ボタンを表示しない
          slideshowSpeed: 5000 // 1枚のスライド画像を表示する秒数
        });
      });
  </script>
</body>
</html>