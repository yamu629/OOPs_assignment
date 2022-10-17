import java.util.*;

public class VendingMachine {
	static List<Product> ProductList=new ArrayList<Product>();
	
	String[] ProductName_init={"500ml_Water","500ml_Pepsi","Orange_Juice","Strawberry_Yoghurt","Red_Lollipop"};
	float[] Price_init= {30,25,45,50,10};
	int[] count_init= {20,10,10,5,5};
	
	VendingMachine(){
		for(int i=0;i<5;i++) {
			Product P=new Product(ProductName_init[i]);
			P.setPrice(Price_init[i]);
			P.setCount(count_init[i]);
			ProductList.add(P);
			
		}
	}
	//returns -1 if product not found
	public static int getIndex(String Name) {
		for(int j=0;j<ProductList.size();j++) {
			if(Name.equals(ProductList.get(j).getName())) {
				return j;
			}
		}
		return -1;
	}
	public void addProduct(Product product) {
		int index=getIndex(product.getName());
		if(index!=-1) {
			Product p=new Product(ProductList.get(index));
			if(product.getPrice()!=p.getPrice()) {
				p.setPrice(product.getPrice());
			}
			int count=0;
			if(p.getCount()+product.getCount()>0) {
				count=p.getCount()+product.getCount() ;
			}
			p.setCount(count);	
			index=getIndex(product.getName());
			if(index!=-1) {
				System.out.println(product.getName()+" modified successfully");
				showProductDetails(product);
			}
			else {
				System.out.println("Unable to modify "+product.getName());
			}
		}
		
		else {
			ProductList.add(product);
			index=getIndex(product.getName());
			if(index!=-1) {
				System.out.println(product.getName()+" added successfully");
				showProductDetails(product);
			}
			else {
				System.out.println("Unable to add "+product.getName());
			}
		}
		
		
	}
	public void deleteProduct(String Name) {
		
		int index=getIndex(Name);
		if(index!=-1) {
				
				ProductList.remove(index);
				
			}
		else {
				System.out.println(Name+" not found for delete");
		}
		index=getIndex(Name);
		if(index==-1) {
			System.out.println(Name+" deleted successfully");
		}
		else {
			System.out.println("Unable to delete "+Name);
		}
		
	}
	public boolean checkCartItemsAvailability(Cart cart) {
		for(int i=0;i<cart.CartList.size();i++) {
			Product p=cart.CartList.get(i);
			if(checkIfProductExists(p)==false) {
				System.out.println(p.getName()+" is not available. Remove from cart?");
				cart.CartList.remove(i);
			}
		}
		return false;
		
	}
	public boolean checkIfProductExists(Product p) {
		int index=getIndex(p.getName());
		if(index!=-1) {
			Product l=new Product(ProductList.get(index));
			if(l.getCount()>=p.getCount()) {
				return true;
			}
			return false;
			
			
		}
		return false;
	
	}
	public void dispatchProducts(Cart cart) {
		for(int i=0;i<cart.CartList.size();i++) {
			Product p=new Product(cart.CartList.get(i));
			int index=getIndex(p.getName());
			if(index!=-1) {
				Product l=new Product(ProductList.get(index));
				if(l.getCount()>=p.getCount()) {
					l.setCount(l.getCount()-p.getCount());
					ProductList.remove(index);
					ProductList.add(l);
				}
				else {
					System.out.println(p.getName()+ " not available. Issue in disbursing.");
				}
				
			}
		}
	}
	public void showProductDetails(Product product) {
		int index=getIndex(product.getName());
		if(index!=-1) {
			System.out.println("Name:" +product.getName()+"\t\t Price:Rs."+product.getPrice()+"\t Count:"+product.getCount());
		}
		else {
			System.out.println("Unable to find "+product.getName());
		}
		
	}
	public void showAllProducts() {
		if(ProductList.size()>0) {
			for(int i=0;i<ProductList.size();i++) {
				showProductDetails(ProductList.get(i));
			}
		}
		
	}
	public void ListAllProduct() {
		if(ProductList.size()>0) {
			for(int i=0;i<ProductList.size();i++) {
				if(ProductList.get(i).getCount()>0) {
					System.out.println((i+1)+". " +ProductList.get(i).getName());
				}
			}
		}
	}
	
		
}
