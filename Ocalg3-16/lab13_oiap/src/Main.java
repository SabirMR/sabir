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
        System.out.println("Задание 4");
        task4();
    }

    static void task1() {
        int n = 4, m = 3;
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                a[i][j] = 10 * (j + 1);
            }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("\t" + a[i][j]);
            }
            System.out.println();
        }
    }

    static void task2() {
        Scanner in = new Scanner(System.in);
        int n = 4, m = 3;
        int[][] a = new int[n][m];

        System.out.println("Введите набор чисел:");
        for (int j = 0; j < m; j++) {
            int T = in.nextInt();
            for (int i = 0; i < n; i++) {
                a[i][j] = T;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("\t" + a[i][j]);
            }
            System.out.println();
        }
    }

    static void task3() {
        Scanner in = new Scanner(System.in);
        int n = 4, m = 3;
        int[][] a = new int[n][m];

        System.out.print("D = ");
        int D = in.nextInt();
        System.out.println("Введите набор чисел:");
        for (int j = 0; j < m; j++) {
            int T = in.nextInt();
            for (int i = 0; i < n; i++) {
                a[i][j] = T;
                T = T * D;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("\t" + a[i][j]);
            }
            System.out.println();
        }
    }

    static void task4() {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        int n = 4, m = 3;
        int[][] a = new int[n][m];

        System.out.print("K = ");
        int k = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = r.nextInt(1, 5);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i][k - 1] + " ");
        }

        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("\t" + a[i][j]);
            }
            System.out.println();
        }
    }

}
