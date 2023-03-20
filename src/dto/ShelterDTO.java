package dto;

import javax.swing.JButton;

import graphics.RoundButton;

public class ShelterDTO {
	
	private int shelCode;
	private String shelName;
	private String shelAddr;
	private String shelPh1;
	private String shelPh2;
	private String shelPh3;
	private RoundButton selectShelBtn = new RoundButton("조회");
	
	public int getShelCode() {
		return shelCode;
	}
	public void setShelCode(int shelCode) {
		this.shelCode = shelCode;
	}
	public String getShelName() {
		return shelName;
	}
	public void setShelName(String shelName) {
		this.shelName = shelName;
	}
	public String getShelAddr() {
		return shelAddr;
	}
	public void setShelAddr(String shelAddr) {
		this.shelAddr = shelAddr;
	}
	public String getShelPh1() {
		return shelPh1;
	}
	public void setShelPh1(String shelPh1) {
		this.shelPh1 = shelPh1;
	}
	public String getShelPh2() {
		return shelPh2;
	}
	public void setShelPh2(String shelPh2) {
		this.shelPh2 = shelPh2;
	}
	public String getShelPh3() {
		return shelPh3;
	}
	public void setShelPh3(String shelPh3) {
		this.shelPh3 = shelPh3;
	}
	
	public RoundButton getSelectShelBtn() {
		return this.selectShelBtn;
	}
	
	public void setSelectShelBtn(RoundButton selectShelBtn) {
		this.selectShelBtn = selectShelBtn;
	}

}
