package JavaPractice;

import java.util.Date;

/**
 * Created by atinkovan on 2/21/2017.
 */
public class Deal {

    private Date date;
    private Party buyer;
    private Party seller;
    private Product[] products;

    public Deal(Date date, Party buyer, Party seller, Product[] products){
        this.date = date;
        this.buyer = buyer;
        this.seller = seller;
        this.products = products;
    }

    public Deal(Party buyer, Party seller, Product[] products){
        date = new Date();
        this.buyer = buyer;
        this.seller = seller;
        this.products = products;
    }



    public double getSum(){
        double rez = 0;
        for(Product pr : products){
            rez += pr.getCost();
        }
    return rez;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Party getBuyer() {
        return buyer;
    }

    public void setBuyer(Party buyer) {
        this.buyer = buyer;
    }

    public Party getSeller() {
        return seller;
    }

    public void setSeller(Party seller) {
        this.seller = seller;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
