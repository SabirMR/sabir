import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("“ПОКА” с увеличением параметра цикла k");
        task1();
        System.out.println("“ПОКА” с уменьшением параметра цикла k");
        task2();
        System.out.println("“ДО” с увеличением параметра цикла k");
        task3();
        System.out.println("“ДО” с уменьшением параметра цикла k");
        task4();
    }

    static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();
        double S = 0;
        int k = 1;
        while (k <= 7) {
            S = S + sin(k * x) / (k * 2);
            k = k + 1;
        }
        System.out.printf("При x = %.2f, S = % .3f", x, S);
        System.out.println();
    }

    static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();
        double S = 0;
        int k = 7;
        while (k >= 1) {
            S = S + sin(k * x) / (k * 2);
            k = k - 1;
        }
        System.out.printf("При x = %.2f, S = % .3f", x, S);
        System.out.println();
    }

    static void task3() {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();
        double S = 0;
        int k = 1;
        do {
            S = S + sin(k * x) / (k * 2);
            k = k + 1;
        } while (k <= 7);
        System.out.printf("При x = %.2f, S = % .3f", x, S);
        System.out.println();
    }

    static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();
        double S = 0;
        int k = 7;
        do {
            S = S + sin(k * x) / (k * 2);
            k = k - 1;
        } while (k >= 1);
        System.out.printf("При x = %.2f, S = % .3f", x, S);
        System.out.println();
    }
}
