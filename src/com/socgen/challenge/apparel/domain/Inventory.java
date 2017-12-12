package com.socgen.challenge.apparel.domain;

import com.socgen.challenge.apparel.exception.GenericException;

/**
 * @author reju.pillai@gmail.com
 * 
 *         This class represent the Inventory domain which is a collection of
 *         available and chosen products.
 */
public class Inventory {

	/**
	 * List of products in inventory
	 */
	private Product avaiableProducts[];
	private Product chosenProducts[];

	public Product[] getAvaiableProducts() {
		return avaiableProducts;
	}

	/**
	 * @param avaiableProducts
	 *            List of all available products in inventory
	 */
	public void setavaiableProducts(Product[] avaiableProducts) {
		this.avaiableProducts = avaiableProducts;
	}

	/**
	 * @return
	 */
	public Product[] getChosenProducts() {
		return chosenProducts;
	}

	public Inventory(Product[] avaiableProducts) {
		super();
		this.avaiableProducts = avaiableProducts;
	}

	public Inventory(Product[] avaiableProducts, Product[] chosenProducts) {
		super();
		this.avaiableProducts = avaiableProducts;
		this.chosenProducts = chosenProducts;
	}

	/**
	 * @param chosenProducts
	 *            list of chosen products from the inventory
	 */
	public void setChosenProducts(Product[] chosenProducts) {
		this.chosenProducts = chosenProducts;
	}

	/**
	 * @param productIds
	 * @return
	 */
	public Product[] getProductsByIds(String[] productIds) throws GenericException {

		Product chosenProducts[] = null;
		if (productIds != null && productIds.length != 0) {
			chosenProducts = new Product[productIds.length];
		}

		Product availableProducts[] = getAvaiableProducts();

		for (int i = 0; i < productIds.length; i++) {
			boolean flag = false;

			for (int j = 0; j < availableProducts.length; j++)
				if (productIds[i].equals(availableProducts[j].getId())) {
					chosenProducts[i] = availableProducts[j];
					flag = true;
				}

			if (!flag)
				throw new GenericException(
						"There is no available product corresponding to the product id " + productIds[i]);

		}

		return chosenProducts;
	}

}
