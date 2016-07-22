package POJO;

import java.io.Serializable;

public class BuySellTransactionDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4897504132809373231L;
	private int buySellTransactionDetailID;
	private int buySellTransactionID;
	private String loaiGiaoDich;
	private String LoaiVang;
	private int giaVang;
	private float canNang;
	private int tienCong;
	private int tienBuVang;
	private int tongCong;
	public int getBuySellTransactionDetailID(){
		return buySellTransactionDetailID;
	}
	public void setBuySellTransactionDetailID(int buySellTransactionDetailID) {
		this.buySellTransactionDetailID = buySellTransactionDetailID;
	}
	public int getBuySellTransactionID() {
		return buySellTransactionID;
	}
	public void setBuySellTransactionID(int buySellTransactionID) {
		this.buySellTransactionID = buySellTransactionID;
	}
	public String getLoaiGiaoDich() {
		return loaiGiaoDich;
	}
	public void setLoaiGiaoDich(String loaiGiaoDich) {
		this.loaiGiaoDich = loaiGiaoDich;
	}
	public String getLoaiVang() {
		return LoaiVang;
	}
	public void setLoaiVang(String loaiVang) {
		LoaiVang = loaiVang;
	}
	public int getGiaVang() {
		return giaVang;
	}
	public void setGiaVang(int giaVang) {
		this.giaVang = giaVang;
	}
	public float getCanNang() {
		return canNang;
	}
	public void setCanNang(float canNang) {
		this.canNang = canNang;
	}
	public int getTienCong() {
		return tienCong;
	}
	public void setTienCong(int tienCong) {
		this.tienCong = tienCong;
	}
	public int getTienBuVang() {
		return tienBuVang;
	}
	public void setTienBuVang(int tienBuVang) {
		this.tienBuVang = tienBuVang;
	}
	public int getTongCong() {
		return tongCong;
	}
	public void setTongCong(int tongCong) {
		this.tongCong = tongCong;
	}

}
