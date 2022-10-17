import java.util.*;

public class Cart {
	List<Product> CartList=new ArrayList<Product>();
	private float totalPrice=0;
	private String Payment="Cash";
	private int getIndex(String Name) {
		for(int j=0;j<CartList.size();j++) {
			if(Name.equals(CartList.get(j).getName())) {
				return j;
			}
		}
		return -1;
	}

	public void add(List<Product> products) {
		for(int i=0;i<products.size();i++) {
			Product product=products.get(i);
			int index=getIndex( products.get(i).getName()) ;
			if(index!=-1) {
				//System.out.println(product.getName()+" "+product.getCount());
				this.replace(product,index );
			}
			else {
				this.add(products.get(i));
			}
			
		}
	}
	public void add(Product product) {	
		
		int index=VendingMachine.getIndex(product.getName());
		if(index!=-1) {
			if(VendingMachine.ProductList.get(index).getCount()>0) {
				int index1=getIndex(product.getName());
				if(index1!=-1) {
					product.setCount(CartList.get(index1).getCount()+product.getCount());
					CartList.remove(index1);
					CartList.add(product);	
					calculateTotal();
				}
				else {
					CartList.add(product);	
					calculateTotal();
				}
				//this.ListCart();
			}
			else {
				
				System.out.println(product.getName()+" is no more available.Verify the added count in cart.");
			}
		}
		else {
			System.out.println(product.getName()+" not available in Machine");
		}
	}
//	public void replace(Product product) {
//		int index=getIndex( product.getName()) ;
//		if(index!=-1) {
//			this.replace(product, index);
//			
//		}
//		else {
//			this.add(product);
//		}
//		
//		
//	}
	private void replace(Product p,int index) {
		Product product=new Product(CartList.get(index));
		//System.out.println(product.getCount()+" "+p.getCount());
		product.setCount(product.getCount()+p.getCount());
		int index1=VendingMachine.getIndex(product.getName());
		product.setPrice(VendingMachine.ProductList.get(index1).getPrice());
		CartList.remove(index);
		CartList.add(product);
		calculateTotal();
		//this.ListCart();
			
	}
	
	public void delete(Product product) {
		int index=getIndex(product.getName());
		if(index!=-1) {
			calculateTotal();
			CartList.remove(index);
		}
		else {
			System.out.println(product.getName()+" not found");
		}
	}
	public void delete(List<Product> products) {
		for(int i=0;i<products.size();i++) {
			this.delete(products.get(i));
		}
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	private float calculateTotal() {
		totalPrice=0;
		if(!isEmpty()) {
			for(int i=0;i<CartList.size();i++) {
				Product p=new Product(CartList.get(i));
				if(p.getCount()>0) {
					totalPrice=totalPrice+p.getCount()*p.getPrice();
				}
			}
			
		}
		return totalPrice;
	}
	public void showBill() {
		if(!isEmpty()) {
			boolean flag=false;
			for(int i=0;i<CartList.size();i++) {
				int index=VendingMachine.getIndex(CartList.get(i).getName());
				Product p=new Product(VendingMachine.ProductList.get(index));
				if(p.getCount()<CartList.get(i).getCount()) {
					flag=true;
					System.out.println(CartList.get(i).getName()+" available quantity is "+p.getCount()+". Removing item from cart");
					this.delete(CartList.get(i));
				}
			}
			if(flag==true ) {
				if(!isEmpty()) {
					System.out.println("Review the cart");
					ListCart();
					System.out.println("Checkout?\n1. Yes\n2. No");
					Scanner obj=new Scanner(System.in);
					int choice=obj.nextInt();
					if(choice==1) {
						
							
							
							System.out.println("#############BILL###########");
							System.out.println("Name\t\t\tPrice\tQuantity");
							for(int i=0;i<CartList.size();i++) {
								if(CartList.get(i).getCount()>0) {
									Product p=new Product(CartList.get(i));
									System.out.println(p.getName()+"\t\t\tRs."+p.getPrice()+"\t"+p.getCount());
								}
					
							System.out.println("Total:\t"+calculateTotal());
							
							}
						
						
					}
					else if(choice!=2) {
						
						System.out.println("Invalid Input");
					}	
					else {
						EmptyCart();
					}
				}
			}	
			else {
				System.out.println("Cart is empty");
			}
		}
	
	}	
		
		
	
	public void EmptyCart() {
		CartList.clear();
		totalPrice=0;
		System.out.println("Cart has been emptied.");
	}
	
	public void ListCart() {
		if(!isEmpty()) {
			System.out.println("#############CART###########");
			for(int i=0;i<CartList.size();i++) {
				if(CartList.get(i).getCount()>0) {
					System.out.println(CartList.get(i).getName()+" "+CartList.get(i).getCount());
				}
			}
		}
		else {
			System.out.println("Cart is empty");
		}
	}
	public boolean isEmpty() {
		int total=0;
		if(CartList.size()>0){
			for(int i=0;i<CartList.size();i++) {
				total=total+CartList.get(i).getCount();
				
			}
			if(total>0) {
				return false;
			}
			
		}
		return true;
	}
	public void setPayment(String Type) {
		Payment=new String(Type);
		if(Type.equals("Card")) {
			totalPrice=2*totalPrice;
		}
	}
	
	
}
