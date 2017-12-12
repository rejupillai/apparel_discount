package com.socgen.challenge.apparel.domain;

/**
 * @author reju.pillai@gmail.com This class represent the Category entity.
 *         Categories may / mayn't have Parent Categories. A root-level parent
 *         category would have a 'null' parentCategory
 */
public class Category {

	/**
	 * @param id
	 * @param name
	 * @param parentCategory
	 * @param discount
	 */
	public Category(String id, String name, Category parentCategory, Discount discount) {
		super();
		this.id = id;
		this.name = name;
		this.parentCategory = parentCategory;
		this.discount = discount;
	}

	/**
	 * category id
	 */
	private String id;
	/**
	 * category name
	 */
	private String name;
	/**
	 * parent category this category belongs to, null if root level category
	 */
	private Category parentCategory;
	/**
	 * discount applied on category
	 */
	private Discount discount;

	/**
	 * @return get category id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            set category id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return get category name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            set category name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return get parent category
	 */
	public Category getParentCategory() {
		return parentCategory;
	}

	/**
	 * @param parentCategory
	 *            set parent category
	 */
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	/**
	 * @return get discount
	 */
	public Discount getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            set discount
	 */
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@Override
	public boolean equals(Object obj) {

		if (this.name.equals(((Category) obj).name))
			return true;
		else
			return false;
	}

}
