import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("N = ");
        int N = in.nextInt();
        double P = 0;
        double S1 = 4;
        double S2 = 5;
        for (int k = 1; k <= N; k++) {
            P += S1 / (S2 + (S2 + 2));
            S1 += 2;
            S2 += 5;
        }
        System.out.printf("При N = %d P = %.6f", N, P);
    }
}
