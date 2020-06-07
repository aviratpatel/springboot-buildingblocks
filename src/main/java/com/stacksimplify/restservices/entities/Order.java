/**
 * 
 */
package com.stacksimplify.restservices.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Avi
 * Create Order entity, define tables, create constructor using super class (right click and source) 
 * and create getters and setters methods
 */

@Entity // You need to import import javax.persistence.Entity package using control + shift + o
@Table(name = "orders") // You need to import import javax.persistence.Table package using control + shift + o
public class Order {
	
	@Id
	@GeneratedValue
	private long orderid;
	
	private String orderdescription;
	
	// We need to create a relation to User entity; Multiple orders in Order entity can be associated to user
	@ManyToOne(fetch=FetchType.LAZY) // import javax.persistence.ManyToOne package
	@JsonIgnore //If we don't use this annotation then, whenever we create an order, it also expects user data to be sent
	private User user;

	/**
	 * 
	 */
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the orderid
	 */
	public long getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	/**
	 * @return the orderdescription
	 */
	public String getOrderdescription() {
		return orderdescription;
	}

	/**
	 * @param orderdescription the orderdescription to set
	 */
	public void setOrderdescription(String orderdescription) {
		this.orderdescription = orderdescription;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
