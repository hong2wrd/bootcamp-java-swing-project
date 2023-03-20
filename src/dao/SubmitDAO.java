package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.SubmitDTO;

public class SubmitDAO {
	
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
			Class.forName(driver);
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
	
	// 입양신청서 등록 
	public int insertSubmit(SubmitDTO sub) {
		int res = 0;
		try {
			dbOpen();
			sql = "insert into submit values(sub_seq.nextval, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, sub.getMemCode());
			ps.setInt(2, sub.getDogCode());
			
			res = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return res;
	}
	
	// 입양신청서 목록
	public List<SubmitDTO> submitList(){
		List<SubmitDTO> submitList = new ArrayList<>();
		
		try {
			dbOpen();
			sql = "select * from submit order by subCode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SubmitDTO dto = new SubmitDTO();
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
	
	

}
