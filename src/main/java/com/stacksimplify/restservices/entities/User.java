/**
 * 
 */
package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Avi
 *
 */
// Entity is a POJO and you can say it like DB table on a very high level term
//@Entity(name="users")
@Entity // You need to import import javax.persistence.Entity; package using control + shift + o
@Table(name="user")  // User Ctrl+Space+o to import java library class without seeing possible options; 

//H2 database is in-memory database and it has default schema testdb (with username as sa and pwd as blank/null)
// But, data will be wiped off as soon as you restart application or reload JVM (DB stores memory in RAM
//@Table(name="user", schema="avi")  // For mySQL, oracle connection, schema is must needed parameter

public class User {
	
	@Id // JPA considers this annotation as primary key; Each JPA entity must have a primary key
	@GeneratedValue // to create auto generated value for primary column; let us keep default type which is sequence
	private Long id;
	
	@NotEmpty(message = "Username is a mandatory attribute, please provide username") //Use ctrl+Shift+O to import javax validation
	@Column(name="USER_NAME", length=30, nullable=false, unique=true)
	private String username;
	
	@Size(min=2, message = "First Name should have minimum two characthers") //Use ctrl+Shift+O to import javax validation
	@Column(name="FIRST_NAME", length=30, nullable=false)	
	private String firstname;
	@Column(name="LAST_NAME", length=30, nullable=false)	
	private String lastname;
	@Column(name="EMAIL_ADDRESS", length=30, nullable=false)	
	private String email;
	@Column(name="ROLE", length=30, nullable=false)	
	private String role;
	
	@Column(name="SSN", length=40, nullable=false, unique=true)
	private String ssn; // social security number used in USA
	
	// Create one to many relationship to user field of Order entity; We are not creating primary key on DB 
	// but, we will need to store user id in Order table
	// Generated getters and setters of this new field orders on 7th June 2020
	@OneToMany(mappedBy="user") //import javax.persistence.OneToMany
	private List<Order> orders; //one user can do multiple orders to making as list of order field; import java.util.List package using control+shift+o
  
	
	// No argument constructor
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	// Field Constructors (optional)
	/**
	 * @param id
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param role
	 * @param ssn
	 */
	public User(Long id, String username, String firstname, String lastname, String email, String role, String ssn) {
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	// Getters and Setters
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// toString method (optional; required for bean logging/debugging)
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

		

}
