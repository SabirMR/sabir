import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print(" n = ");
        int n = in.nextInt();

        System.out.print(" k = ");
        int k = in.nextInt();

        double totalSum = 0.0;

        for (int i = 1; i <= n; i++) {
            double product = 1.0;

            for (int p = 1; p <= k; p++) {
                double term = Math.log(Math.pow(p, 3) + i);
                product *= term;
            }

            totalSum += product;
        }

        System.out.printf("сумма = %.6f%n", totalSum);
    }
}
