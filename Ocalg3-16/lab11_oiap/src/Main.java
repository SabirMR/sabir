import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число элементов массива:");
        System.out.print("t = ");
        int t = in.nextInt();
        int[] n = new int[t]; 

        for (int i = 0; i < t; i++) {
            n[i] = r.nextInt(16);
        }
        System.out.println("Вывод элементов массива t:");
        for (int i = 0; i < t; i++) {
            System.out.println("t[" + (i + 1) + "] = " + n[i]);
        }
        
        System.out.print("Номера элементов массива t, равных 0: ");
        int countZero = 0;
        for (int i = 0; i < t; i++) {
            if (n[i] == 0) {
                countZero++;
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
        System.out.println("Количество элементов массива t, равных 0: " + countZero);
        
        int[] x = new int[t];
        for (int i = 0; i < t; i++) {
            x[i] = 12 * n[i] - 4;
        }
        
        System.out.println("\nВывод элементов массива x:");
        for (int i = 0; i < t; i++) {
            System.out.println("x[" + (i + 1) + "] = " + x[i]);
        }
        
        if (t == 0) {
            System.out.println("\nМассив пуст, максимум не определён.");
        } else {
            int maxOddPos = x[0];
            for (int i = 2; i < t; i = i + 2) { 
                if (x[i] > maxOddPos) {
                    maxOddPos = x[i];
                }
            }
            System.out.println("\nМаксимальный элемент массива x на нечётных позициях: " + maxOddPos);
        }

        in.close();
    }
}


