package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ShelterDTO;

public class ShelterDAO {
	
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
	public List<ShelterDTO> shelterList() {
		List<ShelterDTO> list = new ArrayList<>();
		try {
			dbOpen();
			sql = "select * from shelter order by shelCode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ShelterDTO dto = new ShelterDTO();
				dto.setShelCode(rs.getInt("shelCode"));
				dto.setShelName(rs.getString("shelName"));
				dto.setShelAddr(rs.getString("shelAddr"));
				dto.setShelPh1(rs.getString("shelPh1"));
				dto.setShelPh2(rs.getString("shelPh2"));
				dto.setShelPh3(rs.getString("shelPh3"));
				
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
	public int insertShelter(ShelterDTO shelter) {
		
		int res = 0;
		
		try {
			dbOpen();
			sql = "insert into shelter values(shel_seq.nextval, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, shelter.getShelName());
			ps.setString(2, shelter.getShelAddr());
			ps.setString(3, shelter.getShelPh1());
			ps.setString(4, shelter.getShelPh2());
			ps.setString(5, shelter.getShelPh3());
			
			res = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return res;
	}

	public int updateShelter(ShelterDTO shel) {
		int res = 0;
		try {
			dbOpen();
			sql = "update shelter set shelName=?, shelAddr=?, shelPh1=?, shelPh2=?, shelPh3=? where shelCode=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, shel.getShelName());
			ps.setString(2, shel.getShelAddr());
			ps.setString(3, shel.getShelPh1());
			ps.setString(4, shel.getShelPh2());
			ps.setString(5, shel.getShelPh3());
			ps.setInt(6, shel.getShelCode());
			
			res = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return res;
	}

	public int deleteShelter(int shelCode) {
		int res = 0;
		try {
			dbOpen();
			sql = "delete from shelter where shelCode="+shelCode;
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
