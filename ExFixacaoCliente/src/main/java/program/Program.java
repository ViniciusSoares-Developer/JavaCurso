package program;

import com.sun.security.jgss.GSSUtil;
import entites.Cliente;
import entites.Order;
import entites.OrderItem;
import entites.Product;
import entites.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] arg) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat dateSDF = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String name = scan.next();
        System.out.print("Email: ");
        String email = scan.next();
        while(!email.contains("@hotmail.com") && !email.contains("@gmail.com")){
            System.out.println("Write a valid email: (@hotmail.com or @gmail.com)");
            System.out.print("Email: ");
            email = scan.next();
        }
        System.out.print("Birth date (dd/mm/yyyy):");
        String birthDate = scan.next();
        System.out.println();
        System.out.println("Enter other data: ");
        System.out.print("Status: ");
        String status = scan.next();
        Date data = dateSDF.parse(birthDate);
        Order order = new Order(new Date(),
                OrderStatus.valueOf(status),
                new Cliente(name,
                        email,
                        data));
        System.out.print("How many items to this order? ");
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Enter #%d item data:\n", i);
            System.out.print("Product name: ");
            String nameProduct = scan.next();
            System.out.print("Product price: ");
            double priceProduct = scan.nextDouble();
            System.out.print("Quantity: ");
            int quantityProduct = scan.nextInt();
            order.addItem(new OrderItem(quantityProduct, new Product(nameProduct, priceProduct)));
        }
        System.out.println();
        System.out.println(order);
    }
}
