package jp.ac.hal.Model;

//商品クラス
public class Product {
	private int productId;				//商品ID
	private String productName;			//商品名
	private int productGenreId;			//商品ジャンルID
	private String productGenreName;	//商品ジャンル名
	private int price;					//値段
	private int makerId;				//メーカーID
	private String markerName;			//メーカー名


	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductGenreId() {
		return productGenreId;
	}
	public void setProductGenreId(int productGenreId) {
		this.productGenreId = productGenreId;
	}
	public String getProductGenreName() {
		return productGenreName;
	}
	public void setProductGenreName(String productGenreName) {
		this.productGenreName = productGenreName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMakerId() {
		return makerId;
	}
	public void setMakerId(int makerId) {
		this.makerId = makerId;
	}

	public String getMarkerName() {
		return markerName;
	}
	public void setMarkerName(String markerName) {
		this.markerName = markerName;
	}



}
