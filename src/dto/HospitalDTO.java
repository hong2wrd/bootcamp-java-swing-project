package dto;

import javax.swing.JButton;

import graphics.RoundButton;

public class HospitalDTO {
	
	private int hosCode;
	private String hosName;
	private String hosAddr;
	private String hosPh1;
	private String hosPh2;
	
	public int getHosCode() {
		return hosCode;
	}
	public void setHosCode(int hosCode) {
		this.hosCode = hosCode;
	}
	public String getHosName() {
		return hosName;
	}
	public void setHosName(String hosName) {
		this.hosName = hosName;
	}
	public String getHosAddr() {
		return hosAddr;
	}
	public void setHosAddr(String hosAddr) {
		this.hosAddr = hosAddr;
	}
	public String getHosPh1() {
		return hosPh1;
	}
	public void setHosPh1(String hosPh1) {
		this.hosPh1 = hosPh1;
	}
	public String getHosPh2() {
		return hosPh2;
	}
	public void setHosPh2(String hosPh2) {
		this.hosPh2 = hosPh2;
	}
	public String getHosPh3() {
		return hosPh3;
	}
	public void setHosPh3(String hosPh3) {
		this.hosPh3 = hosPh3;
	}
	public RoundButton getSelectHosBtn() {
		return selectHosBtn;
	}
	public void setSelectHosBtn(RoundButton selectHosBtn) {
		this.selectHosBtn = selectHosBtn;
	}
	private String hosPh3;
	private RoundButton selectHosBtn = new RoundButton("조회");
	
	
}
