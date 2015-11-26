package jp.ac.hal.Model;

import java.math.BigDecimal;

public class Admin {

	private int administratorId;
	private String administratorName;
	private boolean flg;
	private String passwd;

	public Admin(Object[] o) {
		this.administratorId = ((BigDecimal)o[0]).intValue();
		this.administratorName = (String)o[1];
		BigDecimal b = (BigDecimal)o[2];
		this.flg = b != null && b.intValue() == 1;
	}

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
