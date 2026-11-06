import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Задайте количество элементов x-массива:");
        System.out.print("n = ");
        int n = in.nextInt();
        float[] x = InputMassiv(n);
        Output(x, "x");

        float sumX = SummaMassiv(x);
        System.out.println("сумма элементов=" + sumX);

        System.out.println("Задайте количество элементов y-массива");
        System.out.print("m = ");
        int m = in.nextInt();
        float[] y = InputMassiv(m);
        Output(y, "y");

        float sumY = SummaMassiv(y);
        System.out.println("сумма элементов=" + sumY);

        float totalSumXY = sumX + sumY;
        System.out.println("Сумма массивов=" + totalSumXY);

        System.out.print("a = ");
        float a = in.nextFloat();

        float an = Step(a, n);
        float am = Step(a, m);

        float part1 = sumX + (n * an);

        float part2 = 0;
        for (int k = 0; k < m; k++) {
            float ykPower = Step(y[k], k + 1);
            part2 += ykPower / am;
        }

        float F = part1 + part2;

        System.out.println("Итого F = " + F);

        in.close();
    }

    static float[] InputMassiv(int length) {
        float[] mas = new float[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            mas[i] = (float) (r.nextFloat() * 10);
        }
        return mas;
    }

    static void Output(float[] mas, String str) {
        System.out.println("Вывод массива " + str + ":");
        for (int i = 0; i < mas.length; i++) {
            System.out.println(str + "[" + i + "] = " + mas[i]);
        }
    }

    static float SummaMassiv(float[] mas) {
        float Sum = 0;
        for (float value : mas) {
            Sum += value;
        }
        return Sum;
    }

    static float Step(float osn, int nn) {
        if (nn == 0) return 1;
        float st = 1;
        for (int i = 1; i <= nn; i++) {
            st *= osn;
        }
        return st;
    }
}
