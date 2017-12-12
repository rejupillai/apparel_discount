package com.socgen.challenge.apparel.discount;

import java.util.Scanner;

import com.socgen.challenge.apparel.domain.Brand;
import com.socgen.challenge.apparel.domain.Category;
import com.socgen.challenge.apparel.domain.Inventory;
import com.socgen.challenge.apparel.domain.Product;
import com.socgen.challenge.apparel.exception.GenericException;
import com.socgen.challenge.apparel.exception.ValidationException;

/**
 * @author reju.pillai@gmail.com
 * 
 *         This class is responsible to process input from StdIn, calculate
 *         discount on the chosen products and show discounted price on stdOut.
 *
 */

public class DiscountMainApp {

	static {

		BusinessRules.loadBrands();
		BusinessRules.loadCategories();
	}

	public static void main(String argsp[]) throws GenericException {

		DiscountMainApp app = new DiscountMainApp();
		app.processInput();

	}

	/**
	 * process input data from stdIn
	 */
	public void processInput() throws GenericException {

		Scanner scan = new Scanner(System.in);

		// Scan inputs for Inventory
		int availableProductCount = Integer.parseInt(scan.nextLine());
		if (availableProductCount <= 0) {
			throw new ValidationException("Inventory is empty");
		}

		String availableProductDetails[] = new String[availableProductCount];
		for (int i = 0; i < availableProductCount; i++) {
			availableProductDetails[i] = scan.nextLine();
			// DiscountUtility.splitToken(availableProductDetails[i]);
		}

		// Scan inputs for Chosen products
		int chosenCount = Integer.parseInt(scan.nextLine());
		if (chosenCount <= 0) {
			throw new ValidationException("No product is chosen");
		}

		String[] chosenProductDetails = new String[chosenCount];

		for (int i = 0; i < chosenCount; i++) {
			chosenProductDetails[i] = scan.nextLine();
		}

		Inventory it = initInventory(availableProductDetails);
		double[] discountedPrice = chooseFromInventory(it, chosenProductDetails);
		processOutput(discountedPrice);

	}

	/**
	 * @return Inventory
	 * @throws GenericException
	 */
	public Inventory initInventory(String[] availableProductDetails) throws GenericException {

		String scannedProduct[];
		Product availableProducts[] = new Product[availableProductDetails.length];
		for (int i = 0; i < availableProductDetails.length; i++) {
			scannedProduct = DiscountUtility.splitToken(availableProductDetails[i]);
			availableProducts[i] = new Product();
			availableProducts[i].setId(scannedProduct[0]);
			availableProducts[i].setBrand(BusinessRules.getBrandMap().get(scannedProduct[1]));
			availableProducts[i].setCategory(BusinessRules.getCategoryMap().get(scannedProduct[2]));
			availableProducts[i].setPrice(Double.parseDouble(scannedProduct[3]));

		}

		Inventory it = new Inventory(availableProducts);
		return it;

	}

	/**
	 * @param it
	 *            - Inventory of available products to choose from
	 * @param chosenProductDetails
	 *            - Scanned Ids of chosen products
	 * @return Discounted price of the product
	 * @throws GenericException
	 */
	private double[] chooseFromInventory(Inventory it, String[] chosenProductDetails) throws GenericException {
		String chosenProductIds[];
		Product chosenProducts[];
		double discountPrice[] = new double[chosenProductDetails.length];
		for (int i = 0; i < chosenProductDetails.length; i++) {
			chosenProductIds = DiscountUtility.splitToken(chosenProductDetails[i]);
			chosenProducts = it.getProductsByIds(chosenProductIds);
			discountPrice[i] = calculateDiscountedPrice(chosenProducts);

		}

		return discountPrice;
	}

	/**
	 * @return calculate price of products chosen in one set ( multiple products
	 *         )
	 */
	public double calculateDiscountedPrice(Product[] chosenProducts) {
		double priceOfChosenProducts = 0.0;
		double discountPercent = 0.0;
		for (int i = 0; i < chosenProducts.length; i++) {
			discountPercent = BusinessRules.getMaxDiscount(chosenProducts[i]);
			chosenProducts[i].setDiscountedPrice((1 - discountPercent) * chosenProducts[i].getPrice());
			priceOfChosenProducts += chosenProducts[i].getDiscountedPrice();
			
		}

		return priceOfChosenProducts;
	}

	/**
	 * show output on stdout
	 */
	public void processOutput(double[] discountedPrice) {

		for (int i = 0; i < discountedPrice.length; i++)
			System.out.println(discountedPrice[i]);

	}

}
