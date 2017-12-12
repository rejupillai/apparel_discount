"# apparel_discount"  <br />
@Author : Reju Pillai <br />
@Email : reju.pillai@gmail.com <br />
<br /><br />
Coding Challenge : Apparel discount<br />
<br />
Q :  How to run the applcation ?<br />
A :  Run the DiscountMainApp  class <br />
<br />
Q :  How to provide inputs on STDIN ?<br />
A :  Please refer to the attached Results.PNG for the sample inouts Example ( Note - There is no empty lines )<br />
   <br />

Q : Is JavaDoc included ?<br />
A : Yes, pleaes see the index.html inside docs folder<br />

<br />
Q : Are there test cases included<br />
A : Yes, Test cases for main Computating classes - DiscountMainAppTest and BusinessRulesTest are included.<br />

<br />
Q : Is there a screenshots attached ?<br />
A : Output of a sample run is captured in Results.PNG<br />

<br />
Q : What are the main design features ?<br />
A : 
- Modularization and Extensibility by defining some of the data in their respective Domain objects, even though it can be done without it.
- Category has ParentCategories,  The ParentCategory of ROOT Category is null
- The max discount logic is <br />

maxDiscountPercent = product.getBrand().getDiscount().getValue();<br />
Category category = product.getCategory();<br />
while (category != null) {<br />
	maxDiscountPercent = Math.max(maxDiscountPercent, category.getDiscount().getValue());<br />
	category = category.getParentCategory();<br />
}<br />

<br />
Q : How are Business rules loaded<br />
A : Business Rules pertaining to Brand and Categories are stored in respective HashMaps and initialzied throuh a Static block of code.<br />

<br />
Q : Is Exception handled ? <br />
A : Handled for Input Validation and Choosing a non existing Product from the list of available Products<br />

