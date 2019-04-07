/**
 * 
 */
package com.businessdecision.demo.types;

/**
 * The {@link Address} graphql type.
 * @author bernard.adanlessossi
 *
 */
public class Address {

	private String id;
	private String street;
	private String zip;
	private String city;
	
	/**
	 * Creates this {@link Address} with parameters.
	 * @param id the id of this {@link Address}
	 * @param street the street of this {@link Address}
	 * @param zip the zip code of this {@link Address}
	 * @param city the city of this {@link Address}
	 */
	public Address(String id, String street, String zip, String city) {
		super();
		this.id = id;
		this.street = street;
		this.zip = zip;
		this.city = city;
	}
	
	/**
	 * Gets the id of this {@link Address}.
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id of this {@link Address}.
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the street of this {@link Address}.
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets the street of this {@link Address}.
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Gets the zip code of this {@link Address}.
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * Sets the zip code of this {@link Address}.
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * Gets the city of this {@link Address}.
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city of this {@link Address}.
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}
