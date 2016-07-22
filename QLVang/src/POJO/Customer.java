package POJO;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2557364384082918949L;
	private int STT;
	private String Ten;
	private String CMND;
	private String CMNDNgayCap;
	private String CMNDNoiCap;
	private String DiaChi;
	private String DienThoai;
	public int getSTT() {
		return STT;
	}
	public void setSTT(int sTT) {
		STT = sTT;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getCMNDNgayCap() {
		return CMNDNgayCap;
	}
	public void setCMNDNgayCap(String cMNDNgayCap) {
		CMNDNgayCap = cMNDNgayCap;
	}
	public String getCMNDNoiCap() {
		return CMNDNoiCap;
	}
	public void setCMNDNoiCap(String cMNDNoiCap) {
		CMNDNoiCap = cMNDNoiCap;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getDienThoai() {
		return DienThoai;
	}
	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Ten;
	}
	
}
