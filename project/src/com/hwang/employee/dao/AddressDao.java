package com.hwang.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hwang.common.db.DBManager;
import com.hwang.employee.dto.AddressDto;

public class AddressDao {
	private AddressDao(){
		
	}
	
	private static AddressDao instance = new AddressDao();
	
	public static AddressDao getInstance(){
		if(instance == null){
			instance = new AddressDao();
		}
		return instance;
	}
	
	public List<AddressDto> selectAllAddress(String dong){
		StringBuilder sql = new StringBuilder();
		sql.append("select addrno					");
		sql.append("	 , emp_zip(zipcode)			");
		sql.append("	 , sido						");
		sql.append("	 , sigugun					");
		sql.append("	 , dong						");
		sql.append("	 , nvl(ri, ' ') as ri		");
		sql.append("	 , nvl(bldg, ' ') as bldg	");
		sql.append("	 , nvl(bungi, ' ') as bungi	");
		sql.append("  from addr						");
		sql.append(" where dong like '%'||?||'%'	");
		
//		String sql = "select addrno, emp_zip(zipcode),"
//				+ "sido, sigugun, dong, NVL(ri,' ') as ri, NVL(bldg,' ') as bldg,"
//				+ " NVL(bungi,' ') as bungi from addr where dong like '%'||?||'%'";
		
		List<AddressDto> list = new ArrayList<AddressDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, dong);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				AddressDto aDto = new AddressDto();
				
				aDto.setAddrno(rs.getString("addrno"));
				aDto.setBldg(rs.getString("bldg"));
				aDto.setBungi(rs.getString("bungi"));
				aDto.setDong(rs.getString("dong"));
				aDto.setRi(rs.getString("ri"));
				aDto.setSido(rs.getString("sido"));
				aDto.setSigugun(rs.getString("sigugun"));
				aDto.setZipcode(rs.getString("emp_zip(zipcode)"));
				
				list.add(aDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
