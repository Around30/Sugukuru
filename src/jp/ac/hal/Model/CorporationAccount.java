package jp.ac.hal.Model;

public class CorporationAccount
{
	private int corporationAccountId;
	private String corporationAccountName;
	private int corporationId;
	
	public int getCorporationAccountId() {
		return corporationAccountId;
	}
	public void setCorporationAccountId(int corporationAccountId) {
		this.corporationAccountId = corporationAccountId;
	}
	public String getCorporationAccountName() {
		return corporationAccountName;
	}
	public void setCorporationAccountName(String corporationAccountName) {
		this.corporationAccountName = corporationAccountName;
	}
	public int getCorporationId() {
		return corporationId;
	}
	public void setCorporationId(int corporationId) {
		this.corporationId = corporationId;
	}
}