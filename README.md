# Retail Store Management System

### CIIT - Computer Programming 1 (CS102 - 3)


### Professor: Roberto Asino


### Student Name: Gino Freud D. Hobayan


### Section: Tech 01


<br><br>





Hi!
I'm <b> Gino Freud D. Hobayan </b> , a first year computer science student at CIIT College of Arts and Technology.



I created the <b> "Gino H. Retail Store Management System" </b> using the Java programming language

I was able to learn a lot about the Java Programming Language while making this project and that makes me proud as I am able to add the Java Programming Language to my Tech Stack,
and hopefully I can use my knowledge on this tool to solve various problems in the near future.

<br>


My Project simulates a Retail Store Management System with the following:
- Products
- Orders
- Inventory
- Cart system
- Payment & shipping options
- Confirmation screen with loading animation




<br><br>
<br><br>







## Inventory

This includes all the products in my Retail Store.

<br>


<b> List of Products: </b>


| ID | Product Name                           | Price (PHP) | Stock |
|----|----------------------------------------|-------------|-------|
| 1  | Keyboard                               | 500         | 5     |
| 2  | Mouse                                  | 200         | 10    |
| 3  | Headphones                             | 850         | 7     |
| 4  | USB Flash Drive (32GB)                 | 350         | 15    |
| 5  | Monitor (24 inch)                      | 7,500       | 3     |
| 6  | Laptop                                 | 40,000      | 6     |
| 7  | Power Bank (10,000mAh)                 | 900         | 12    |
| 8  | HDMI Cable                             | 150         | 20    |
| 9  | Gabe Cube: Steam Machine (Computer)    | 50,000      | 5     |






<br><br>
<br><br>
<br><br>




## Sample Program flow:


Sample program flow for: Purchase Order


<details>
  <summary>Click to view</summary>

<br>


```

=============================================
    Gino H. Retail Store Management System
=============================================
1. Purchase Order
2. Manage Inventory
3. Exit
Enter choice: 1



List of Products:
1. Keyboard - price: 500, stock: 5
2. Mouse - price: 200, stock: 10
...


Select Product ID: 5
Enter Quantity: 1
Add more? (y/n): n



Enter Name: John Doe
Enter Email: john@example.com
Enter Phone Number: 09171234567
Enter Address: 123 Street, City
Payment Method (1=COD,2=GCash,3=Bank): 1
Shipping Method (1=Door-to-Door,2=Pick-up): 1



Order Confirmation:
Customer Name: John Doe
Grand Total: 7500
Payment Method: COD
Shipping: DOOR_TO_DOOR
Order Successfully Placed!


```


</details>




<br><br><br>




Sample program flow for: Inventory Management

<details>
  <summary>Click to view</summary>

<br>


```
===========================================================
	Gino H. Retail Store Management System	
===========================================================

	Select from menu:
	1. Purchase Order
	2. Manage Inventory
	3. Exit

	Enter your choice: 2



===========================================================
	Manage Inventory System	
===========================================================

	1. List Products
	2. Add New Product
	3. Adjust Product (Edit/Restock)
	4. Back to Main Menu

	Enter your choice: 1



===========================================================
	Current Inventory List	
===========================================================

	List of Products:
	1. Keyboard - price: 500.0, stock: 5
	2. Mouse - price: 200.0, stock: 10
	3. Headphones - price: 850.0, stock: 7
	... (rest of items) ...
	9. Gabe Cube: Steam Machine (Computer) - price: 50000.0, stock: 5

	Press Enter to continue...




===========================================================
	Manage Inventory System	
===========================================================

	1. List Products
	2. Add New Product
	3. Adjust Product (Edit/Restock)
	4. Back to Main Menu

	Enter your choice: 2


===========================================================
	Add New Product	
===========================================================

	Enter Product Name: sample product..1
	Enter Unit Price: 8500
	Enter Initial Quantity: 10

	Success! Item added with ID: 10
	Press Enter to continue...




===========================================================
	Manage Inventory System	
===========================================================

	1. List Products
	2. Add New Product
	3. Adjust Product (Edit/Restock)
	4. Back to Main Menu

	Enter your choice: 3




===========================================================
	Adjust Existing Product	
===========================================================

	List of Products:
	1. Keyboard - price: 500.0, stock: 5
    ...
	10. sample..product 1 - price: 8500.0, stock: 10

	Enter ID of product to adjust: 1

	Selected: Keyboard
	1. Update Price
	2. Restock / Adjust Quantity
	3. Cancel
	Choose action: 2

	Current Stock: 5
	Enter New Total Quantity: 50
	Quantity updated successfully.

	Press Enter to continue...





===========================================================
	Manage Inventory System	
===========================================================

	1. List Products
	2. Add New Product
	3. Adjust Product (Edit/Restock)
	4. Back to Main Menu

	Enter your choice: 4






===========================================================
	Gino H. Retail Store Management System	
===========================================================

	Select from menu:
	1. Purchase Order
	2. Manage Inventory
	3. Exit

	Enter your choice:



```




</details>








<br><br>
<br><br>


<br><br>
<br><br>




# Code Highlights:


There were a few notable parts of the code that stood out to me, that's why I'm highlighting some of them here:


<br><br><br>



## Objected Oriented Programming (OOP)

<h3> I was able to organize my code into real world objects using "Classes" and "Objects" </h3>
<br>

1.) Separate Classes for Customer, Product, Order, and Inventory.

<br><br>

  
2.) Copy Constructor

Smart Object Copying

There's a logic in the Product class to handle adding items to the cart. 
<br>
When a user adds an item, the program doesn't just point to the inventory. 
<br>
It creates a fresh copy of that product using a custom constructor: new Product(inventoryProduct, qty).

<br>

This ensures that changing the quantity in the cart doesn't accidentally mess up the main stock in the inventory.

<br>


```java

// 1. The Logic (Inside Product.java)

// "Copy Constructor" to clone an item while setting a specific order quantity

public Product(Product original, int orderedQuantity) {
    this.id = original.id;
    this.productName = original.productName;
    this.unitPrice = original.unitPrice;
    this.quantity = orderedQuantity; // Uses the user's order amount, not the total stock
}



// 2. The Implementation (Inside Main.java)

// instead of pointing to the inventory item directly, I create a new independent object
Product cartItem = new Product(inventoryProduct, qtyChoice);
order.addToCart(cartItem);

```







<br><br><br>



## Thread.sleep(1000)

Using the "Thread.sleep(1000)" to slow down the release of the result by 1000 miliseconds or 1 second.
<br>
It was my first time learning about something like this, 
<br>
delaying the result to make the program seem more realistic, like it's actually loading.


```java

        if (confirm == 'y' || confirm == 'Y') {
            System.out.print("\n\tProcessing your order");
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }




```







