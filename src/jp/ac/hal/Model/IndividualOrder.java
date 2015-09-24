package jp.ac.hal.Model;

//個人注文クラス
public class IndividualOrder extends Order {
	private String name;		//氏名
	private String phonetic;	//フリガナ
	private String postalCode;		//郵便番号
	private String address;		//住所
	private String phoneNumber;	//電話番号
	private int mailAddress;	//メールアドレス


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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(int mailAddress) {
		this.mailAddress = mailAddress;
	}


}
