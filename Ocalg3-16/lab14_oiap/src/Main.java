import java.util.Random;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        System.out.println("Задание 1");
        task1();
        System.out.println("Задание 2");
        task2();
        System.out.println("Задание 3");
        task3();
    }

    private static void task3() {
        Random r = new Random();
        int n = 4, m = 5;
        int[][] b = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = r.nextInt(-10, 10);
            }
        }

        System.out.println("Массив: ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("\t" + b[i][j]);
            }
            System.out.println();
        }

        int s;
        for (int j = 1; j < m; j = j + 2) {
            s = 0;
            for (int i = 0; i < n; i++) {
                s += b[i][j];
            }
            System.out.println("Столбец " + (j + 1) + ": " + s);
        }
    }

    private static void task2() {
        Random r = new Random();
        int n = 4, m = 3;
        int[][] b = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = r.nextInt(-10, 10);
            }
        }

        System.out.println("Массив: ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("\t" + b[i][j]);
            }
            System.out.println();
        }

        int p;
        for (int j = 0; j < m; j++) {
            p = 1;
            for (int i = 0; i < n; i++) {
                p *= b[i][j];
            }
            System.out.println("Столбец " + (j + 1) + ": " + p);
        }
    }

    private static void task1() {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите K = ");
        int k = in.nextInt();
        int n = 4, m = 3;
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = r.nextInt(-10, 10);
            }
        }

        System.out.println("Массив: ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("\t" + a[i][j]);
            }
            System.out.println();
        }

        int s = 0, p = 1;

        for (int i = 0; i < n; i++) {
            s += a[i][k - 1];
            p *= a[i][k - 1];
        }

        System.out.println("S = " + s + "\nP = " + p);

    }
}
