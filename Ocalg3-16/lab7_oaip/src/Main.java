import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double E = 0.001;
        double S = 0;
        int N = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();

        double A = (x * 5) / factorial(6);

        do {
            S += A;
            N++;
            System.out.printf("A%d = %.4f, сумма = %.4f%n", N, A, S);

            A = A * 5.0 / (N + 6);

        } while (A >= E);

        System.out.printf("Сумма членов ряда S = %.4f", S);
        System.out.println();
        System.out.printf("число итераций N = %d%n", N);
    }


    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
