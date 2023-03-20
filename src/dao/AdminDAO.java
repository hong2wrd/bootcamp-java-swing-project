package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;
import dto.SubmitDTO;

public class AdminDAO {
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1522:xe";
	String user = "mini";
	String pw = "mini";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "";
	
	// DB연결
	public void dbOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	// DB해제
	public void dbClose() {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con!= null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// 회원 목록 
	public List<MemberDTO> listMember(){
		List<MemberDTO> memList = new ArrayList<>();
		MemberDTO dto = new MemberDTO();
		try {
			dbOpen();
			sql = "select * from member order by memCode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setMemCode(rs.getInt("memCode"));
				dto.setMemId(rs.getString("memId"));
				dto.setMemPw(rs.getString("memPw"));
				dto.setMemName(rs.getString("memName"));
				dto.setMemAddr(rs.getString("memAddr"));
				dto.setMemPh1(rs.getString("memPh1"));
				dto.setMemPh2(rs.getString("memPh2"));
				dto.setMemPh3(rs.getString("memPh3"));
				memList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return memList;
	}
	
	// 회원 선택
	public MemberDTO selectMember(int memCode) {
		MemberDTO dto = new MemberDTO();
		try {
			dbOpen();
			sql = "select * from member where memCode=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, memCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setMemCode(rs.getInt("memCode"));
				dto.setMemId(rs.getString("memId"));
				dto.setMemPw(rs.getString("memPw"));
				dto.setMemName(rs.getString("memName"));
				dto.setMemAddr(rs.getString("memAddr"));
				dto.setMemPh1(rs.getString("memPh1"));
				dto.setMemPh2(rs.getString("memPh2"));
				dto.setMemPh3(rs.getString("memPh3"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return dto;
	}
	
	// 입양신청서 목록
	public List<SubmitDTO> submitList(){
		List<SubmitDTO> submitList = new ArrayList<>();
		SubmitDTO dto = new SubmitDTO();
		
		try {
			dbOpen();
			sql = "select * from submit order by subCode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto.setSubCode(rs.getInt("subCode"));
				dto.setMemCode(rs.getInt("memCode"));
				dto.setDogCode(rs.getInt("dogCode"));
				submitList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return submitList;
	}
	
	// 입양신청서 조회
	public SubmitDTO selectSubmit(int subCode) {
		SubmitDTO dto = new SubmitDTO();
		try {
			dbOpen();
			sql = "select * from submit where subCode=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, subCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setSubCode(rs.getInt("subCode"));
				dto.setMemCode(rs.getInt("memCode"));
				dto.setDogCode(rs.getInt("dogCode"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return dto;
	}
	
	
	// 입소신청서 목록
	
	
	// 강아지 등록

	// 강아지 목록
	
	// 강아지 조회
	
	// 강아지 삭제
	
	// 강아지 수정 
	
	// 상품 목록
	
	// 상품 조회
	
	// 상품 등록 
	
	// 상품 삭제 
	
	// 상품 수정 
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
