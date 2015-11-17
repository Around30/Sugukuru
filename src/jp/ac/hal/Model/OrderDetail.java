package jp.ac.hal.Model;

//注文詳細クラス
public class OrderDetail {
	private Integer productId;	//商品ID
	private Integer orderId;	//注文ID
	private Integer numberOf;	//個数
	private Integer subTotal;	//小計

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getNumberOf() {
		return numberOf;
	}
	public void setNumberOf(Integer numberOf) {
		this.numberOf = numberOf;
	}
	public Integer getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}
}
