import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(" n = ");
        int n = scanner.nextInt();

        System.out.print(" m = ");
        int k = scanner.nextInt();

        long totalSum = 0;

        for (int i = 1; i <= n; i++) {
            totalSum += (long) i * k;
        }

        System.out.println("сумма " + totalSum);

        scanner.close();
    }
}
