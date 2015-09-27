<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.ac.hal.Controller.*, jp.ac.hal.Dao.*, jp.ac.hal.Model.*, jp.ac.hal.Util.*"%>
<%
	Object[] cData = (Object[])session.getAttribute("corporationLogin");
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>すぐくる</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css">
  <!--font-awesome-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body>
  <header class="header">
    <!-- ヘッダーナビ -->
    <nav class="navbar navbar-default header_bg">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span>  <span class="icon-bar"></span>  <span class="icon-bar"></span>  <span class="icon-bar"></span>
          </button>
          <a class="header_titleLogo navbar-brand" href="#">
            <img src="http://localhost:9000/img/sugukuru2.png" alt="すぐくる">
          </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <!-- ヘッダーフォーム -->
          <form class="navbar-form navbar-left header_form" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-info">検索</button>
          </form>
          <!-- /ヘッダーフォーム -->
          <!-- ヘッダーナビアイテム -->
          <ul class="nav navbar-nav navbar-right header_nav">
            <li class="header_nav_item header_nav_cart">
              <a href="">
                <div class="header_nav_icon"><i class="fa fa-cart-arrow-down"></i>
                </div> <span class="header_nav_text">カート</span>
              </a>
            </li>
            <li class="header_nav_item header_nav_user">
            <% if (cData == null) {%>
              <a href="">
                <div class="header_nav_icon"><i class="fa fa-user"></i>
                </div> <span class="header_nav_text">法人ログイン</span>
              </a>
            <%} else { %>
            <%} %> 	
            </li>
          </ul>
          <!-- /ヘッダーナビアイテム -->
        </div>
      </div>
    </nav>
    <!-- /ヘッダーナビ -->
  </header>
  <!-- flexslider -->
  <div class="flexslider">
    <ul class="slides">
      <li>
        <img src="./../img/slideImg/slide07.jpg" alt="">
      </li>
      <li>
        <img src="./../img/slideImg/slide08.jpg" alt="">
      </li>
      <li>
        <img src="./../img/slideImg/slide09.jpg" alt="">
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
                <img src="./../img/stationery/_01.jpg" alt="" class="img-responsive" />
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
                <img src="./../img/stationery/_01.jpg" alt="" class="img-responsive" />
              </div>
              <div class="itemList_item_detail">
                <h3 class="itemList_item_name">『夜の木』レターセット ＜からみあう木＞</h3>
                <div class="itemList_item_price">Price：¥ 540</div>
              </div>
            </a>
          </div>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap textBtn">
              <div class="itemList_item_onlyText">全てのオススメ商品を見る</div>
            </a>
          </div>
          <!-- / recommend_item -->
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap">
              <div class="itemList_item_head">New Item01</div>
              <div class="itemList_item_img">
                <img src="./../img/stationery/_01.jpg" alt="" class="img-responsive" />
              </div>
              <div class="itemList_item_detail">
                <h3 class="itemList_item_name">『夜の木』レターセット ＜からみあう木＞</h3>
                <div class="itemList_item_price">Price：¥ 540</div>
              </div>
            </a>
          </div>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap genre1">
              <div class="itemList_item_head">New Item02</div>
              <div class="itemList_item_img">
                <img src="./../img/stationery/_02.jpg" alt="" class="img-responsive" />
              </div>
              <h3 class="itemList_item_name">CHARKHA×nakaban 引き出すカード＆封筒</h3>
              <div class="itemList_item_price">Price：¥ 194</div>
            </a>
          </div>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap">
              <div class="itemList_item_head">New Item03</div>
              <div class="itemList_item_img">
                <img src="./../img/stationery/_03.jpg" alt="" class="img-responsive" />
              </div>
              <h3 class="itemList_item_name">こけし通信筒（菜の花）</h3>
              <div class="itemList_item_price">Price：¥ 558</div>
            </a>
          </div>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap">
              <div class="itemList_item_head">New Item04</div>
              <div class="itemList_item_img">
                <img src="./../img/stationery/_04.jpg" alt="" class="img-responsive" />
              </div>
              <h3 class="itemList_item_name">CHARKHA × nakaban レターセット（antibes）</h3>
              <div class="itemList_item_price">Price：¥ 1296</div>
            </a>
          </div>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap">
              <div class="itemList_item_head">New Item05</div>
              <div class="itemList_item_img">
                <img src="./../img/stationery/_05.jpg" alt="" class="img-responsive" />
              </div>
              <div class="itemList_item_detail">
                <h3 class="itemList_item_name">CHARKHA × nakaban レターセット（late morning）</h3>
                <div class="itemList_item_price">Price：¥ 1296</div>
              </div>
            </a>
          </div>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap">
              <div class="itemList_item_head">New Item06</div>
              <div class="itemList_item_img">
                <img src="./../img/stationery/_06.jpg" alt="" class="img-responsive" />
              </div>
              <h3 class="itemList_item_name">武井武雄「鳥遣いの乙女」三つ折りカード+封筒セットA</h3>
              <div class="itemList_item_price">Price：¥ 972</div>
            </a>
          </div>
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap">
              <div class="itemList_item_head">New Item07</div>
              <div class="itemList_item_img">
                <img src="./../img/stationery/_07.jpg" alt="" class="img-responsive" />
              </div>
              <h3 class="itemList_item_name">武井武雄「鳥遣いの乙女」三つ折りカード+封筒セットB</h3>
              <div class="itemList_item_price">Price：¥ 972</div>
            </a>
          </div>
          <!--<div class="itemList_item col-lg-3 col-md-3 col-sm-4">-->
          <!--<a href="#" class="itemList_item_newItemWrap">-->
          <!--<div class="itemList_item_head">New Item08</div>-->
          <!--<div class="itemList_item_img">-->
          <!--<img src="./../img/stationery/_08.jpg" alt="" class="img-responsive"/>-->
          <!--</div>-->
          <!--<h3 class="itemList_item_name">アラスカ文具店 図形レターセット（青・赤）</h3>-->
          <!--<div class="itemList_item_price">Price：¥ 367</div>-->
          <!--</a>-->
          <!--</div>-->
          <div class="itemList_item col-lg-3 col-md-3 col-sm-4">
            <a href="#" class="itemList_item_newItemWrap textBtn">
              <div class="itemList_item_onlyText">全ての新作商品を見る</div>
            </a>
          </div>
        </div>
      </div>
    </article>
  </main>
  <footer>
    <p></p>
  </footer>
  <script src="./../js/main.js"></script>
  <script src="./../js/plugins.js"></script>
  <script src="./../js/vendor.js"></script>
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