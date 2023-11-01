package com.jdc.mkt.service.impl;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.service.CategoryService;
import static com.jdc.mkt.utils.MysqlConnection.getConnection;

import java.sql.Statement;;

public class CategoryServiceImpl implements CategoryService{


	@Override
	public int insert(Category category) {
		String sql = "insert into category_tbl (name) values (?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, category.getName());
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
	public int update(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category[] select(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
