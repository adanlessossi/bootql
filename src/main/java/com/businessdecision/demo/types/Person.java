/**
 * 
 */
package com.businessdecision.demo.types;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The {@link Person} graphql type.
 * @author bernard.adanlessossi
 *
 */
@Entity
public class Person {

	@Id
	@GeneratedValue
	private String id;
	private String firstname;
	private String lastname;
	private int age;
	
	/**
	 * Creates this{@link Person}.
	 */
	public Person() {
		super();
	}
	
	/**
	 * Creates this {@link Person} with parameters.
	 * @param id the id of the {@link Person}
	 * @param firstname the firstname of the {@link Person}
	 * @param lastname the lastname of the {@link Person}
	 * @param age the age of the {@link Person}
	 */
	public Person(final String id, final String firstname, final String lastname, final int age) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	/**
	 * Gets the ID of this {@link Person}.
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the ID of this {@link Person}.
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the firstname of this {@link Person}.
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname of this {@link Person}.
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the lastname of this {@link Person}.
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname of this {@link Person}.
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the age of this {@link Person}.
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age of this {@link Person}.
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
