package jp.ac.hal.Model;

import java.util.Date;

public class CorporationOrder extends Order
{
	private String corporationAccountId;
	private boolean confirmed;
	private Date estimateDate;

	public String getCorporationAccountId() {
		return corporationAccountId;
	}
	public void setCorporationAccountId(String corporationAccountId) {
		this.corporationAccountId = corporationAccountId;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	public Date getEstimateDate() {
		return estimateDate;
	}
	public void setEstimateDate(Date estimateDate) {
		this.estimateDate = estimateDate;
	}
}