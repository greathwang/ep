package com.hwang.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hwang.common.db.DBManager;
import com.hwang.employee.dto.ReplyDto;

public class ReplyDao {
	private ReplyDao(){
		
	}
	
	private static ReplyDao instance = new ReplyDao();
	
	public static ReplyDao getInstance(){
		if(instance == null){
			instance = new ReplyDao();
		}
		return instance;
	}
	
	public List<ReplyDto> selectAllReply(String noticenum){
		StringBuilder sql = new StringBuilder();
		sql.append("select r.replyno 		");
		sql.append("	 , r.noticenum		");
		sql.append("	 , r.content		");
		sql.append("	 , r.writedate		");
		sql.append("	 , e.first_name		");
		sql.append("	 , e.last_name		");
		sql.append("  from reply r			");
		sql.append("	 , notice n			");
		sql.append("	 , employee e		");
		sql.append(" where n.noticenum = ?	");
		sql.append("order by r.replyno		");
		
		List<ReplyDto> list = new ArrayList<ReplyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, noticenum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ReplyDto rDto = new ReplyDto();
				
				rDto.setReplyno(rs.getString("replyno"));
				rDto.setContent(rs.getString("content"));
				rDto.setWritedate(rs.getString("writedate"));
				rDto.setEmpnum(rs.getString("first_name")+rs.getString("last_name"));
				rDto.setNoticenum(rs.getString("noticenum"));
				
				list.add(rDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public List<ReplyDto> insertReply(ReplyDto rDto){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into reply				");
		sql.append("		(replyno				");
		sql.append("	,	noticenum				");
		sql.append("	,	empnum					");
		sql.append("	,	content					");
		sql.append("		)						");
		sql.append("values(							");
		sql.append("		seq_replyno.nextval		");
		sql.append("	,	?						");
		sql.append("	,	?						");
		sql.append("	,	?						");
		sql.append("	)	");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, rDto.getNoticenum());
			pstmt.setString(2, rDto.getEmpnum());
			pstmt.setString(3, rDto.getContent());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return selectAllReply(rDto.getNoticenum());
	}
	
	@SuppressWarnings("resource")
	public ReplyDto lastInsert(){
		ReplyDto rDto 	= new ReplyDto();
		Connection conn 			= null;
		PreparedStatement pstmt	 	= null;
		ResultSet rs				= null;
		int lastSeq					= 0;
		
		StringBuilder lastsql = new StringBuilder();
		lastsql.append("select seq_replyno.currval as lastseq from dual");
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from reply where replyno=?");
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(lastsql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()){
				lastSeq = rs.getInt("lastseq");
			}
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, lastSeq);
			rs		=  pstmt.executeQuery();
			if(rs.next()){
				rDto.setContent(rs.getString("content"));
				rDto.setWritedate(rs.getString("writedate"));
				rDto.setReplyno(rs.getString("replyno"));
				rDto.setNoticenum(rs.getString("NOTICENUM"));
				rDto.setEmpnum(rs.getString("empnum"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return rDto;
	}
}
