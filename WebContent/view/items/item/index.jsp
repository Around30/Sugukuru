<%@ page import="jp.ac.hal.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
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
          <a class="header_titleLogo navbar-brand" href="http://localhost:9000/view">
            <img src="<%= request.getContextPath() %>/img/sugukuru2.png" alt="すぐくる">
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
              <a href="">
                <div class="header_nav_icon"><i class="fa fa-user"></i>
                </div> <span class="header_nav_text">法人ログイン</span>
              </a>
            </li>
          </ul>
          <!-- /ヘッダーナビアイテム -->
        </div>
      </div>
    </nav>
    <!-- /ヘッダーナビ -->
  </header>
  <main>
    <article>
      <div class="item boxList container-fluid">
        <div class="row">
          <!-- 商品イメージ -->
          <div class="item_img boxList_item col-lg-5 col-md-5 col-sm-5">
            <div class="item_img_main">
              <img src="<%= request.getContextPath() %>/img/stationery/_08.jpg" alt="" class="img-responsive">
              <div class="container-fluid">
                <div class="row">
                  <div class="item_img_small col-lg-4 col-md-4 col-sm-4">
                    <img src="<%= request.getContextPath() %>/img/_detail01.jpg" alt="" class="img-responsive">
                  </div>
                  <div class="item_img_small col-lg-4 col-md-4 col-sm-4">
                    <img src="<%= request.getContextPath() %>/img/stationery/_detail02.jpg" alt="" class="img-responsive">
                  </div>
                  <div class="item_img_small col-lg-4 col-md-4 col-sm-4">
                    <img src="<%= request.getContextPath() %>/img/stationery/_detail03.jpg" alt="" class="img-responsive">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- / 商品イメージ -->
          <!-- 商品詳細 -->
          <div class="item_detail col-lg-7 col-md-7 col-sm-7">
            <div class="item_detail_title">アラスカ文具店 図形レターセット（青・赤）</div>
            <div class="item_detail_price">税込 ￥367 <span class="noneTax">（税抜￥340）</span>
            </div>
            <div class="item_detail_info">
              <p>岐阜県は柳ケ瀬商店街にあるアラスカ文具店のオリジナル文房具「図形レターセット」。 六角形の便箋と、三角形の封筒がセットになっています。 対角線に沿って便箋を折れば、三角の封筒のなかに収まるしかけ。 便箋は無地なので、文字はもちろんイラストも自由に書き込めます。 図形の面白さ、数学の美しさを身近な文房具に取り入れた素晴らしい一品で、 便箋が封筒にぴったりと収まる様は、単純ながらも感覚的な楽しさを呼び起こしてくれるでしょう。 数学に親しみはじめたお子様や、理系のあの人への贈りものとしても喜ばれそう。
              </p>
            </div>
            <dl class="item_detail_category"> <dt>カテゴリ</dt>
              <dd>書類</dd>
            </dl>
            <dl class="item_detail_place"> <dt>原産地</dt>
              <dd>日本</dd>
            </dl>
            <dl class="item_detail_size"> <dt>サイズ</dt>
              <dd>W11.5×H9.5×D.2</dd>
            </dl>
            <div class="item_cart">
              <form action="">
                <div class="item_cart_cntWrap">
                  <input type="button" value="-" id="minus1" class="item_cart_form_minus">
                  <input type="text" name="cnt" value="1" id="qty" class="item_cart_form_qty">
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
  <footer class="footer clearfix">
    <img src="<%= request.getContextPath() %>/img/sugukuru.png" alt="" class="footer_logo" />
    <div class="footer_nav">
      <ul>
        <li><a href="http://localhost:9000/view">ホーム</a>
        </li>
        <li><a href="">支払い・配送・返品について</a>
        </li>
        <li><a href="">特定商取引法に基く表記</a>
        </li>
        <li><a href="">お問い合わせ</a>
        </li>
      </ul>
    </div>
  </footer>
  <script src="./../../../js/main.js"></script>
  <script src="./../../../js/plugins.js"></script>
  <script src="./../../../js/vendor.js"></script>
</body>

</html>