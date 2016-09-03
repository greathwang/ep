package com.hwang.employee.dto;

public class AddressDto {
	private String addrno;
	private String zipcode;
	private String sido;
	private String sigugun;
	private String dong;
	private String ri;
	private String bldg;
	private String bungi;
	
	public AddressDto() {
	}

	public String getAddrno() {
		return addrno;
	}

	public void setAddrno(String addrno) {
		this.addrno = addrno;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigugun() {
		return sigugun;
	}

	public void setSigugun(String sigugun) {
		this.sigugun = sigugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getRi() {
		return ri;
	}

	public void setRi(String ri) {
		this.ri = ri;
	}

	public String getBldg() {
		return bldg;
	}

	public void setBldg(String bldg) {
		this.bldg = bldg;
	}

	public String getBungi() {
		return bungi;
	}

	public void setBungi(String bungi) {
		this.bungi = bungi;
	}

	@Override
	public String toString() {
		return "AddressDto [addrno=" + addrno + ", zipcode=" + zipcode + ", sido=" + sido + ", sigugun=" + sigugun
				+ ", dong=" + dong + ", ri=" + ri + ", bldg=" + bldg + ", bungi=" + bungi + "]";
	}
	
	
}
