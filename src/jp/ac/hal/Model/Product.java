package jp.ac.hal.Model;

//商品クラス
public class Product {
	private int productId;		//商品ID
	private String productName;	//商品名
	private String productPhonetic;
	private int price;			//値段
	private int makerId;		//メーカーID
	private int productGenreId;	//商品ジャンルID
	private int countryId;
	private int productX;
	private int productY;
	private int productZ;
	private int productWeight;
	private String productDetail;
	private int janCode;
	
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
	public String getProductPhonetic() {
		return productPhonetic;
	}
	public void setProductPhonetic(String productPhonetic) {
		this.productPhonetic = productPhonetic;
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
	public int getProductGenreId() {
		return productGenreId;
	}
	public void setProductGenreId(int productGenreId) {
		this.productGenreId = productGenreId;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getProductX() {
		return productX;
	}
	public void setProductX(int productX) {
		this.productX = productX;
	}
	public int getProductY() {
		return productY;
	}
	public void setProductY(int productY) {
		this.productY = productY;
	}
	public int getProductZ() {
		return productZ;
	}
	public void setProductZ(int productZ) {
		this.productZ = productZ;
	}
	public int getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public int getJanCode() {
		return janCode;
	}
	public void setJanCode(int janCode) {
		this.janCode = janCode;
	}
}