package POJO;

import java.io.Serializable;
import java.sql.Date;

public class BuySellTransaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6433159743697036200L;
	private int buySellTransactionID;
	private int customerSTT;
	private int employeeSTT;
	private Date date;
	private int tongCong;
	public int getBuySellTransactionID() {
		return buySellTransactionID;
	}
	public void setBuySellTransactionID(int buySellTransactionID) {
		this.buySellTransactionID = buySellTransactionID;
	}
	public int getCustomerSTT() {
		return customerSTT;
	}
	public void setCustomerSTT(int customerSTT) {
		this.customerSTT = customerSTT;
	}
	public int getEmployeeSTT() {
		return employeeSTT;
	}
	public void setEmployeeSTT(int employeeSTT) {
		this.employeeSTT = employeeSTT;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTongCong() {
		return tongCong;
	}
	public void setTongCong(int tongCong) {
		this.tongCong = tongCong;
	}
	
}
