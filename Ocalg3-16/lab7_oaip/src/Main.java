import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double E = 0.001;
        double S = 0;        
        int n = 0;           
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();
        double A = x / factorial(5);

        do {
            S += A;
            n++;
            System.out.printf("A%d = %.4f, сумма = %.4f%n", n - 1, A, S);
            
            A = A * 5.0 / (n + 5);
        } while (Math.abs(A) >= E);

        System.out.printf("Сумма членов ряда S = %.4f%n", S);
        System.out.printf("Число итераций (вычисленных членов) = %d%n", n);
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
