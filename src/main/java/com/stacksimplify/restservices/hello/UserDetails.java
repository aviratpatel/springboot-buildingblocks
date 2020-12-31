/**
 * 
 */
package com.stacksimplify.restservices.hello;

/**
 * @author Avi
 * UserDetails class that holds:
 *  3 attributes/variables
 *  getter and setter methods (Use Source menu --> Generate Getters and Setters...)
 *  constructors (Use Source menu --> Generate Constructor using Fields...)
 *  toString method (Use Source menu --> Generate toString()...)
 */
public class UserDetails {

	private String firstnmae;
	private String lastname;
	private String city;
	
	
	
	/**
	 * Fields Contstructor
	 * @param firstnmae
	 * @param lastname
	 * @param city
	 */
	public UserDetails(String firstnmae, String lastname, String city) {
		this.firstnmae = firstnmae;
		this.lastname = lastname;
		this.city = city;
	}
	public String getFirstnmae() {
		return firstnmae;
	}
	public void setFirstnmae(String firstnmae) {
		this.firstnmae = firstnmae;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	// toString method
	@Override
	public String toString() {
		return "UserDetails [firstnmae=" + firstnmae + ", lastname=" + lastname + ", city=" + city + "]";
	}
	
	
	
}
