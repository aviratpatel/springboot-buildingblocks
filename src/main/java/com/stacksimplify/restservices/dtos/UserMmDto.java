/**
 * 
 */
package com.stacksimplify.restservices.dtos;

import java.util.List;

import com.stacksimplify.restservices.entities.Order;

/**
 * @author Avi
 *
 */
public class UserMmDto {
	
	private long userid;
	private String username;
	private String firstname;
	private List<Order> orders;

	/**
	 * @return the userid
	 */
	public long getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(long userid) {
		this.userid = userid;
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
