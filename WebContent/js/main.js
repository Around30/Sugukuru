// カートのマイナスボタン
var minusBtn = $(".js-cartMinusBtn");

// カートのプラスボタン
var plusBtn = $(".js-cartPlusBtn");

// カートに入れる個数を表示するテキストボックス
var cartNumText = $(".js-cartNumText");

/**
 * マイナスボタンを押された時
 */
minusBtn.click(function() {
	// 今入力されているカウントを取得
	var num = parseInt(cartNumText.val());
	
	// アイテムの個数が1個以上だった場合処理を行う
	if(1 < num) {
		num--;
		cartNumText.val(num);
	}
});

/**
 * プラスボタンを押された時
 */
plusBtn.click(function() {
	// 新しいカウント
	var num = parseInt(cartNumText.val()) + 1;
	
	cartNumText.val(num);
});