package POJO;

import java.io.Serializable;

public class LoaiVang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6199425973467853940L;
	
	private int stt;
	private String loaiVang;
	private int giaMua;
	private int giaBan;
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getLoaiVang() {
		return loaiVang;
	}
	public void setLoaiVang(String loaiVang) {
		this.loaiVang = loaiVang;
	}
	public int getGiaMua() {
		return giaMua;
	}
	public void setGiaMua(int giaMua) {
		this.giaMua = giaMua;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}

	@Override
	public String toString() {
		return loaiVang;
	}
}
