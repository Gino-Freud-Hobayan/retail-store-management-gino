// Gino H. Retail Store Management System

// Gino Freud D. Hobayan

// Computer Programming 1 - Java




import java.util.ArrayList;
import java.util.Scanner;


class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    
    //Constructors
    public Customer() {
        //this part should be empty
    }

    public Customer(String name, String email, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    


    // Accessors - get
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    


    // Mutators - set
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}       // end of class customer






class Order {
    private ArrayList<Product> cartItems = new ArrayList<Product>();
    private float grandTotal = 0;
    private String paymentMethod;
    private String paymentAccountNumber;
    private String paymentAccountName;
    private String shippingMethod;
    
    public void addToCart(Product product) {
        this.grandTotal += product.getUnitPrice() * product.getQuantity();
        cartItems.add(product);
    }
    
    public ArrayList<Product> getCartList() {
        return this.cartItems;
    }

    public float getGrandTotal() {
        return grandTotal;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public void setPaymentMethod(int paymentMethod) {
        switch (paymentMethod) {
            case 1:
                this.paymentMethod = "COD";
                break;
            case 2:
                this.paymentMethod = "GCASH";
                break;
            case 3:
                this.paymentMethod = "BANK_TRANSFER";
                break;
            default:
                this.paymentMethod = "Unknown";
                break;
        }
    }
    
    public String getShippingMethod() {
        return shippingMethod;
    }
    
    public void setShippingMethod(int shippingMethod) {
        switch (shippingMethod) {
            case 1:
                this.shippingMethod = "DOOR_TO_DOOR";
                break;
            case 2:
                this.shippingMethod = "PICK_UP";
                break;
            default:
                this.shippingMethod = "Unknown";
                break;
        }
    }

    public String getPaymentAccountNumber() {
        return paymentAccountNumber;
    }

    public void setPaymentAccountNumber(String paymentAccountNumber) {
        this.paymentAccountNumber = paymentAccountNumber;
    }
    
    public String getPaymentAccountName() {
        return paymentAccountName;
    }

    public void setPaymentAccountName(String paymentAccountName) {
        this.paymentAccountName = paymentAccountName;
    }
}






class Inventory {
    ArrayList<Product> products = new ArrayList<Product>();
    
    public ArrayList<Product> getInventory() {
        return this.products;
    }
    
    public Product getItem(int id) {
        Product foundItem = null;
        
        for (Product item: products) {
            if (item.getId() == id) {    // Use the public key (getter)
                foundItem = item;
                break;
            }
        }
        
        return foundItem;
    }
    
    public void setProduct(Product product) {
        this.products.add(product);
    }
}





class Product {
    private static int ctr = 1;
    private int id;
    private String productName;
    private float unitPrice;
    private int quantity;
    
    //Constructors
    public Product() {
        //empty
    }
    
    public Product(String productName, float unitPrice, int quantity) {
        this.id = ctr++;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    


    // New Copy Constructor: Creates a new Product based on an existing one
    public Product(Product original, int orderedQuantity) {
        this.id = original.id;
        this.productName = original.productName;
        this.unitPrice = original.unitPrice;

        // The quantity in the cart is the ordered quantity, NOT the stock.
        this.quantity = orderedQuantity; 
    }



    // New constructor to manually set ID for initialization
    public Product(int id, String productName, float unitPrice, int quantity) {
        this.id = id;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        // Optionally update the counter if this ID is higher than the current counter
        if (id >= ctr) {
            ctr = id + 1;
        }
    }



    //Accessors - get
    public int getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }
    public float getUnitPrice() {
        return unitPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    
    //Mutators - set
    public void setId(int id) {
        this.id = id;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}








// <----------- Main -------------> //


class Main {
    private static Inventory inventory = new Inventory();
    private static Order order = new Order();
    private static Customer customer = new Customer();
    


static void InitializeProductList() {

    // Product(ID, Name, Price, Stock)
    inventory.setProduct(new Product(1, "Keyboard", 500.00f, 5));
    inventory.setProduct(new Product(2, "Mouse", 200.00f, 10));
    inventory.setProduct(new Product(3, "Headphones", 850.00f, 7));
    inventory.setProduct(new Product(4, "USB Flash Drive (32GB)", 350.00f, 15));
    inventory.setProduct(new Product(5, "Monitor (24 inch)", 7500.00f, 3));
    inventory.setProduct(new Product(6, "Laptop", 40000.00f, 6));
    inventory.setProduct(new Product(7, "Power Bank (10,000mAh)", 900.00f, 12));
    inventory.setProduct(new Product(8, "HDMI Cable", 150.00f, 20));
    inventory.setProduct(new Product(9, "Gabe Cube: Steam Machine (Computer)", 50000.00f, 5));
}



    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    static void renderMenu() {
        System.out.println("===========================================================");
        System.out.println("\tGino H. Retail Store Management System\t");
        System.out.println("===========================================================\n");
        System.out.println("\tSelect from menu:");
        System.out.println("\t1. Purchase Order");
        System.out.println("\t2. Manage Inventory");
        System.out.println("\t3. Exit\n");
        System.out.print("\tEnter your choice: ");
    }
    
    static void displayInventory() {
        ArrayList<Product> products = inventory.getInventory();
        System.out.println("\tView the List of Products:");
        for (Product item: products) {
            System.out.println("\t" + item.getId() + ". " + item.getProductName() + " - price: " + item.getUnitPrice() + ", stock: " + item.getQuantity());
        }
    }

    static void displayCartItems() {
        ArrayList<Product> cartItems = order.getCartList();
        System.out.println("\tItems in Cart:");
        for (Product item: cartItems) {
            System.out.println("\t[x] " + item.getProductName() + " - unit price: " + item.getUnitPrice() 
                + ", qty: " + item.getQuantity() + ", total: " 
                + (item.getUnitPrice() * item.getQuantity()));
        }
        System.out.println("\tGrand Total: " + order.getGrandTotal());
    }



    static void inputCustomerInformation(Scanner scanner) {
        scanner.nextLine(); // Consume leftover newline
        System.out.println("===========================================================");
        System.out.println("\tPurchase Order\t");
        System.out.println("===========================================================\n");

        System.out.println("\tCustomer Information:");

        System.out.print("\tEnter Name: ");
        customer.setName(scanner.nextLine());

        System.out.print("\tEnter Email: ");
        customer.setEmail(scanner.nextLine());

        System.out.print("\tEnter Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());

        System.out.print("\tEnter Address: ");
        customer.setAddress(scanner.nextLine());

        System.out.print("\tSelect Payment Method: \n");
        System.out.print("\t\t1. Cash on Delivery\n\t\t2. GCash\n\t\t3. Bank Transfer\n\t\tEnter Choice: ");

        // Define and use paymentChoice here
        int paymentChoice = scanner.nextInt(); 
        order.setPaymentMethod(paymentChoice);


        if (paymentChoice == 2 || paymentChoice == 3) {
        scanner.nextLine(); // Consume newline after int input
        System.out.print("\n\t\tEnter Bank/GCash Account Number: ");
        order.setPaymentAccountNumber(scanner.nextLine());
        System.out.print("\n\t\tEnter Account Name: ");
        order.setPaymentAccountName(scanner.nextLine());
        } else {
        // Clear fields if COD is selected
        order.setPaymentAccountNumber("N/A (COD)");
        order.setPaymentAccountName("N/A (COD)");
        scanner.nextLine();  // Consume leftover newline from nextInt() before shipping
        }


/* 
        scanner.nextLine(); // Consume newline after int input
        System.out.print("\n\t\tEnter Bank/GCash Account Number: ");
        order.setPaymentAccountNumber(scanner.nextLine());

        System.out.print("\n\t\tEnter Account Name: ");
        order.setPaymentAccountName(scanner.nextLine());
*/


        System.out.print("\tSelect Shipping Method: \n");
        System.out.print("\t\t1. Door to Door\n\t\t2. Pick Up\n\t\tEnter Choice: ");
        order.setShippingMethod(scanner.nextInt());
    }


    
    static char displayConfirmation(Scanner scanner) {
        clearScreen();
        System.out.println("===========================================================");
        System.out.println("\tOrder Confirmation\t");
        System.out.println("===========================================================\n");
        System.out.println("\tCustomer Information:");
        System.out.println("\tName: " + customer.getName());
        System.out.println("\tEmail: " + customer.getEmail());
        System.out.println("\tPhone Number: " + customer.getPhoneNumber());
        System.out.println("\tAddress: " + customer.getAddress() + "\n");

        displayCartItems();

        System.out.println("\n\tPayment Method: " + order.getPaymentMethod());
        System.out.println("\tAccount Number: " + order.getPaymentAccountNumber());
        System.out.println("\tAccount Name: " + order.getPaymentAccountName() + "\n");

        System.out.println("\tShipping Method: " + order.getShippingMethod());

        System.out.print("\n\tCustomer Information confirmed? (y/n): ");
        char confirm = scanner.next().charAt(0);

        if (confirm == 'y' || confirm == 'Y') {
            System.out.print("\n\tProcessing your order");
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\n\tPayment Confirmed!");
            System.out.print("\n\tProcessing Order");
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\n\tOrder Successfully Placed!");
        } else {
            System.out.println("\n\tOrder cancelled. Returning to main menu...");
        }
        System.out.println("\n\tThank you for your purchase!\n");
        return confirm;
    }




static void addItemToCart(Scanner scanner) {
    char moreChoice = 'n';
    do {
        clearScreen();
        System.out.println("===========================================================");
        System.out.println("\tPurchase Order\t");
        System.out.println("===========================================================\n");

        if (order.getCartList().size() > 0) {
            displayCartItems();
            System.out.println("\n===========================================================\n");
        }
        displayInventory();

        System.out.print("\n\tSelect product to add: ");
        int prodChoice = scanner.nextInt();
        System.out.print("\n\tEnter quantity: ");
        int qtyChoice = scanner.nextInt();
        

        // 1. Get the ORIGINAL product from inventory
        Product inventoryProduct = inventory.getItem(prodChoice);
        
        if (inventoryProduct == null) {
            System.out.println("\n\tInvalid product ID. Please try again.");
            // Set moreChoice to 'y' to prompt for another item instead of proceeding
            moreChoice = 'y'; 
            continue; 
        }
        

        // 2. Check for sufficient stock
        if (qtyChoice > inventoryProduct.getQuantity()) {
            System.out.println("\n\tError: Only " + inventoryProduct.getQuantity() + " units available. Please order a smaller quantity.");
            // Set moreChoice to 'y' to keep the ordering process going
            moreChoice = 'y'; 
            continue;
        }


        // 3. Deduct the quantity from the INVENTORY stock
        int newStock = inventoryProduct.getQuantity() - qtyChoice;
        inventoryProduct.setQuantity(newStock); 


        // 4. Create a NEW Product object for the cart using the copy constructor
        Product cartItem = new Product(inventoryProduct, qtyChoice);


        // 5. Add the NEW cart item to the order
        order.addToCart(cartItem); 


        System.out.print("\n\tAdd more? (y/n): ");
        moreChoice = scanner.next().charAt(0);
        
    } while (moreChoice == 'y' || moreChoice == 'Y');
}





    static void clearOrderDetails() {
        order = new Order();
        customer = new Customer();
    }
    






//     2. Inventory Management       //


    static void inventoryMenu(Scanner scanner) {
        int choice = 0;
        do {
            clearScreen();
            System.out.println("===========================================================");
            System.out.println("\tManage Inventory System\t");
            System.out.println("===========================================================\n");
            System.out.println("\t1. View the Product List");
            System.out.println("\t2. Add New Product");
            System.out.println("\t3. Adjust Product (Edit/Restock)");
            System.out.println("\t4. Back to Main Menu\n");
            System.out.print("\tEnter your choice: ");
            
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    clearScreen();
                    System.out.println("===========================================================");
                    System.out.println("\tCurrent Inventory List\t");
                    System.out.println("===========================================================\n");
                    displayInventory();
                    System.out.print("\n\tPress Enter to continue...");
                    scanner.nextLine();  // Consume newline
                    scanner.nextLine(); // Wait for enter
                    break;
                case 2:
                    addProductUI(scanner);
                    break;
                case 3:
                    adjustProductUI(scanner);
                    break;
                case 4:
                    // Loop back to main
                    break;
                default:
                    System.out.println("\tInvalid choice.");
            }
        } while (choice != 4);
    }


    static void addProductUI(Scanner scanner) {
        scanner.nextLine(); // Consume leftover newline
        clearScreen();
        System.out.println("===========================================================");
        System.out.println("\tAdd New Product\t");
        System.out.println("===========================================================\n");

        System.out.print("\tEnter Product Name: ");
        String newName = scanner.nextLine();

        System.out.print("\tEnter Unit Price: ");
        float newPrice = scanner.nextFloat();

        System.out.print("\tEnter Initial Quantity: ");
        int newQty = scanner.nextInt();


        // Create the product (ID is auto generated by Product constructor)
        Product newProd = new Product(newName, newPrice, newQty);
        inventory.setProduct(newProd);

        System.out.println("\n\tSuccess! Item added with ID: " + newProd.getId());
        System.out.print("\tPress Enter to continue...");
        scanner.nextLine(); // Consume newline
        scanner.nextLine(); // Wait
    }


    static void adjustProductUI(Scanner scanner) {
        clearScreen();
        System.out.println("===========================================================");
        System.out.println("\tAdjust Existing Product\t");
        System.out.println("===========================================================\n");
        
        // Show list so user knows the ID
        displayInventory();
        
        System.out.print("\n\tEnter ID of product to adjust: ");
        int searchId = scanner.nextInt();

        Product item = inventory.getItem(searchId);

        if (item == null) {
            System.out.println("\n\tError: Product with ID " + searchId + " not found.");
            System.out.print("\tPress Enter to return...");
            scanner.nextLine(); 
            scanner.nextLine();
            return;
        }


        System.out.println("\n\tSelected: " + item.getProductName());
        System.out.println("\t1. Update Price");
        System.out.println("\t2. Restock / Adjust Quantity");
        System.out.println("\t3. Cancel");
        System.out.print("\tChoose action: ");
        int adjustChoice = scanner.nextInt();


        switch(adjustChoice) {
            case 1:
                System.out.println("\tCurrent Price: " + item.getUnitPrice());
                System.out.print("\tEnter New Price: ");
                float newPrice = scanner.nextFloat();
                item.setUnitPrice(newPrice);
                System.out.println("\tPrice updated successfully.");
                break;
            case 2:
                System.out.println("\tCurrent Stock: " + item.getQuantity());
                System.out.print("\tEnter New Total Quantity: ");
                int newQty = scanner.nextInt();
                // Ensure no negative stock
                if(newQty < 0) newQty = 0; 
                item.setQuantity(newQty);
                System.out.println("\tQuantity updated successfully.");
                break;
            default:
                System.out.println("\tAdjustment cancelled.");
                break;
        }

        System.out.print("\n\tPress Enter to continue...");
        scanner.nextLine(); // Consume newline
        scanner.nextLine(); // Wait
    }





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        InitializeProductList();
        
        do {
            renderMenu();
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    char orderChoice = 'n';
                    do {
                        addItemToCart(scanner);
                        clearScreen();
                        inputCustomerInformation(scanner);
                        orderChoice = displayConfirmation(scanner);
                        clearOrderDetails();
                    } while (orderChoice == 'n' || orderChoice == 'N');
                    break;

                case 2:
                    // This calls the Inventory Management
                    inventoryMenu(scanner);
                    break;

                case 3:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();


    }
}


