package com.jdc.mkt.service.impl;

import static com.jdc.mkt.utils.MysqlConnection.getConnection;

import java.sql.Statement;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public int insert(Product product) {
		String sql = "insert into product_tbl (name,price,size,category_id) values (?,?,?,?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, product.getName());
			stmt.setDouble(2, product.getPrice());
			stmt.setString(3,product.getSize().name());
			stmt.setInt(4, product.getCatgory().getId());
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
	public int update(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product[] select(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
