package com.jdc.mkt.service.impl;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.service.CustomerService;
import static com.jdc.mkt.utils.MysqlConnection.getConnection;

import java.sql.Statement;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public int insertCustomer(Customer cu) {
		String sql = "insert into customer_tbl (name,address_id) values (?,?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, cu.getName());
			stmt.setInt(2, insertAddress(cu.getAddress()));
			
			stmt.executeUpdate();
			var rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertAddress(Address a) {
		String sql = "insert into address_tbl (street,township,city) values (?,?,?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1,a.getStreet());
			stmt.setString(2, a.getTownship());
			stmt.setString(3, a.getCity());
			
			stmt.executeUpdate();
			var rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	@Override
	public int updateCustomer(Customer cu) {
		return 0;
	}

	@Override
	public Customer[] getCustomers(Customer cu) {
		return null;
	}

	@Override
	public void clearCustomer() {
	}

}
