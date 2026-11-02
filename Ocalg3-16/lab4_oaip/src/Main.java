import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("ПОКА" с увеличением параметра цикла k");
        task1();
        System.out.println("ПОКА" с уменьшением параметра цикла k");
        task2();
        System.out.println("ДО" с увеличением параметра цикла k");
        task3();
        System.out.println("ДО" с уменьшением параметра цикла k");
        task4();
    }

    static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();

        double S = 0;
        int k = 1;
        while (k <= 15) {
            S += k * x * Math.sin(k * x);
            k++;
        }
        System.out.printf("При x = %.2f, S = %.3f%n", x, S);
    }

    static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();

        double S = 0;
        int k = 15;
        while (k >= 1) {
            S += k * x * Math.sin(k * x);
            k--;
        }
        System.out.printf("При x = %.2f, S = %.3f%n", x, S);
    }

    static void task3() {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();

        double S = 0;
        int k = 1;
        do {
            S += k * x * Math.sin(k * x);
            k++;
        } while (k <= 15);
        System.out.printf("При x = %.2f, S = %.3f%n", x, S);
    }

    static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();

        double S = 0;
        int k = 15;
        do {
            S += k * x * Math.sin(k * x);
            k--;
        } while (k >= 1);
        System.out.printf("При x = %.2f, S = %.3f%n", x, S);
    }
}
