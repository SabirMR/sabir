import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число элементов массива:");
                System.out.print( "n = ");
        int n = in.nextInt();
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = r.nextInt(16) - 5;
        }

        System.out.println("Вывод элементов массива t:");
        for (int i = 0; i < n; i++) {
            System.out.println("t[" + (i + 1) + "] = " + t[i]);
        }

        System.out.print("Номера элементов массива t, равных 0: ");
        int countZero = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == 0) {
                countZero++;
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
        System.out.println("Количество элементов массива t, равных 0: " + countZero);
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = 12 * t[i] - 4;
        }

        System.out.println("\nВывод элементов массива x:");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + (i + 1) + "] = " + x[i]);
        }
        int maxOddPos = x[0];
        for (int i = 2; i < n; i = i + 2) {
            if (x[i] > maxOddPos) {
                maxOddPos = x[i];
            }
        }
        System.out.println("\nМаксимальный элемент массива x на нечетных позициях: " + maxOddPos);
        in.close();
    }
}

