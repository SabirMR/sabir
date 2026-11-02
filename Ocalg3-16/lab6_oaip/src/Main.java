import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("N = ");
        int N = in.nextInt();

        double P = 0;

        for (int k = 1; k <= N; k++) {
            P += (double)(3 * k) / ((double)((4 * k - 1) * (5 * k - 1)));
        }

        System.out.printf("При N = %d P = %.6f%n", N, P);
    }
}
