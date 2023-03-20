package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.HospitalDTO;

public class HospitalDAO {
	
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
	
	// 보호소 목록
	public List<HospitalDTO> hospitalList() {
		List<HospitalDTO> list = new ArrayList<>();
		try {
			dbOpen();
			sql = "select * from hospital order by hosCode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				HospitalDTO dto = new HospitalDTO();
				dto.setHosCode(rs.getInt("hosCode"));
				dto.setHosName(rs.getString("hosName"));
				dto.setHosAddr(rs.getString("hosAddr"));
				dto.setHosPh1(rs.getString("hosPh1"));
				dto.setHosPh2(rs.getString("hosPh2"));
				dto.setHosPh3(rs.getString("hosPh3"));
				
				list.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return list;
	}
	
	// 보호소 등록
	public int insertHospital(HospitalDTO dto) {
		
		int res = 0;
		
		try {
			dbOpen();
			sql = "insert into hospital values(shel_seq.nextval, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getHosName());
			ps.setString(2, dto.getHosAddr());
			ps.setString(3, dto.getHosPh1());
			ps.setString(4, dto.getHosPh2());
			ps.setString(5, dto.getHosPh3());
			
			res = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return res;
	}

	public int updateHospital(HospitalDTO dto) {
		int res = 0;
		try {
			dbOpen();
			sql = "update hospital set hosName=?, hosAddr=?, hosPh1=?, hosPh2=?, hosPh3=? where hosCode=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getHosName());
			ps.setString(2, dto.getHosAddr());
			ps.setString(3, dto.getHosPh1());
			ps.setString(4, dto.getHosPh2());
			ps.setString(5, dto.getHosPh3());
			ps.setInt(6, dto.getHosCode());
			
			res = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return res;
	}

	public int deleteHospital(int hosCode) {
		int res = 0;
		try {
			dbOpen();
			sql = "delete from hospital where hosCode="+hosCode;
			ps = con.prepareStatement(sql);
			res = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return res;
	}

}
