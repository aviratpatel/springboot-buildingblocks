// This is an extra file I created just to test if Spring boot creates below table due to @Table annotation
package com.stacksimplify.restservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Avi
 *
 */
// Entity is a POJO and you can say it like DB table on a very high level term
//@Entity(name="users")
@Entity
@Table(name="aarav")  // User Ctrl+Space+o to import java library class without seeing possible options; 

// Above statement creates table with name aarav based on columns defined in the class below; Other option is to run create table statement in data.sql file directly but then, we cannot set the values without creating repositories

//H2 database is in-memory database and it has default schema testdb (with username as sa and pwd as blank/null)
// But, data will be wiped off as soon as you restart application or reload JVM (DB stores memory in RAM
//@Table(name="aarav", schema="avi")  // For mySQL, oracle connection, schema is must needed parameter


public class Aarav {
	
	@Id // JPA considers this annotation as primary key; Each JPA entity must have a primary key
	@GeneratedValue // to create auto generated value for primary column; let us keep default type which is sequence
	private Long id1;
	
	@Column(name="USER_NAME1", length=30, nullable=false, unique=true)
	private String username1;
	
	@Column(name="FIRST_NAME1", length=30, nullable=false)	
	private String firstname1;
	@Column(name="LAST_NAME1", length=30, nullable=false)	
	private String lastname1;


	// No argument constructor
	/**
	 * 
	 */
	public Aarav() {
		// TODO Auto-generated constructor stub
	}

	// Field Constructors (optional)
	/**
	 * @param id1
	 * @param username1
	 * @param firstname1
	 * @param lastname1

	 */
	public Aarav(Long id1, String username1, String firstname1, String lastname1) {
		this.id1 = id1;
		this.username1 = username1;
		this.firstname1 = firstname1;
		this.lastname1 = lastname1;
	}

	// Getters and Setters
	/**
	 * @return the id
	 */
	public Long getId1() {
		return id1;
	}

	/**
	 * @param id the id to set
	 */
	public void setId1(Long id1) {
		this.id1 = id1;
	}

	/**
	 * @return the username
	 */
	public String getUsername1() {
		return username1;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername1(String username) {
		this.username1 = username1;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname1() {
		return firstname1;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname1(String firstname1) {
		this.firstname1 = firstname1;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname1() {
		return lastname1;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname1(String lastname1) {
		this.lastname1 = lastname1;
	}


	// toString method (optional; required for bean logging/debugging)
	@Override
	public String toString() {
		return "Aarav [id1=" + id1 + ", username1=" + username1 + ", firstname1=" + firstname1 + ", lastname1=" + lastname1
				 + "]";
	}	

}
