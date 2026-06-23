import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        final double E = 0.001;
        double A, S;
        int N;
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();
        S = 0;
        N = 0;
        A = x;
        do {
            S = S + A;
            N = N + 1;
            System.out.printf("A%d = %.4f, сумма = %.4f\n", N, A, S);
            A *= (double) N / ((3 * N - 2) * (3 * N - 1) * (3 * N));
        }
        while (A >= E);
        System.out.printf("Сумма членов ряда S = %.4f, число итераций N = %d", S, N);
    }
}