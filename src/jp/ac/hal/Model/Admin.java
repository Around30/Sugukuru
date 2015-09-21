package jp.ac.hal.Model;

//管理者
public class Admin {

	private int administratorId;		//管理者ID
	private String administratorName;	//管理者名
	private boolean flg;				//与信限度額設定フラグ
	private String passwd;				//パスワード

	public int getAdministratorId() {
		return administratorId;
	}
	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}
	public String getAdministratorName() {
		return administratorName;
	}
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
	public boolean isFlg() {
		return flg;
	}
	public void setFlg(boolean flg) {
		this.flg = flg;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
