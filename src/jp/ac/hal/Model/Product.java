package jp.ac.hal.Model;

//商品クラス
public class Product {
	private int productId;		//商品ID
	private String productName;	//商品名
	private String productPhonetic;
	private int price;			//値段
	private int makerId;		//メーカーID
	private String makerName;
	private int productGenreId;	//商品ジャンルID
	private String productGenreName;
	private int countryId;
	private int productX;
	private int productY;
	private int productZ;
	private int productWeight;
	private String productDetail;
	private int janCode;

	public Product(
			int productId,
			String productName,
			String productPhonetic,
			int price,
			String makerName,
			String productGenreName,
			int countryId,
			int productX,
			int productY,
			int productZ,
			int productWeight,
			String productDetail,
			int janCode)
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPhonetic = productPhonetic;
		this.price = price;
		this.makerName = makerName;
 		this.productGenreName = productGenreName;
		this.countryId = countryId;
		this.productX = productX;
		this.productY = productY;
		this.productZ = productZ;
		this.productWeight = productWeight;
		this.productDetail = productDetail;
		this.janCode = janCode;
	}

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
	public String getMakerName() {
		return makerName;
	}
	public void setMakerName(String makerName) {
		this.makerName = makerName;
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
