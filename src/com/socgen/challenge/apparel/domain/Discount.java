package com.socgen.challenge.apparel.domain;

/**
 * @author reju.pillai@gmail.com
 *
 * This class represents the Discount entity 
 */
public class Discount {

	public Discount(String id, String name, String description, double value) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.value = value;
	}

	/**
	 * discount id
	 */
	private String id;

	/**
	 * name of the discount
	 */
	private String name;

	/**
	 * description of the discount
	 */
	private String description;

	/**
	 * @return get discount id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            set disount id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return get the name of discount
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            set the discount name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return get the discount description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            set the discount description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * discount value in Rupees.
	 */
	private double value;

	/**
	 * @return
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}

}
