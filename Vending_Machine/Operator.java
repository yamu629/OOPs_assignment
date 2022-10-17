import java.util.*;
public class Operator {
	public static void main(String[] args) {
		showMainMenu();
		Scanner obj=new Scanner(System.in);
		int option=obj.nextInt();
		VendingMachine VM=new VendingMachine();
		Product p=new Product("Dummy");
		Cart cart=new Cart();
		while(option!=9) {
			if(option>9 || option<1) {
				System.out.println("Invalid Input");
				showMainMenu();
			}
			switch(option) {
			case 1:
				VM.showAllProducts();	
				break;
			case 2:
				//Assume product name is single string without spaces but separated by underscore 
				System.out.println("Enter name of product");
				String Name=obj.next();
				p=new Product(Name);
				System.out.println("Enter price of product");
				p.setPrice(obj.nextFloat());
				System.out.println("Enter count of product items");
				p.addCount(obj.nextInt());
				VM.addProduct(p);
				break;
			case 3:
				System.out.println("Enter choice");
				VM.ListAllProduct();
				int index=obj.nextInt()-1;
				VM.deleteProduct(VendingMachine.ProductList.get(index).getName());
				break;
			
				
						
			case 4:
				int option1=1;
				
				System.out.println("Choose product to add to cart");
				VM.ListAllProduct();
				index=obj.nextInt()-1;
				List<Product> AddProduct=new ArrayList<Product>();
				p=new Product(VendingMachine.ProductList.get(index));
				p.setCount(1);
				AddProduct.add(p);
				System.out.println("Add more?\n1. Yes\n2. No");
				option1=obj.nextInt();
				while(option1==1) {	
					VM.ListAllProduct();
					index=obj.nextInt()-1;
					p=new Product(VendingMachine.ProductList.get(index));
					p.setCount(1);
					AddProduct.add(p);
					System.out.println("Add more?\n1. Yes\n2. No");
					option1=obj.nextInt();
				}
				if (option1==2) {
					cart.add(AddProduct);
					cart.ListCart();
			
				}
				else{
					System.out.println("Invalid Input");
					cart.add(AddProduct);
					cart.ListCart();
					}
				break;
			case 5:
				option1=1;
				
				System.out.println("Choose product to delete from cart");
				VM.ListAllProduct();
				index=obj.nextInt()-1;
				List<Product> DeleteProduct=new ArrayList<Product>(); 
				p=new Product(VendingMachine.ProductList.get(index));
				DeleteProduct.add(p);
				System.out.println("Delete more?\n1. Yes\n2. No");
				option1=obj.nextInt();
				while(option1==1) {	
					VM.ListAllProduct();
					index=obj.nextInt()-1;
					p=new Product(VendingMachine.ProductList.get(index));
					DeleteProduct.add(p);
					System.out.println("Delete more?\n1. Yes\n2. No");
					option1=obj.nextInt();
				}
				if (option1==2) {
					cart.delete(DeleteProduct);
					cart.ListCart();
				}
				else{
					System.out.println("Invalid Input");
					cart.delete(DeleteProduct);
					cart.ListCart();
				}
				break;
			case 6:
				cart.ListCart();
				break;
			case 7:
				System.out.println("Are you sure you want to checkout the cart?\n1. Yes\n2. No");
				option1=obj.nextInt();
				if(option1==1) {
					if(!cart.isEmpty()) {
						cart.showBill();
						float total=cart.getTotalPrice();
						if(!cart.isEmpty()) {
							System.out.println("How would you like to pay?\n1. Card\n2. Cash");
							int option2=obj.nextInt();
							if(option2==1) {
								cart.setPayment("Card");
								total=cart.getTotalPrice();
								System.out.println("Total is updated as Rs."+total+". Do you agree to pay?\n1. Yes\n2. No");
								int option3=obj.nextInt();
								if(option3==1) {
									VM.dispatchProducts(cart);
									cart.EmptyCart();
									System.out.println("Cart products are disbursed. Kindly pay at counter and collect the items. ");
								}
								else if(option3!=2) {
									System.out.println("Invalid Input");
								}
								else {
									cart.EmptyCart();
									System.out.println("Customer not agreed to pay.");
									if(cart.isEmpty()==true) {
										System.out.println("Cart emptied.");
									}
								}
							}
							else if (option2==2) {
								VM.dispatchProducts(cart);
								cart.EmptyCart();
								System.out.println("Cart products are disbursed. Kindly pay at counter and collect the items. ");
							}
							else {
								System.out.println("Invalid Input");
							}
						}
						
					}
				}
				break;
			case 8:
				cart.EmptyCart();
				break;
				
			}
			showMainMenu();
			option=obj.nextInt();
		
		}
		obj.close();
	}
	public static void showMainMenu() {
		System.out.println("************Menu**************\n1. View Products in vending machine\n2. Add Product info to Vending Machine");
		System.out.println("3. Delete Product info from Vendor Machine");
		System.out.println("4. Add Product to Cart\n5. Remove Product from Cart\n6. View cart");
		System.out.println("7. Checkout cart products and pay\n8. Empty Cart\n9. Exit");
	}
	
}
