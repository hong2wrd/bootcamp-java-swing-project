package dto;

public class MemberDTO {
	
	private int memCode;
	private String memId;
	private String memPw;
	private String memName;
	private String memPh1;
	private String memPh2;
	private String memPh3;
	private String memAddr;
	

	public MemberDTO() {
		
	}
	
	public MemberDTO(String memId, String memPw, String memName, String memAddr, String memPh1,
			String memPh2, String memPh3) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memAddr = memAddr;
		this.memPh1 = memPh1;
		this.memPh2 = memPh2;
		this.memPh3 = memPh3;
	}

	public int getMemCode() {
		return memCode;
	}

	public void setMemCode(int memCode) {
		this.memCode = memCode;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}
	
	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public String getMemPh1() {
		return memPh1;
	}

	public void setMemPh1(String memPh1) {
		this.memPh1 = memPh1;
	}

	public String getMemPh2() {
		return memPh2;
	}

	public void setMemPh2(String memPh2) {
		this.memPh2 = memPh2;
	}

	public String getMemPh3() {
		return memPh3;
	}

	public void setMemPh3(String memPh3) {
		this.memPh3 = memPh3;
	}
	
	
	
}
	