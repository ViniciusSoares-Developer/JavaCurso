package program;

import model.entites.Account;
import model.exception.DomainException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] arg){
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        try{
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = scan.nextInt();
            System.out.print("Holder: ");
            String holder = scan.next();
            System.out.print("Balance: ");
            double balance = scan.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdramLimit = scan.nextDouble();

            Account account = new Account(number, holder, balance, withdramLimit);
            System.out.println(account);

            System.out.print("\nEnter amount for withdraw: ");
            double value = scan.nextInt();
            account.withdraw(value);
            System.out.println(account);
        }catch(DomainException e){
            System.out.println("Withdraw Error: " + e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Input Error");
        }

        scan.close();
    }
}
