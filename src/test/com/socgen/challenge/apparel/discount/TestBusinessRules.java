/**
 * 
 */
package test.com.socgen.challenge.apparel.discount;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.socgen.challenge.apparel.discount.BusinessRules;
import com.socgen.challenge.apparel.domain.Brand;
import com.socgen.challenge.apparel.domain.Category;
import com.socgen.challenge.apparel.domain.Discount;
import com.socgen.challenge.apparel.domain.Product;

/**
 * @author reju.pillai@gmail.com
 *
 */
public class TestBusinessRules {

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
	public void testGetMaxDiscountForBrand() {
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

		assertEquals(0.2, BusinessRules.getMaxDiscount(product), 0.0);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetMaxDiscountForCategory() {
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

		assertEquals(0.2, BusinessRules.getMaxDiscount(product), 0.0);

	}

	@SuppressWarnings("deprecation")
	@Test
	public  void testGetMaxDiscountForAnsestorCategory() {
		// 3 | Provogue | Footwear | 1800 |
		Product product = new Product();
		String id = "1";
		Brand brand = new Brand("6", new Discount("6", "", "", 0.1), "Provogue");
		Category category = new Category("105", "Footwear", BusinessRules.getCategoryMap().get("Women's wear"),
				new Discount("107", "", "", 0.3));
		double price = 1800;

		product.setId(id);
		product.setCategory(category);
		product.setBrand(brand);
		product.setPrice(price);

		 assertEquals(0.5, BusinessRules.getMaxDiscount(product), 0.0);

		//System.out.println(BusinessRules.getMaxDiscount(product));

	}


}
