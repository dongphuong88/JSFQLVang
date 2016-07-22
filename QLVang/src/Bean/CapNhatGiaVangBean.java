package Bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import POJO.LoaiVang;
import Utils.JDBC;

@ViewScoped
@ManagedBean
public class CapNhatGiaVangBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8340117377907529021L;

	private List<LoaiVang> loaiVangs = new ArrayList<>();
	
	public CapNhatGiaVangBean() {
		// get all loaiVangs
		Connection con = JDBC.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LoaiVangs");
			while( rs.next()) {
				LoaiVang lv = new LoaiVang();
				lv.setStt(rs.getInt("STT"));
				lv.setLoaiVang(rs.getString("LoaiVang"));
				lv.setGiaBan(rs.getInt("GiaBan"));
				lv.setGiaMua(rs.getInt("GiaMua"));
				loaiVangs.add(lv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<LoaiVang> getLoaiVangs() {
		return loaiVangs;
	}

	public void setLoaiVangs(List<LoaiVang> loaiVangs) {
		this.loaiVangs = loaiVangs;
	}
}
