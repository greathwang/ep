package com.hwang.employee.dto;

public class NoticeDto {
	private String 	noticenum;
	private String 	empid;
	private String 	content;
	private String 	title;
	private String	writedate;
	private String	hit;
	
	public NoticeDto() {
	}
	
	public String getNoticenum() {
		return noticenum;
	}
	public void setNoticenum(String noticenum) {
		this.noticenum = noticenum;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	
	@Override
	public String toString() {
		return "NoticeDto [noticenum=" + noticenum + ", empid=" + empid + ", content=" + content + ", title=" + title
				+ ", writedate=" + writedate + ", num=" + hit + "]";
	}
	
	
}
