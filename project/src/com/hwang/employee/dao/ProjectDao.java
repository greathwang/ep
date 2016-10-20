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
		StringBuilder sql = new StringBuilder();
		sql.append("insert into pjt										   ");
		sql.append("	(pjtcd, pjt, pjtdtl, startdt, enddt, reguser)	   ");
		sql.append("values(												   ");
		sql.append("	pjtcd_seq.nextval								   ");
		sql.append("  , ?												   ");
		sql.append("  , ?												   ");
		sql.append("  , ?												   ");
		sql.append("  , ?												   ");
		sql.append("  , ?												   ");
		sql.append("	)												   ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, pDto.getPjt());
			pstmt.setString(2, pDto.getPjtdtl());
			pstmt.setString(3, pDto.getStartdt());
			pstmt.setString(4, pDto.getEnddt());
			pstmt.setString(5, pDto.getReguser());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public int projectMgInsert(ProjectDto pDto){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into pjt_mg				");
		sql.append("	values(						");
		sql.append("			  pjtcd_seq.currval	");
		sql.append("			, ?					");
		sql.append("			, ?					");
		sql.append("		)						");
			
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, pDto.getReguser());
			pstmt.setString(2, pDto.getPerrolecd());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public int projectSkillInsert(ProjectDto pDto){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into p_skill			");
		sql.append("		values(pjtcd_seq	");
		sql.append("			 , ?			");
		sql.append("			)				");
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, pDto.getSkill());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public List<ProjectDto> selectProjectPage(int curPage, int numPerPage){
		StringBuilder sql = new StringBuilder();
		sql.append("select * 									");
		sql.append("  from (select rownum R, A.*				");
		sql.append("		  from (select *					");
		sql.append("				  from pjt					");
		sql.append("				 order by pjtcd desc) a)	");
		sql.append(" where r									");
		sql.append("between ? and ?								");
		
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			if(curPage == 0){
				curPage = 1;
			}
			int start = (curPage - 1)* numPerPage + 1;
			int end = start + numPerPage - 1;

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ProjectDto proDto = new ProjectDto();
				
				proDto.setPjtcd(rs.getString("pjtcd"));
				proDto.setPjt(rs.getString("pjt"));
				proDto.setPjtdtl(rs.getString("pjtdtl"));
				proDto.setStartdt(rs.getString("startdt"));
				proDto.setEnddt(rs.getString("enddt"));
				proDto.setRegdt(rs.getString("regdt"));
				proDto.setReguser(rs.getString("reguser"));
				
				list.add(proDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
}