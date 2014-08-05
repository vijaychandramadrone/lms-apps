package com.madrone.lms.form;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplyLeaveFormGrid {
	
	@JsonProperty("Type")
	private String type;
	 
	@JsonProperty("Total")
	private float total;
	
	@JsonProperty("Consumed")
	private float consumed;
	
	@JsonProperty("Balance")
	private float balance;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getConsumed() {
		return consumed;
	}
	public void setConsumed(float consumed) {
		this.consumed = consumed;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "ApplyLeaveFormGrid [type=" + type + ", total=" + total
				+ ", consumed=" + consumed + ", balance=" + balance + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + Float.floatToIntBits(consumed);
		result = prime * result + Float.floatToIntBits(total);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	
}
