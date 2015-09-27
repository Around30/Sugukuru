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
      <div class="itemLists boxList container-fluid">
        <div class="itemLists_head">
          <div class="itemLists_head_title">カテゴリ一覧</div>
        </div>
        <div class="itemList row">
          <% for(Object[] r: Dao.getInstance().executeQuery("select product_genre_id, product_genre_name from product_genre_t where rownum <= 10")){ %>
          <div class="itemList_item boxList_item col-lg-3 col-md-3 col-sm-4">
            <a href="corporation_detail.jsp?=product_genre_id<%=r[0]%>" class="itemList_item_newItemWrap">
              <div class="itemList_item_head"><%=r[1]%></div>
              <div class="itemList_item_img">
                <img src="./../../img/stationery/_01.jpg" alt="" class="img-responsive" />
              </div>
              <div class="itemList_item_detail">
                <h3 class="itemList_item_name"></h3>
              </div>
            </a>
          </div>
          <% } %>
        </div>
      </div>
    </article>
  </main>
  <footer class="footer clearfix">
    <img src="http://localhost:9000/img/sugukuru.png" alt="" class="footer_logo" />
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
  <script src="./../../js/main.js"></script>
  <script src="./../../js/plugins.js"></script>
  <script src="./../../js/vendor.js"></script>
</body>

</html>
