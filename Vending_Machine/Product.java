
public class Product {
	//default value for price is 10 and count is 0
	private String Name;
	private float Price;
	private int count;
	Product(Product product){
		Name=product.getName();
		Price=product.getPrice();
		count=product.getCount();
	}
	Product(String Name){
		setName(Name);
		setPrice(10);
		//Price=VendingMachine.ProductList.
		setCount(0);
	}
	Product(String Name,int count){
		setName(Name);
		setPrice(10);
		setCount(count);
	}
	Product(String Name,float Price){
		setName(Name);
		setPrice(Price);
		setCount(0);
	}
	Product(String Name,float Price,int count){
		setName(Name);
		setPrice(Price);
		setCount(count);
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice() {
		int index=VendingMachine.getIndex(Name);
		if(index!=-1) {
			Product p=VendingMachine.ProductList.get(index);
			this.Price=p.getPrice();	
		}
		
	}
	public void setPrice(float price) {
		
		int index=VendingMachine.getIndex(Name);
		//System.out.println(index);
		if(index!=-1) {
			Product p=VendingMachine.ProductList.get(index);
			p.Price=price;
			VendingMachine.ProductList.remove(index);
			VendingMachine.ProductList.add(p);
			this.setPrice();
			
		}
		else {
			
			this.Price=price;
			
			
		}
		
		
	}
	public int getCount() {
		return count;
	}
	public void addCount() {
		this.count++;
	}
	public void addCount(int count) {
		this.count+=count;
	}
	public void reduceCount(int count) {
		if(this.count>0) {
			this.count-=count;
		}
		else {
			this.count=0;
		}
	}
	public void reduceCount() {
		if(this.count>0) {
			this.count--;
		}
		else {
			this.count=0;
		}
	}
	public void setCount(int count) {
		this.count = count;
	}
	private void setName(String name) {
		Name=name;
	}
	public String getName() {
		return Name;
	}
	public void resetCount() {
		this.count=0;
	}
}
