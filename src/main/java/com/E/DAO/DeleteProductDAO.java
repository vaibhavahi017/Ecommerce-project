package com.E.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO {
	
	public int deleteProduct(String pcode) {
		
		int rowCount=0;
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement pstmt =con.prepareStatement("delete from product where pcode=?");
			pstmt.setString(1, pcode);
			rowCount =pstmt.executeUpdate();
			
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return rowCount;
		
	}
	
}
