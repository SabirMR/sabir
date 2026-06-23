import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 5, m = 6;
        int[][] w = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                w[i][j] = r.nextInt(-5, 10);
            }
        }
        System.out.println("Вывод матрицы w[5][6]: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("\t" + w[i][j]);
            }
            System.out.println();
        }
        System.out.println("Задание 1");
        System.out.println("Найти минимальный положительный элемент матрицы: " + (task1(w)));
        System.out.println();
        System.out.println("Задание 2");
        System.out.println("Вычислить произведение отрицательных элементов в 4-й строке матрицы: " + (task2(w)));
        System.out.println();
        System.out.println("Задание 3");
        System.out.println("Массив s: " + Arrays.toString(task3(w)));
        System.out.println();
        System.out.println("Задание 4");
        System.out.println("Массив r[]: " + Arrays.toString(task4(w)));
        System.out.println();
    }

    static int task1(int[][] c) {
        int tempMin = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] > 0 && c[i][j] < tempMin) {
                    tempMin = c[i][j];
                    found = true;
                }
            }
        }
        if (!found) {
            return -1;
        }
        return tempMin;
    }

    static int task2(int[][] c) {
        int p = 1;
        for (int j = 0; j < c[3].length; j++) {
            if (c[3][j] < 0) {
                p *= c[3][j];
            }
        }
        return p;
    }

    static boolean simpleNum(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        if (n <= 1) return false;

        int limit = (int) Math.sqrt(n);
        for (int temp = 3; temp <= limit; temp = temp + 2) {
            if (n % temp == 0) return false;
        }
        return true;
    }

    static int[] task3(int[][] c) {
        int[] s = new int[c[0].length];
        for (int j = 0; j < c[0].length; j++) {
            int qua = 0;
            for (int i = 0; i < c.length; i++) {
                if (c[i][j] < 0) {
                    qua++;
                }
            }
            s[j] = qua;
        }
        return s;
    }

    static int[] task4(int[][] c) {
        int length = 0;
        int elem = c[1][4];
        System.out.println("Элемент w25: " + elem);
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] > elem) {
                    length++;
                }
            }
        }
        int[] r = new int[length];
        int pos = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] > elem) {
                    r[pos++] = c[i][j];
                }
            }
        }
        return r;
    }
}
