package com.hwang.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hwang.common.db.DBManager;
import com.hwang.employee.dto.NoticeDto;

public class NoticeDao {
	private NoticeDao() {

	}
	
	private static NoticeDao instance = new NoticeDao();
	
	public static NoticeDao getInstance(){
		if(instance == null){
			instance = new NoticeDao();
		}
		return instance;
	}
	
	public List<NoticeDto> selectAllNotice(){
		String sql = "select * from notice order by noticenum desc";
		
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				NoticeDto nDto = new NoticeDto();
				
				nDto.setNoticenum(rs.getString("noticenum"));
				nDto.setEmpid(rs.getString("empid"));
				nDto.setContent(rs.getString("content"));
				nDto.setTitle(rs.getString("title"));
				nDto.setWritedate(rs.getString("writedate"));
				nDto.setHit(rs.getString("hits"));
				
				list.add(nDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public int insertNotice(NoticeDto nDto){
		String sql = "Insert into notice(noticenum, empid, content, title)"
				+ "values(seq_noticenum.nextval, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nDto.getEmpid());
			pstmt.setString(2, nDto.getContent());
			pstmt.setString(3, nDto.getTitle());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public int updateHit(String noticenum){
		String sql = "update notice set hits=hits+1 where noticenum=?";
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticenum);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public NoticeDto selectOneNoticeByNoticeNum(String noticenum){
		String sql = "select * from notice where noticenum=?";
		
		NoticeDto nDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticenum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				nDto = new NoticeDto();
				
				nDto.setNoticenum(rs.getString("noticenum"));
				nDto.setEmpid(rs.getString("empid"));
				nDto.setTitle(rs.getString("title"));
				nDto.setContent(rs.getString("content"));
				nDto.setHit(rs.getString("hits"));
				nDto.setWritedate(rs.getString("writedate"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return nDto;
	}
	
	public int NoticeUpdate(NoticeDto nDto){
		String sql = "update notice set content=?, title=? where noticenum= ? ";
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nDto.getContent());
			pstmt.setString(2, nDto.getTitle());
			pstmt.setString(3, nDto.getNoticenum());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public int NoticeDelete(String noticenum){
		String sql = "delete from notice where noticenum=?";
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, noticenum);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public List<NoticeDto> selectNoticePage(int curPage, int numPerPage){
		StringBuilder sql = new StringBuilder();
		sql.append("select *										");
		sql.append("  from (select rownum r, a.*					");
		sql.append("		  from (select *						");
		sql.append("				  from notice					");
		sql.append("				 order by NOTICENUM desc) a)	");
		sql.append(" where r										");
		sql.append("between ? and ?									");
		
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			if(curPage == 0){
				curPage = 1;
			}
			int start = (curPage -1) * numPerPage +1;
			int end = start + numPerPage -1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				NoticeDto nDto = new NoticeDto();
				
				nDto.setContent(rs.getString("content"));
				nDto.setEmpid(rs.getString("empid"));
				nDto.setHit(rs.getString("hits"));
				nDto.setNoticenum(rs.getString("noticenum"));
				nDto.setTitle(rs.getString("title"));
				nDto.setWritedate(rs.getString("writedate"));
				
				list.add(nDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
