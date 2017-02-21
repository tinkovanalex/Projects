package JavaPractice;

/**
 * Created by atinkovan on 2/21/2017.
 */
public class Product {

    private String title;
    private double price;
    private int quantity;


    public double getCost(){
        return quantity * price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
