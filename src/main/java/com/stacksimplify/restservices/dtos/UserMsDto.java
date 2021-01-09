/**
 * 
 */
package com.stacksimplify.restservices.dtos;


/**
 * @author Avi
 * MapStruct DTO
 */

public class UserMsDto {
	
	private long userid;
	private String username;
	private String emailaddress;
	private String rolename;
	//private List<Order> orders;
	
	/**
	 * @param userid
	 * @param username
	 * @param emailaddress
	 */
	
	/**
	 * 
	 */
	public UserMsDto() {

	}
	
	
	public UserMsDto(long userid, String username, String emailaddress, String rolename) {
		super();
		this.userid = userid;
		this.username = username;
		this.emailaddress = emailaddress;
		this.rolename = rolename;
	}

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
	 * @return the emailaddress
	 */
	public String getEmailaddress() {
		return emailaddress;
	}
	/**
	 * @param emailaddress the emailaddress to set
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}


	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}


	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	

}
