package com.h2k.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hibernate Annotation Example
 * @author 
 *
 */


@Entity
@Table(name = "ACTOR")
public class Actor {
	
	
	@Override
	public String toString() {
		return "actor_id :: " + id 
				+ " firstName ::  " + firstName
				+ " lastName ::  " + lastName
				+ " last_update ::  " + lastUpdate;
	}
	
	public Actor() {
		// Default Constructor
	}
	
	@Id @GeneratedValue
	@Column(name = "actor_id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "last_update")
	private Date lastUpdate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}
	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
