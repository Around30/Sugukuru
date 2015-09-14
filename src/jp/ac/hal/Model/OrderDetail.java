package jp.ac.hal.Model;

//注文詳細クラス
public class OrderDetail {
	private int productId;	//商品ID
	private int orderId;	//注文ID
	private int numberOf;	//個数
	private int subTotal;	//小計


	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getNumberOf() {
		return numberOf;
	}
	public void setNumberOf(int numberOf) {
		this.numberOf = numberOf;
	}
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}


}
