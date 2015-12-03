package jp.ac.hal.Model;

import java.util.Date;

public class CorporationOrder extends Order
{
	private String corporationAccountId;
	private Date estimateRequestDate;
	private Date estimateDate;

	public String getCorporationAccountId() {
		return corporationAccountId;
	}
	public void setCorporationAccountId(String corporationAccountId) {
		this.corporationAccountId = corporationAccountId;
	}
	public Date getEstimateRequestDate() {
		return estimateRequestDate;
	}
	public void setEstimateRequestDate(Date estimateRequestDate) {
		this.estimateRequestDate = estimateRequestDate;
	}
	public Date getEstimateDate() {
		return estimateDate;
	}
	public void setEstimateDate(Date estimateDate) {
		this.estimateDate = estimateDate;
	}
}