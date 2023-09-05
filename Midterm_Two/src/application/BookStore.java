package application;

public class BookStore {
	
	private String Name;
	private double Price;
	private int Quantity;
	private double SubTotal;
	
	public BookStore()
	{
		this.Name = "";
		this.Price = 0;
		this.Quantity = 0;
		this.SubTotal = 0 ;
	}

	public BookStore(String name,double price,int quantity)
	{
		this.Name = name;
		this.Price = price;
		this.Quantity = quantity;
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getSubTotal() {
		return Price*Quantity;
	}
	
	public void setSubTotal(int quantity, double price) {
		this.SubTotal = quantity*price;
	}


	
	
}
