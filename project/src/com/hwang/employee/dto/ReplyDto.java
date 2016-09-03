package com.hwang.employee.dto;

public class ReplyDto {
	private String replyno;
	private String noticenum;
	private String empnum;
	private String content;
	private String writedate;
	
	public ReplyDto() {

	}

	public String getReplyno() {
		return replyno;
	}

	public void setReplyno(String replyno) {
		this.replyno = replyno;
	}

	public String getNoticenum() {
		return noticenum;
	}

	public void setNoticenum(String noticenum) {
		this.noticenum = noticenum;
	}

	public String getEmpnum() {
		return empnum;
	}

	public void setEmpnum(String empnum) {
		this.empnum = empnum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "ReplyDto [replyno=" + replyno + ", noticenum=" + noticenum + ", empnum=" + empnum + ", content="
				+ content + ", writedate=" + writedate + "]";
	}
	
	
}
