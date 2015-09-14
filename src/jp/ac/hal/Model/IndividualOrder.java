package jp.ac.hal.Model;

//個人注文クラス
public class IndividualOrder {
	private int orderId;		//注文ID
	private String name;		//氏名
	private String phonetic;	//フリガナ
	private int postalCode;		//郵便番号
	private String address;		//住所
	private int phoneNumber;	//電話番号
	private int mailAddress;	//メールアドレス


	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonetic() {
		return phonetic;
	}
	public void setPhonetic(String phonetic) {
		this.phonetic = phonetic;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(int mailAddress) {
		this.mailAddress = mailAddress;
	}


}
