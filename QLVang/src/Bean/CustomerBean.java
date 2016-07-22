package Bean;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import POJO.Customer;

@RequestScoped
@ManagedBean
public class CustomerBean {
	
	private Customer selectedCustomer;
	private String customerName;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}
	
	private Connection con;
	private PreparedStatement stmt;
	
	public CustomerBean() {
		// TODO Auto-generated constructor stub
		String connectionString = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=Cam_Do_Database;integratedSecurity=true;";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionString);
			
			stmt = con.prepareStatement("SELECT * FROM Customers WHERE Ten LIKE ?");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Customer> completeCustomer(String query) {
		List<Customer> customers = new ArrayList<>();
		
		
			ResultSet rs;
			try {
				stmt.setNString(1, query + "%");
				rs = stmt.executeQuery();
			
				while( rs.next()) {
					Customer nC = new Customer();
					nC.setTen(rs.getNString("Ten"));
					customers.add(nC);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return customers;
	}
}
