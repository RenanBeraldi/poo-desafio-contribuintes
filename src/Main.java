import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos contribuintes vai digitar? ");
        Integer totalTaxPayers = scanner.nextInt();
        System.out.println("\n");

        List<TaxPayer> taxPayers = new ArrayList<TaxPayer>();

        for (int i = 0; i < totalTaxPayers; i++) {
            System.out.println("Digite os dados do " + (i + 1) + "o contribuinte");
            System.out.print("Renda anual com salario: ");
            Double salaryIncome = scanner.nextDouble();
            System.out.print("Renda anual com prestacao de servico: ");
            Double servicesIncome = scanner.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            Double capitalIncome = scanner.nextDouble();
            System.out.print("Gastos medicos: ");
            Double healthSpending = scanner.nextDouble();
            System.out.print("Gastos com educacao: ");
            Double educationSpending = scanner.nextDouble();
            System.out.println("\n");

            TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);

            taxPayers.add(taxPayer);
        }

        for (TaxPayer taxPayer : taxPayers) {
            System.out.println("Resumo do " + (taxPayers.indexOf(taxPayer) + 1) + "o contribuinte");
            System.out.printf("Imposto bruto total: %.2f%n", taxPayer.grossTax());
            System.out.printf("Abatimento: %.2f%n", taxPayer.taxRebate());
            System.out.printf("Imposto devido: %.2f%n", taxPayer.netTax());
            System.out.println("\n");
        }

        scanner.close();
    }
}
