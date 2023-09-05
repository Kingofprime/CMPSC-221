package application;

/**
 * 
 */
public class Data {

            private String name;
            private double price;
            private int quantity;

    public Data()  //default constructor
    {
        this.name="";
        this.price = 0.0;
        this.quantity = 0;

    }

    public Data( String name, double price, int quantity ) //constructor overload
    {
        this.name=name;
        this.price=price;
        this.quantity=quantity;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}













