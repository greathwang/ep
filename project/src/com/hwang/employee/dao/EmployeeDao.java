package com.hwang.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hwang.common.db.DBManager;
import com.hwang.employee.dto.EmployeeDto;

public class EmployeeDao {
	private EmployeeDao(){

	}
	
	private static EmployeeDao instance = new EmployeeDao();
	
	public static EmployeeDao getInstance(){
		if(instance == null){
			instance = new EmployeeDao();
		}
		return instance;
	}
	
	public List<EmployeeDto> selectAllEmployees(){
		String sql = "select * from employee order by empnum";
		
		List<EmployeeDto> list = new ArrayList<EmployeeDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				EmployeeDto eDto = new EmployeeDto();
				
				eDto.setEmpid(rs.getString("empid"));
				eDto.setPwd(rs.getString("pwd"));
				eDto.setEmpnum(rs.getString("empnum"));
				eDto.setFirst_name(rs.getString("first_name"));
				eDto.setLast_name(rs.getString("last_name"));
				eDto.setReginum(rs.getString("reginum"));
				eDto.setEmp_img(rs.getString("emp_img"));
				eDto.setEmp_img_org(rs.getString("emp_img_org"));
				eDto.setDeptnum(rs.getString("deptnum"));
				eDto.setPnum(rs.getString("pnum"));
				eDto.setZipcode(rs.getString("zipcode"));
				eDto.setAddress(rs.getString("address"));
				eDto.setDetailaddress(rs.getString("detailaddress"));
				eDto.setEmail(rs.getString("email"));
				eDto.setPhone(rs.getString("phone"));
				eDto.setSalary(rs.getInt("salary"));
				eDto.setHire_date(rs.getString("hire_date"));
				eDto.setOut_date(rs.getString("out_date"));
				eDto.setManager(rs.getInt("manager"));
				eDto.setRegidate(rs.getString("regidate"));
				
				list.add(eDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public int insertEmployee(EmployeeDto eDto){
		StringBuilder sql = new StringBuilder();
		 sql.append("Insert into employee (empid,pwd,empnum,first_name,last_name,reginum,emp_img,emp_img_org,deptnum,pnum,zipcode,address,detailaddress,email,phone,salary,manager)");
		 sql.append("values(");
		 sql.append("?");
		 sql.append(",?");
		 sql.append(",emp_seq");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?");
		 sql.append(",?)");		 
		int result=-1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, eDto.getEmpid());
			pstmt.setString(2, eDto.getPwd());
			pstmt.setString(3, eDto.getFirst_name());
			pstmt.setString(4, eDto.getLast_name());
			pstmt.setString(5, eDto.getReginum());
			pstmt.setString(6, eDto.getEmp_img());
			pstmt.setString(7, eDto.getEmp_img_org());
			pstmt.setString(8, eDto.getDeptnum());
			pstmt.setString(9, eDto.getPnum());
			pstmt.setString(10, eDto.getZipcode());
			pstmt.setString(11, eDto.getAddress());
			pstmt.setString(12, eDto.getDetailaddress());
			pstmt.setString(13, eDto.getEmail());
			pstmt.setString(14, eDto.getPhone());
			pstmt.setInt(15, eDto.getSalary());
			pstmt.setInt(16, eDto.getManager());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	
	public int userCheck(String empid, String pwd){
		int result = -1;
		String sql = "select pwd from employee where empid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String checkPwd=null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				checkPwd=rs.getString("pwd");
				if(checkPwd!=null && checkPwd.equals(pwd)){
					result = 1;
				}else{
					result = 0;
				}
			}else{
				result = -1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public EmployeeDto selectOneEmpoyeeByNum(String empnum){
		String sql = "SELECT empid"
					+	 " , pwd"
					+    " , empnum"
					+    " , first_name"
					+    " , last_name"
					+    " , EMP_REGI(reginum)"
					+    " , EMP_GENDER(reginum)"
					+    " , emp_birth(reginum)"
					+    " , emp_img"
					+    " , emp_img_org"
					+    " , EMP_DEPT(deptnum)"
					+    " , emp_posi(pnum)"
					+    " , emp_zip(zipcode)"
					+    " , address"
					+    " , detailaddress"
					+    " , email"
					+    " , phone"
					+    " , salary"
					+    " , hire_date"
					+    " , out_date"
					+    " , manager"
					+    " , regidate "
					+ "FROM EMPLOYEE "
					+ "WHERE empnum = ?"
				;
		
		EmployeeDto eDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empnum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				eDto = new EmployeeDto();
				
				eDto.setEmpid(rs.getString("empid"));
				eDto.setPwd(rs.getString("pwd"));
				eDto.setEmpnum(rs.getString("empnum"));
				eDto.setFirst_name(rs.getString("first_name"));
				eDto.setLast_name(rs.getString("last_name"));
				eDto.setReginum(rs.getString("EMP_REGI(reginum)"));
				eDto.setGender(rs.getString("EMP_GENDER(reginum)"));
				eDto.setBirth(rs.getString("emp_birth(reginum)"));
				eDto.setEmp_img(rs.getString("emp_img"));
				eDto.setEmp_img_org(rs.getString("emp_img_org"));
				eDto.setDeptnum(rs.getString("EMP_DEPT(deptnum)"));
				eDto.setPnum(rs.getString("emp_posi(pnum)"));
				eDto.setZipcode(rs.getString("emp_zip(zipcode)"));
				eDto.setAddress(rs.getString("address"));
				eDto.setDetailaddress(rs.getString("detailaddress"));
				eDto.setEmail(rs.getString("email"));
				eDto.setPhone(rs.getString("phone"));
				eDto.setSalary(rs.getInt("salary"));
				eDto.setHire_date(rs.getString("hire_date"));
				eDto.setOut_date(rs.getString("out_date"));
				eDto.setManager(rs.getInt("manager"));
				eDto.setRegidate(rs.getString("regidate"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return eDto;
	}
	
	public EmployeeDto sessionEmp(String empid){
		String sql = "select * from employee where empid= ?";
		
		EmployeeDto eDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, empid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				eDto = new EmployeeDto();
				
				eDto.setEmpnum(rs.getString("empnum"));
				eDto.setFirst_name(rs.getString("first_name"));
				eDto.setLast_name(rs.getString("last_name"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return eDto;
	}
	
	public int EmployeeDelete(String empnum){
		String sql ="delete from employee where empnum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, empnum);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
}
