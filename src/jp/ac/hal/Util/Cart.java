package jp.ac.hal.Util;

public class Cart {

//	@SuppressWarnings("unchecked")
//	public List<String> cartAdd(HttpSession session, String[] cart, List<String>[] cartList){
//
//		// カートセッションがnullだった場合
//		if (session.getAttribute("cartSession") == null) {
//			cartList.length;
//			// カートセッション生成
//			session.setAttribute("cartSession", cartList);
//
//		} else { // カートセッションが既に存在する場合
//			// カートセッションの要素を配列に格納
//			List<String[]> temp = (List<String[]>) session.getAttribute("cartSession");
////			// ArrayList<Object>の宣言
////			ArrayList<Object> toCartList = new ArrayList<Object>();
//			// カートに追加された要素がカートセッションに存在するかチェック
//			// 重複しない場合カートリストにカートセッションの値を格納
//			for (int i = 0; i < temp.size(); i++) {
//				if (!Arrays.asList(cart).contains(temp[i])) {
//					toCartList.add(temp[i]);
//				}
//			}
//			// 追加されたカートの中身をカートリストに格納
//			for (int i = 0; i < cart.length; i++) {
//				toCartList.add(cart[i]);
//			}
//			// ArrayListからString[]へキャスト
//			cartList = (String[]) toCartList.toArray(new String[0]);
//			// カートセッション生成
//			session.setAttribute("cartSession", cartList);
//		}
//	} else { // カートへの追加がない時の処理
//		cartList = (String[]) session.getAttribute("cartSession");
//		//カートリストの取り消し処理
//			if (delCart != null) {
//				// ArrayList<Object>の宣言
//				ArrayList<Object> toCartList = new ArrayList<Object>();
//				// 配列をArrayListへ変換
//				for (int i = 0 ; i < cartList.length ; i++) {
//					toCartList.add(cartList[i]);
//				}
//				//要素の削除
//				toCartList.remove(toCartList.indexOf(delCart));
//				// ArrayListからString[]へキャスト
//				cartList = (String[]) toCartList.toArray(new String[0]);
//				// カートセッション生成
//				session.setAttribute("cartSession", cartList);
//			} //end if
//		}
	}
