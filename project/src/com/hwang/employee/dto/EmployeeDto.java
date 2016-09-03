package com.hwang.employee.dto;


public class EmployeeDto {
	private String 		empid;
	private String 		pwd;
	private String 		empnum;
	private String 		first_name;
	private String 		last_name;
	private String 		reginum;
	private String 		emp_img;
	private String 		emp_img_org;
	private String 		deptnum;
	private String 		pnum;
	private String 		zipcode;
	private String 		address;
	private String 		detailaddress;
	private String 		email;
	private String 		phone;
	private int			salary;
	private String		hire_date;
	private String		out_date;
	private int			manager;
	private String		regidate;
	private String		gender;
	private String		birth;
	
	public EmployeeDto() {
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmpnum() {
		return empnum;
	}

	public void setEmpnum(String empnum) {
		this.empnum = empnum;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getReginum() {
		return reginum;
	}

	public void setReginum(String reginum) {
		this.reginum = reginum;
	}

	public String getEmp_img() {
		return emp_img;
	}

	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
	}

	public String getEmp_img_org() {
		return emp_img_org;
	}

	public void setEmp_img_org(String emp_img_org) {
		this.emp_img_org = emp_img_org;
	}

	public String getDeptnum() {
		return deptnum;
	}

	public void setDeptnum(String deptnum) {
		this.deptnum = deptnum;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getOut_date() {
		return out_date;
	}

	public void setOut_date(String out_date) {
		this.out_date = out_date;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "EmployeeDto [empid=" + empid + ", pwd=" + pwd + ", empnum=" + empnum + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", reginum=" + reginum + ", emp_img=" + emp_img + ", emp_img_org="
				+ emp_img_org + ", deptnum=" + deptnum + ", pnum=" + pnum + ", zipcode=" + zipcode + ", address="
				+ address + ", detailaddress=" + detailaddress + ", email=" + email + ", phone=" + phone + ", salary="
				+ salary + ", hire_date=" + hire_date + ", out_date=" + out_date + ", manager=" + manager
				+ ", regidate=" + regidate + ", gender=" + gender + ", birth=" + birth + "]";
	}


	
	
}
