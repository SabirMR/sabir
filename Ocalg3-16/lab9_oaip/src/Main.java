import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {

    static int s(int osn, int step) {
        int result = 1;
        for (int i = 1; i <= step; i++) {
            result *= osn;
        }
        return result;
    }

    static int f(int fact) {
        int value = 1;
        for (int i = 1; i <= fact; i++) {
            value *= i;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int c = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println("A = " + a + "\nC = " + c + "\nX = " + x + "\nY = " + y + "\nM = " + m + "\nN = " + n);

        double F = x + (double) y / (s(a, m) + s(c, n)) + f(n);

        System.out.printf("%.2f", F);
    }
}

//A = 1
//C = 2
//X = 3
//Y = 4
//M = 5
//N = 6
//723,06

