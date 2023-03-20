package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import dto.MemberDTO;

public class MemberDAO {
	
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
	
	// 회원 가입
	public int insertMember(MemberDTO m) {
		int res = -1;
		try {
			dbOpen();
			sql = "select * from member where memId=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getMemId());
			rs = ps.executeQuery();
			
			if(!rs.next()) {
				sql = "insert into member values(mem_seq.nextval,?,?,?,?,?,?,?)";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, m.getMemId());
				ps.setString(2, m.getMemPw());
				ps.setString(3, m.getMemName());
				ps.setString(4, m.getMemAddr());
				ps.setString(5, m.getMemPh1());
				ps.setString(6, m.getMemPh2());
				ps.setString(7, m.getMemPh3());
				
				res = ps.executeUpdate();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return res;
	}
	
	// 로그인
	public int loginCheck(String id, String pw) {
		int loginToken = -1;
		try {
			dbOpen();
			sql = "select * from member where memid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				if(pw.equals(rs.getString("mempw"))) {
					loginToken = 1;
				}
			}else {
				loginToken = 0;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	
	return loginToken;	
	}
	
	// 회원 선택
	public MemberDTO selectOneMember(String id) {
		MemberDTO dto = new MemberDTO();
		try {
			dbOpen();
			sql = "select * from member where memid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setMemCode(rs.getInt("memCode"));
				dto.setMemId(rs.getString("memId"));
				dto.setMemPw(rs.getString("memPw"));
				dto.setMemName(rs.getString("memName"));
				dto.setMemAddr(rs.getNString("memAddr"));
				dto.setMemPh1(rs.getString("memPh1"));
				dto.setMemPh2(rs.getString("memPh2"));
				dto.setMemPh3(rs.getString("memPh3"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return dto;
	}
	
	// 회원정보 수정
	public int updateMemberInfo(MemberDTO dto) {
		
		int res = 0;
		
		try {
			dbOpen();
			sql = "update Member set memAddr=?, memPh1=?, memPh2=?, memPh3=? where memcode=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMemAddr()); 
			ps.setString(2, dto.getMemPh1());
			ps.setString(3, dto.getMemPh2());
			ps.setString(4, dto.getMemPh3());
			ps.setInt(5, dto.getMemCode());
			
			res = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			dbClose();
		}
		
		return res;
	}
	
	// 비밀번호 변경
	public int updateMemberPw(String newPw, int memCode) {
		int res = 0;
		try {
			dbOpen();
			sql = "update member set memPw=? where memCode=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, newPw);
			ps.setInt(2, memCode);
			
			res = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		return res;
	}

	// 회원 탈퇴
	public int deleteMember(int memCode) {
		int res = 0;
		try {
			dbOpen();
			sql = "delete from member where memcode=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, memCode);
			
			res = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return res;
	}
	
	

}
