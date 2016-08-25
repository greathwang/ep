package com.hwang.employee.dto;

import java.sql.Timestamp;

public class ProjectDto {
	private String pjtcd;
	private String pjt;
	private String pjtdtl;
	private Timestamp startdt;
	private Timestamp enddt;
	private Timestamp regdt;
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

	public Timestamp getStartdt() {
		return startdt;
	}

	public void setStartdt(Timestamp startdt) {
		this.startdt = startdt;
	}

	public Timestamp getEnddt() {
		return enddt;
	}

	public void setEnddt(Timestamp enddt) {
		this.enddt = enddt;
	}

	public Timestamp getRegdt() {
		return regdt;
	}

	public void setRegdt(Timestamp regdt) {
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