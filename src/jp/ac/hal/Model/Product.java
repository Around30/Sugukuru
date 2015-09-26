package jp.ac.hal.Model;

//商品クラス
public class Product {
	private int productId;		//商品ID
	private String productName;	//商品名
	private int productGenreId;	//商品ジャンルID
	private int price;			//値段
	private int makerId;		//メーカーID

	public Product(
			int productId,
			String productName,
			int productGenreId,
			int price,
			int makerId)
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.productGenreId = productGenreId;
		this.price = price;
		this.makerId = makerId;
	}

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
}
