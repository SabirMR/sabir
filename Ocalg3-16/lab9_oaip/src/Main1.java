import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main1 {

    static class Steps {
        int value;
    }

    static class Factorial {
        int value;
    }

    static int s(int osn, int step, Steps s) {
        s.value = 1;
        for (int i = 1; i <= step; i++) {
            s.value *= osn;
        }
        return s.value;
    }

    static int f(int fact, Factorial factorial) {
        factorial.value = 1;
        for (int i = 1; i <= fact; i++) {
            factorial.value *= i;
        }
        return factorial.value;
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

        Factorial f = new Factorial();
        Steps s = new Steps();

        int s1 = s(a, m, s);
        int s2 = s(c, n, s);
        int f1 = f(n, f);

        double F = x + (double) y / (s1 + s2) + f1;

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
