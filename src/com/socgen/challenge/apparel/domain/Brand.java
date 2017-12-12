package com.socgen.challenge.apparel.domain;

/**
 * @author reju.pillai@gmail.com
 * This class represent the Brand entity
 */
public class Brand {
	
	
	/**
	 * @param id
	 * @param discount
	 * @param name
	 */
	public Brand(String id, Discount discount, String name) {
		super();
		this.id = id;
		this.discount = discount;
		this.name = name;
	}

	/**
	 * id : brand id
	 */
	private String id;

	/**
	 * discount on brand
	 */
	private Discount discount;

	/**
	 * name of the brand
	 */
	private String name;

	/**
	 * @return get the brand id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            set brand id.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return get the discount on brand.
	 */
	public Discount getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            set discount on brand.
	 */
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	/**
	 * @return get the name of brand.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            set the name of brand.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if ( this.name.equals(  ((Brand)obj).name))
		return true;
		else return false ; 
	}
	
	
	

}
