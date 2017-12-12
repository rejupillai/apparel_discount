package com.socgen.challenge.apparel.discount;

import com.socgen.challenge.apparel.domain.Product;
import com.socgen.challenge.apparel.exception.ValidationException;;

/**
 * @author reju.pillai@gmail.com Common utilities for general purposes
 *
 */
public class DiscountUtility {

	public static String[] splitToken(String in) throws ValidationException {
		if (in != null) {
			String splits[] = in.split(Constants.INPUT_TOKENIZER);
			// print(splits);
			return splits;
		}

		else
			throw new ValidationException("Input is null");

	}

	public static void print(String splits[]) {

		for (int i = 0; i < splits.length; i++)
			System.out.println(splits[i]);
	}

}
