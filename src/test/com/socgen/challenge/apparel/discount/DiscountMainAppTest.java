package test.com.socgen.challenge.apparel.discount;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.socgen.challenge.apparel.discount.BusinessRules;
import com.socgen.challenge.apparel.discount.DiscountMainApp;
import com.socgen.challenge.apparel.domain.Brand;
import com.socgen.challenge.apparel.domain.Category;
import com.socgen.challenge.apparel.domain.Discount;
import com.socgen.challenge.apparel.domain.Product;

public class DiscountMainAppTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		BusinessRules.loadBrands();
		BusinessRules.loadCategories();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.socgen.challenge.apparel.discount.BusinessRules#getMaxDiscount(com.socgen.challenge.apparel.domain.Product)}
	 * .
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testDiscountPrice1() {
		// 4 | Wrangler | Jeans | 2200 |

		Product product = new Product();
		String id = "1";
		Brand brand = new Brand("1", new Discount("1", "", "", 0.1), "Wrangler");
		Category category = new Category("103", "Jeans", BusinessRules.getCategoryMap().get("Men's wear"),
				new Discount("105", "", "", 0.2));
		double price = 2200;

		product.setId(id);
		product.setCategory(category);
		product.setBrand(brand);
		product.setPrice(price);

		DiscountMainApp app = new DiscountMainApp();

		Product[] chosenProducts = new Product[1];
		chosenProducts[0] = product;

		assertEquals(1760, app.calculateDiscountedPrice(chosenProducts), 0.0);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDiscountPrice2() {
		// 1 | Arrow | Shirts | 800 |

		Product product = new Product();
		String id = "1";
		Brand brand = new Brand("2", new Discount("2", "", "", 0.2), "Arrow");
		Category category = new Category("100", "Shirts", BusinessRules.getCategoryMap().get("Men's wear"),
				new Discount("102", "", "", 0));
		double price = 800;

		product.setId(id);
		product.setCategory(category);
		product.setBrand(brand);
		product.setPrice(price);

		DiscountMainApp app = new DiscountMainApp();

		Product[] chosenProducts = new Product[1];
		chosenProducts[0] = product;

		assertEquals(640, app.calculateDiscountedPrice(chosenProducts), 0.0);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDiscountPrice3() {
		// 3 | Provogue | Footwear | 1800 |
		Product product = new Product();
		String id = "1";
		Brand brand = new Brand("6", new Discount("6", "", "", 0.1), "Provogue");
		Category category = new Category("105", "Footwear", BusinessRules.getCategoryMap().get("Women's wear"),
				new Discount("107", "", "", 0.5));
		double price = 1800;

		product.setId(id);
		product.setCategory(category);
		product.setBrand(brand);
		product.setPrice(price);

		DiscountMainApp app = new DiscountMainApp();

		Product[] chosenProducts = new Product[1];
		chosenProducts[0] = product;

		assertEquals(900, app.calculateDiscountedPrice(chosenProducts), 0.0);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDiscountPrice4() {
		// 3 | Provogue | Footwear | 1800 |
		Product product = new Product();
		String id = "1";
		Brand brand = new Brand("6", new Discount("6", "", "", 0.1), "Provogue");
		Category category = new Category("105", "Footwear", BusinessRules.getCategoryMap().get("Women's wear"),
				new Discount("107", "", "", 0.5));
		double price = 1800;

		product.setId(id);
		product.setCategory(category);
		product.setBrand(brand);
		product.setPrice(price);
		DiscountMainApp app = new DiscountMainApp();
		Product[] chosenProducts = new Product[2];
		chosenProducts[0] = product;
		product = new Product();
		id = "1";
		brand = new Brand("2", new Discount("2", "", "", 0.2), "Arrow");
		category = new Category("100", "Shirts", BusinessRules.getCategoryMap().get("Men's wear"),
				new Discount("102", "", "", 0));
		price = 800;
		product.setId(id);
		product.setCategory(category);
		product.setBrand(brand);
		product.setPrice(price);
		chosenProducts[1] = product;
		assertEquals(1540, app.calculateDiscountedPrice(chosenProducts), 0.0);

	}

}
