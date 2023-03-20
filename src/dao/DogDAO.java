package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DogDTO;

public class DogDAO {
	
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
	
	// 강아지 목록 (관리자)
	public List<DogDTO> listDogAdmin(){
		List<DogDTO> dogList = new ArrayList<>();
		try {
			dbOpen();
			sql = "select * from dog order by dogCode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DogDTO dog = new DogDTO();
				dog.setDogCode(rs.getInt("dogCode"));
				dog.setMemCode(rs.getInt("memCode"));
				dog.setDogName(rs.getString("dogName"));
				dog.setDogSpe(rs.getString("dogSpe"));
				dog.setDogAge(rs.getInt("dogAge"));
				dog.setDogImage(rs.getString("dogImage"));
				dog.setDogNeu(rs.getString("dogNeu"));
				dog.setDogSex(rs.getString("dogSex"));
				dog.setDogDis(rs.getString("dogDis"));
				dog.setDogIno(rs.getString("dogIno"));
				dog.setDogSelected(rs.getInt("dogSelected"));
				
				dogList.add(dog);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return dogList;
	}
	
	// 강아지 목록 (사용자)
	public List<DogDTO> listDogUser(){
		List<DogDTO> dogList = new ArrayList<>();
		try {
			dbOpen();
			sql = "select * from dog where dogSelected=1 order by dogCode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DogDTO dog = new DogDTO();
				dog.setDogCode(rs.getInt("dogCode"));
				dog.setMemCode(rs.getInt("memCode"));
				dog.setDogName(rs.getString("dogName"));
				dog.setDogSpe(rs.getString("dogSpe"));
				dog.setDogAge(rs.getInt("dogAge"));
				dog.setDogImage(rs.getString("dogImage"));
				dog.setDogNeu(rs.getString("dogNeu"));
				dog.setDogSex(rs.getString("dogSex"));
				dog.setDogDis(rs.getString("dogDis"));
				dog.setDogIno(rs.getString("dogIno"));
				dog.setDogSelected(rs.getInt("dogSelected"));
				
				dogList.add(dog);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return dogList;
	}
	
	// 입소 신청
	public int insertDog(DogDTO dog) {
		int res = 0;
		
		try {
			dbOpen();
			sql = "insert into dog values(dog_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, dog.getMemCode());
			ps.setString(2, dog.getDogName());
			ps.setString(3, dog.getDogSpe());
			ps.setInt(4, dog.getDogAge());
			ps.setString(5, dog.getDogImage());
			ps.setString(6, dog.getDogNeu());
			ps.setString(7, dog.getDogSex());
			ps.setString(8, dog.getDogDis());
			ps.setString(9, dog.getDogIno());
			
			res = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return res;
	}
	
	// 강아지 등록
	public int regiDog(int dogCode) {
		int res = 0;
		try {
			dbOpen();
			sql = "update dog set dogSelected=1 where dogCode=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dogCode);
			res = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return res;
		
	}
	
	
	
	
	
	
	
	
	
	

}
