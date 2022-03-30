package program;

import entitites.ClassPessoa;
import entitites.ClassPessoaFisica;
import entitites.ClassPessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] arg){
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        List<ClassPessoa> pessoas = new ArrayList<>();

        System.out.print("Entre com o numero de contribuintes: ");
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Dados do %d Contribuinte:\n", i);
            System.out.print("Individual ou empresa (i/c)? ");
            char tipo = scan.next().toLowerCase().charAt(0);
            System.out.print("Nome: ");
            String nome = scan.next();
            System.out.print("Renda anual: ");
            double rendaAnual = scan.nextDouble();
            switch (tipo){
                case 'i' -> {
                    System.out.print("Gasto com saude: ");
                    double gastoComSaude = scan.nextDouble();
                    pessoas.add(new ClassPessoaFisica(nome, rendaAnual, gastoComSaude));
                }
                case 'c' -> {
                    System.out.print("Numero de empregados: ");
                    int numeroFuncionarios = scan.nextInt();
                    pessoas.add(new ClassPessoaJuridica(nome, rendaAnual, numeroFuncionarios));
                }
                default -> {
                    System.out.println("Tipo de pessoa invalida! Tente Novamente...");
                    i-=1;
                }
            }

        }
        System.out.println("\nIMPOSTOS PAGOS");
        double total = 0.0;
        for (ClassPessoa p:pessoas) {
            System.out.println(p);
            total += p.imposto();
        }
        System.out.printf("Total de impostos: %.2f", total);
        scan.close();
    }
}
