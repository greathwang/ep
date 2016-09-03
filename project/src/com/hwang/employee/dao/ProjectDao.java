package com.hwang.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hwang.common.db.DBManager;
import com.hwang.employee.dto.ProjectDto;

public class ProjectDao {
	private ProjectDao(){
		
	}
	
	private static ProjectDao instance = new ProjectDao();
	
	public static ProjectDao getInstance(){
		if(instance == null){
			instance = new ProjectDao();
		}
		return instance;
	}
	
	public List<ProjectDto> selectAllprojects(){
		String sql = "select * from pjt order by pjtcd";
		
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				ProjectDto pDto = new ProjectDto();
				
				pDto.setPjtcd(rs.getString("pjtcd"));
				pDto.setPjt(rs.getString("pjt"));
				pDto.setPjtdtl(rs.getString("pjtdtl"));
				pDto.setStartdt(rs.getString("startdt"));
				pDto.setEnddt(rs.getString("enddt"));
				pDto.setRegdt(rs.getString("regdt"));
				pDto.setReguser(rs.getString("reguser"));
				
				list.add(pDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public ProjectDto selectOneProjectBypjtcd(String pjtcd){
		String sql = "select * from pjt where pjtcd = ?";
		
		ProjectDto pDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pjtcd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				pDto = new ProjectDto();
				
				pDto.setPjtcd(rs.getString("pjtcd"));
				pDto.setPjt(rs.getString("pjt"));
				pDto.setPjtdtl(rs.getString("pjtdtl"));
				pDto.setStartdt(rs.getString("startdt"));
				pDto.setEnddt(rs.getString("enddt"));
				pDto.setRegdt(rs.getString("regdt"));
				pDto.setReguser(rs.getString("reguser"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return pDto;
	}
	
	public int projectInsert(ProjectDto pDto){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
	}
}
