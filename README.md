"# apparel_discount" 
@Author : Reju Pillai
@Email : reju.pillai@gmail.com

Coding Challenge : Apparel discount

Q :  How to run the applcation ?
A :  Run the DiscountMainApp  class 

Q :  How to provide inputs on STDIN ?
A : Example ( Note - There is no empty lines )

----------------------------------
5
1,Arrow,Shirts,800
2,Vero Moda,Dresses,1400
3,Provogue,Footwear,1800
4,Wrangler,Jeans,2200
5,UCB,Shirts,1500
2
1,2,3,4
1,5
---------------------------------


Q : Are there test cases included
A : Yes, Test cases for main Computating classes - DiscountMainAppTest and BusinessRulesTest are included.

Q : Is there a screenshots attached ?
A : Output of a sample run is captured in Results.PNG

Q : What are the main design features ?
A : 

- Modularization and Extensibility by defining some of the data in their respective Domain objects, even though it can be done without it.
- Category has ParentCategories,  The ParentCategory of ROOT Category is null
- The max discount logic is 

maxDiscountPercent = product.getBrand().getDiscount().getValue();
Category category = product.getCategory();
while (category != null) {

			maxDiscountPercent = Math.max(maxDiscountPercent, category.getDiscount().getValue());
			category = category.getParentCategory();
}


Q : How are Business rules loaded
A : Business Rules pertaining to Brand and Categories are stored in respective HashMaps and initialzied throuh a Static block of code.


Q : Is Exception handled ?
A : Handled for Input Validation and Choosing a non existing Product from the list of available Products

