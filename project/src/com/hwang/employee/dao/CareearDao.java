package com.hwang.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hwang.common.db.DBManager;
import com.hwang.employee.dto.CareearDto;

public class CareearDao {
	private CareearDao(){
	
	};
	
	private static CareearDao instance = new CareearDao();
	
	public static CareearDao getInstance(){
		if(instance == null){
			instance = new CareearDao();
		}
		return instance;
	}
	
	public int insertCareear(CareearDto cDto){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into careear					");
		sql.append("	values(?						");
		sql.append("		 , careearnum_seq.nextval	");
		sql.append("		 , ?						");
		sql.append("		 , ?						");
		sql.append("		 , ?						");
		sql.append("		 , ?						");
		sql.append("		 , ?						");
		sql.append("		)							");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try{
			conn = DBManager.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, cDto.getEmpnum());
			pstmt.setString(2, cDto.getCompany());
			pstmt.setString(3, cDto.getDeptnum());
			pstmt.setString(4, cDto.getPnum());
			pstmt.setString(5, cDto.getStartdt());
			pstmt.setString(6, cDto.getEnddt());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public List<CareearDto> selectCareearList(String empnum){
		StringBuilder sql = new StringBuilder();
		sql.append("select c.empnum					");
		sql.append("	 , c.num					");
		sql.append("	 , c.company				");
		sql.append("	 , c.startdt				");
		sql.append("	 , c.enddt					");
		sql.append("	 , d.deptname				");
		sql.append("	 , p.pname					");
		sql.append("  from careear c				");
		sql.append("  join employee e				");
		sql.append("	on c.empnum = e.empnum		");
		sql.append("  join dept d					");
		sql.append("	on c.deptnum = d.deptnum	");
		sql.append("  join position p				");
		sql.append("	on c.pnum = p.pnum			");
		sql.append(" where c.empnum = ?				");
		
		List<CareearDto> list = new ArrayList<CareearDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, empnum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CareearDto cDto = new CareearDto();
				
				cDto.setCompany(rs.getString("company"));
				cDto.setDeptnum(rs.getString("deptname"));
				cDto.setEmpnum(rs.getString("empnum"));
				cDto.setEnddt(rs.getString("enddt"));
				cDto.setNum(rs.getString("num"));
				cDto.setPnum(rs.getString("pname"));
				cDto.setStartdt(rs.getString("startdt"));
				
				list.add(cDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
