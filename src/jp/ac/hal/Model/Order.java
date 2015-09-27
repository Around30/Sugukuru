package jp.ac.hal.Model;

import java.sql.Date;

//注文クラス
public class Order {
	private int orderId;	//注文ID
	private int total;		//総額
	private Date orderDate;	//注文日
	private boolean cart;	//カート状態かどうか


	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public boolean isCart() {
		return cart;
	}
	public void setCart(boolean cart) {
		this.cart = cart;
	}


}
