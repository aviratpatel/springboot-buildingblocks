/**
 * 
 */
package com.stacksimplify.restservices.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Avi
 * 
 * Created this class as per assignment given in Udemy Spring Boot training (class number 76 at 12:35 time)
 * https://wipro.udemy.com/course/master-restful-apis-with-spring-boot/learn/lecture/15789210#labs
 * I added 3 insert statement in data.sql file (Under src/main/resources) so, no need to create methods for inserting data in service and controller classes
 *
 */
@Entity
@Table(name="employee")
public class Employee {
	
	@Id // JPA considers this annotation as primary key; Each JPA entity must have a primary key
	@GeneratedValue // to create auto generated value for primary column; let us keep default type which is sequence
	@JsonView(Views.EmployeeNormal.class)
	private Long empid;
	
	@JsonView(Views.EmployeeNormal.class)
	@Column(name="EMP_NAME", length=30, nullable=false, unique=false)
	private String empname;
	
	@JsonView(Views.EmployeeNormal.class)
	@Column(name="EMAIL", length=30, nullable=false, unique=true)
	private String email;
	
	@JsonView(Views.EmployeeNormal.class)
	@Column(name="DEPARTMENT", length=30, nullable=false, unique=false)
	private String department;
	
	@JsonView(Views.Manager.class)
	@Column(name="MANAGER_ID", length=30, nullable=true, unique=false)
	private Long mgrid;
	
	@JsonView(Views.HR.class)
	@Column(name="SALARY", length=30, nullable=false, unique=false)
	private Long sal;
	
	@JsonView(Views.Manager.class)
	@Column(name="SHIFT_STARTTIME", length=30, nullable=false, unique=false)
	private String shiftstarttime;
	
	@JsonView(Views.Manager.class)
	@Column(name="SHIFT_ENDTIME", length=30, nullable=false, unique=false)
	private String shiftendtime;
	
	@JsonView(Views.HR.class)
	@Column(name="JOINED_ON", length=30, nullable=false, unique=false)
	private Date joiningdate;
	
	@JsonView(Views.HR.class)
	@Column(name="PROMOTED_ON", length=30, nullable=false, unique=false)
	private Date lastpromotiondate;

	/**
	 * @return the empid
	 */
	public Long getEmpid() {
		return empid;
	}

	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	/**
	 * @return the empname
	 */
	public String getEmpname() {
		return empname;
	}

	/**
	 * @param empname the empname to set
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the mgrid
	 */
	public Long getMgrid() {
		return mgrid;
	}

	/**
	 * @param mgrid the mgrid to set
	 */
	public void setMgrid(Long mgrid) {
		this.mgrid = mgrid;
	}

	/**
	 * @return the sal
	 */
	public Long getSal() {
		return sal;
	}

	/**
	 * @param sal the sal to set
	 */
	public void setSal(Long sal) {
		this.sal = sal;
	}

	/**
	 * @return the shiftstarttime
	 */
	public String getShiftstarttime() {
		return shiftstarttime;
	}

	/**
	 * @param shiftstarttime the shiftstarttime to set
	 */
	public void setShiftstarttime(String shiftstarttime) {
		this.shiftstarttime = shiftstarttime;
	}

	/**
	 * @return the shiftendtime
	 */
	public String getShiftendtime() {
		return shiftendtime;
	}

	/**
	 * @param shiftendtime the shiftendtime to set
	 */
	public void setShiftendtime(String shiftendtime) {
		this.shiftendtime = shiftendtime;
	}

	/**
	 * @return the joiningdate
	 */
	public Date getJoiningdate() {
		return joiningdate;
	}

	/**
	 * @param joiningdate the joiningdate to set
	 */
	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	/**
	 * @return the lastpromotiondate
	 */
	public Date getLastpromotiondate() {
		return lastpromotiondate;
	}

	/**
	 * @param lastpromotiondate the lastpromotiondate to set
	 */
	public void setLastpromotiondate(Date lastpromotiondate) {
		this.lastpromotiondate = lastpromotiondate;
	}

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param empid
	 * @param empname
	 * @param email
	 * @param department
	 * @param mgrid
	 * @param sal
	 * @param shiftstarttime
	 * @param shiftendtime
	 * @param joiningdate
	 * @param lastpromotiondate
	 */
	public Employee(Long empid, String empname, String email, String department, Long mgrid, Long sal,
			String shiftstarttime, String shiftendtime, Date joiningdate, Date lastpromotiondate) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.email = email;
		this.department = department;
		this.mgrid = mgrid;
		this.sal = sal;
		this.shiftstarttime = shiftstarttime;
		this.shiftendtime = shiftendtime;
		this.joiningdate = joiningdate;
		this.lastpromotiondate = lastpromotiondate;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", email=" + email + ", department=" + department
				+ ", mgrid=" + mgrid + ", sal=" + sal + ", shiftstarttime=" + shiftstarttime + ", shiftendtime="
				+ shiftendtime + ", joiningdate=" + joiningdate + ", lastpromotiondate=" + lastpromotiondate + "]";
	}
	

}
