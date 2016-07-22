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

import org.primefaces.context.RequestContext;

import POJO.BuySellTransactionDetail;
import POJO.LoaiVang;
import Utils.JDBC;

@ViewScoped
@ManagedBean
public class MuaBanTraoDoiBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1213456961603253376L;
	private List<BuySellTransactionDetail> buyList = new ArrayList<>();
	private List<BuySellTransactionDetail> sellList = new ArrayList<>();
	
	private List<LoaiVang> loaiVangs = new ArrayList<>();
	
	private BuySellTransactionDetail buyItem = new BuySellTransactionDetail();
	private BuySellTransactionDetail sellItem = new BuySellTransactionDetail();
	
	private int total;
	
	public MuaBanTraoDoiBean() {
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
	
	public void resetBuyDialog() {
		RequestContext.getCurrentInstance().reset(":form:buyDialogPanel");
	}
	public void saveBuyDialog() {
		buyList.add(buyItem);
		// Cal total
		int giaMua = loaiVangs.stream().filter(loaiVang -> loaiVang.getLoaiVang().equals(buyItem.getLoaiVang())).findFirst().get().getGiaMua();
		buyItem.setTongCong((int)((giaMua - buyItem.getTienBuVang()) * buyItem.getCanNang()));
		buyItem = new BuySellTransactionDetail();
		
		resetBuyDialog();
		calTotal();
	}
	public void buyDelete( BuySellTransactionDetail buyItem) {
		buyList.remove(buyItem);
		calTotal();
	}
	
	public void resetSellDialog() {
		RequestContext.getCurrentInstance().reset(":form:sellDialogPanel");
	}
	public void saveSellDialog() {
		sellList.add(sellItem);
		// Cal total
		int giaBan = loaiVangs.stream().filter(loaiVang -> loaiVang.getLoaiVang().equals(sellItem.getLoaiVang())).findFirst().get().getGiaBan();
		sellItem.setTongCong((int)(giaBan * sellItem.getCanNang()) - sellItem.getTienCong());
		sellItem = new BuySellTransactionDetail();
		
		resetSellDialog();
		calTotal();
	}
	public void sellDelete( BuySellTransactionDetail sellItem) {
		sellList.remove(sellItem);
		calTotal();
	}
	
	public void calTotal() {
		int buyTotal = buyList.stream().mapToInt(e -> e.getTongCong()).sum();
		int sellTotal = sellList.stream().mapToInt(e -> e.getTongCong()).sum();
		total = sellTotal - buyTotal;
	}

	public List<BuySellTransactionDetail> getBuyList() {
		return buyList;
	}

	public void setBuyList(List<BuySellTransactionDetail> buyList) {
		this.buyList = buyList;
	}

	public List<BuySellTransactionDetail> getSellList() {
		return sellList;
	}

	public void setSellList(List<BuySellTransactionDetail> sellList) {
		this.sellList = sellList;
	}

	public BuySellTransactionDetail getBuyItem() {
		return buyItem;
	}

	public void setBuyItem(BuySellTransactionDetail buyItem) {
		this.buyItem = buyItem;
	}

	public BuySellTransactionDetail getSellItem() {
		return sellItem;
	}

	public void setSellItem(BuySellTransactionDetail sellItem) {
		this.sellItem = sellItem;
	}

	public List<LoaiVang> getLoaiVangs() {
		return loaiVangs;
	}

	public void setLoaiVangs(List<LoaiVang> loaiVangs) {
		this.loaiVangs = loaiVangs;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
