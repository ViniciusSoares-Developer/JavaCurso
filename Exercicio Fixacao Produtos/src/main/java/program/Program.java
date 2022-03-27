package program;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] arg) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Product #%d data:\n",i);
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = scan.next().toLowerCase().charAt(0);
            System.out.print("Name: ");
            String name = scan.next();
            System.out.print("Price: ");
            double price = scan.nextDouble();
            switch (type){
                case 'c':
                    products.add(new Product(name, price));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY):");
                    String dateProduct = scan.next();
                    products.add(new UsedProduct(name, price, date.parse(dateProduct)));
                    break;
                case 'i':
                    System.out.print("Customs fee: ");
                    double customsFee = scan.nextDouble();
                    products.add(new ImportedProduct(name, price, customsFee));
                    break;
                default:
                    System.out.println("Null type");
                    i-=1;
            }
        }
        for (Product p:products) {
            System.out.println(p);
        }

        scan.close();
    }
}
