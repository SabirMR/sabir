import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число элементов массива n = ");
        int n = in.nextInt();
        int[] z = new int[n];

        for (int i = 0; i < n; i++) {
            z[i] = r.nextInt(1, 16);
        }

        System.out.println("Вывод элементов массива z");
        for (int i = 0; i < n; i++) {
            System.out.println("z[" + (i + 1) + "] =" + z[i]);
        }

        int qua = 0;
        for (int i = 0; i < n; i++) {
            if (z[i] != 8) {
                qua++;
            }
        }
        System.out.print("Количество элементов массива, не равных 8: " + qua);

        int[] q = new int[n];

        for (int i = 0; i < n; i++) {
            if (z[i] == 3) {
                q[i] = 0;
            } else if (z[i] != 3) {
                q[i] = 2 * z[i];
            }
        }

        System.out.println();

        System.out.println("Вывод элементов массива q");
        for (int i = 0; i < n; i++) {
            System.out.println("q[" + (i + 1) + "] =" + q[i]);
        }

        int temp = 1;
        for (int i = 0; i < n; i = i + 2) {
            if (q[i] != 0) {
                temp *= q[i];
            }
        }

        System.out.println("Произведение ненулевых элементов массива, расположенных на нечетных позициях: " + temp);
    }
}
