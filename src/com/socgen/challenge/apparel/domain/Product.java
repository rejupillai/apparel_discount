package com.socgen.challenge.apparel.domain;

/**
 * @author reju.pillai@gmail.com 
 * This class represents the Product entity
 */
public class Product {

	/**
	 * product id
	 */
	private String id;
	/**
	 * product name
	 */
	private String name;
	/**
	 * brand product belongs to
	 */
	private Brand brand;
	/**
	 * category the product belongs to
	 */
	private Category category;
	/**
	 * MRP of the product
	 */
	private double price;
	/**
	 * final price after discount is applied.
	 */
	private transient double discountedPrice;

	/**
	 * @param id
	 * @param name
	 * @param brand
	 * @param category
	 * @param price
	 * @param discountedPrice
	 */
	public Product(String id, String name, Brand brand, Category category, double price, double discountedPrice) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.discountedPrice = discountedPrice;
	}

	/**
	 * Empty Constructor
	 */
	public Product() {
	}

	/**
	 * @return get product id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            set product id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return get product name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            set product name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return get brand name
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 *            set brand name
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return get product category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            set product category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return get MRP
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            set MRP
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return get price after discount
	 */
	public double getDiscountedPrice() {
		return discountedPrice;
	}

	/**
	 * @param discountedPrice
	 *            set discounted price
	 */
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

}
