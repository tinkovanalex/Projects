package JavaPractice;

import java.util.Scanner;

/**
 * Created by atinkovan on 2/21/2017.
 */
public class Program {
    public static void main(String[] args) {

    }

    private Deal [] deals;

    public Deal inputBuyerName(){
        Scanner scanner = new Scanner(System.in);
        String buyerName;
        System.out.print("Enter Buyer Name ");
        buyerName = scanner.nextLine();
        Party buyer = new Party();
        buyer.setName(buyerName);
        return inputBuyerName();
    }

    public Deal inputSellerName(){
        Scanner scanner = new Scanner(System.in);
        String buyerName;
        System.out.print("Enter Seller Name ");
        buyerName = scanner.nextLine();
        Party buyer = new Party();
        buyer.setName(buyerName);
        return inputSellerName();
    }

    public Product inputProduct(){
        Scanner scanner = new Scanner(System.in);
        String title;
        System.out.print("Enter title ");
        title = scanner.nextLine();
        Product titleName = new Product();
        titleName.setTitle(title);
        return inputProduct();

    }

}
