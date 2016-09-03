package com.hwang.employee.dto;


public class ProjectDto {
	private String pjtcd;
	private String pjt;
	private String pjtdtl;
	private String startdt;
	private String enddt;
	private String regdt;
	private String reguser;
	
	public ProjectDto() {
	}

	public String getPjtcd() {
		return pjtcd;
	}

	public void setPjtcd(String pjtcd) {
		this.pjtcd = pjtcd;
	}

	public String getPjt() {
		return pjt;
	}

	public void setPjt(String pjt) {
		this.pjt = pjt;
	}

	public String getPjtdtl() {
		return pjtdtl;
	}

	public void setPjtdtl(String pjtdtl) {
		this.pjtdtl = pjtdtl;
	}

	public String getStartdt() {
		return startdt;
	}

	public void setStartdt(String startdt) {
		this.startdt = startdt;
	}

	public String getEnddt() {
		return enddt;
	}

	public void setEnddt(String enddt) {
		this.enddt = enddt;
	}

	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	public String getReguser() {
		return reguser;
	}

	public void setReguser(String reguser) {
		this.reguser = reguser;
	}

	@Override
	public String toString() {
		return "ProjectDto [pjtcd=" + pjtcd + ", pjt=" + pjt + ", pjtdtl=" + pjtdtl + ", startdt=" + startdt
				+ ", enddt=" + enddt + ", regdt=" + regdt + ", reguser=" + reguser + "]";
	}
	
	
}
