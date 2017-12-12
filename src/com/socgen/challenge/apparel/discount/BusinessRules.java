package com.socgen.challenge.apparel.discount;

import java.util.HashMap;

import com.socgen.challenge.apparel.domain.Brand;
import com.socgen.challenge.apparel.domain.Category;
import com.socgen.challenge.apparel.domain.Discount;
import com.socgen.challenge.apparel.domain.Product;

/**
 * @author reju.pillai@gmail.com
 * 
 *         This class has the business rules for discount calculation. This
 *         class is also responsible to load all the given input data for
 *         Categories and Brands which inturn helps calculate the discount.
 *
 */
public class BusinessRules {

	/**
	 * Map to store all given Brands
	 */
	private static HashMap<String, Brand> brandMap = new HashMap<String, Brand>();

	/**
	 * Map to store all given Categories
	 */
	private static HashMap<String, Category> categoryMap = new HashMap<String, Category>();

	/**
	 * @return brandMap
	 */
	public static HashMap<String, Brand> getBrandMap() {
		return brandMap;
	}

	/**
	 * @param brandMap
	 */
	public static void setBrandMap(HashMap<String, Brand> brandMap) {
		brandMap = brandMap;
	}

	/**
	 * @return categoryMap
	 */
	public static HashMap<String, Category> getCategoryMap() {
		return categoryMap;
	}

	/**
	 * @param categoryMap
	 */
	public static void setCategoryMap(HashMap<String, Category> categoryMap) {
		categoryMap = categoryMap;
	}

	public static HashMap<String, Brand> loadBrands() {

		brandMap.put("Wrangler", new Brand("1", new Discount("1", "", "", 0.1), "Wrangler"));
		brandMap.put("Arrow", new Brand("2", new Discount("2", "", "", 0.2), "Arrow"));
		brandMap.put("Vero Moda", new Brand("3", new Discount("3", "", "", 0.6), "Vero Moda"));
		brandMap.put("UCB", new Brand("4", new Discount("4", "", "", 0), "UCB"));
		brandMap.put("Adidas", new Brand("5", new Discount("5", "", "", 0.05), "Adidas"));
		brandMap.put("Provogue", new Brand("6", new Discount("6", "", "", 0.2), "Provogue"));

		return brandMap;
	}

	/**
	 * @return
	 */
	public static HashMap<String, Category> loadCategories() {

		// Load Men's wear
		categoryMap.put("Men's wear", new Category("1", "Men's wear", null, new Discount("100", "", "", 0)));

		// Load all categories within Men's wear
		categoryMap.put("Shirts",
				new Category("100", "Shirts", categoryMap.get("Men's wear"), new Discount("102", "", "", 0)));
		categoryMap.put("Trousers",
				new Category("101", "Trousers", categoryMap.get("Men's wear"), new Discount("103", "", "", 0)));
		categoryMap.put("Casuals",
				new Category("102", "Casuals", categoryMap.get("Men's wear"), new Discount("104", "", "", 0.3)));
		categoryMap.put("Jeans",
				new Category("103", "Jeans", categoryMap.get("Men's wear"), new Discount("105", "", "", 0.2)));

		categoryMap.put("Women's wear", new Category("2", "Women's wear", null, new Discount("101", "", "", 0.5)));

		categoryMap.put("Dresses",
				new Category("104", "Dresses", categoryMap.get("Women's wear"), new Discount("106", "", "", 0)));
		categoryMap.put("Footwear",
				new Category("105", "Footwear", categoryMap.get("Women's wear"), new Discount("107", "", "", 0)));

		return categoryMap;
	}

	/**
	 * @param product
	 * @return Max discount percentage applicable to the given product
	 */
	public static double getMaxDiscount(Product product) {

		double maxDiscountPercent = 0;
		maxDiscountPercent = product.getBrand().getDiscount().getValue();
		Category category = product.getCategory();

		int i = 0;
		while (category != null) {

			maxDiscountPercent = Math.max(maxDiscountPercent, category.getDiscount().getValue());
			category = category.getParentCategory();
		}

		return maxDiscountPercent;
	}

}
