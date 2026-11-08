import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Задайте количество элементов x-массива n = ");
        int n = in.nextInt();
        float x[] = InputMassiv(n);
        Output(x, "x");
        float SumX = SummaMassiv(x);
        System.out.println("сумма элементов=" + SumX);

        System.out.print("Задайте количество элементов y-массива m = ");
        int m = in.nextInt();
        float y[] = InputMassiv(m);
        Output(y, "y");
        float SumY = SummaMassiv(y);
        System.out.println("сумма элементов=" + SumY);
        float CH = SumX + SumY;
        System.out.println("Сумма массивов=" + CH);

        System.out.print("a = ");
        float a = in.nextFloat();

        float an = Step(a, n);
        float am = Step(a, m);

        float S1 = SumX + n * an;
        float S2 = SumY / am;

        float F = S1 + S2;
        System.out.println("F = " + F);
    }

    static float[] InputMassiv(int LengthMassiv) {
        Random r = new Random();
        float mas[] = new float[LengthMassiv];
        for (int i = 0; i < LengthMassiv; i++) {
            mas[i] = r.nextFloat();
        }
        return mas;
    }

    static void Output(float[] mas, String str) {
        for (int i = 0; i < mas.length; i++) {
            System.out.println(str + "[" + (i + 1) + "]=" + mas[i]);
        }
    }

    static float SummaMassiv(float[] mas) {
        float Sum = 0;
        for (int i = 0; i < mas.length; i++) {
            Sum = Sum + mas[i];
        }
        return Sum;
    }

    static float Step(float osn, int nn) {
        float st = 1;
        for (int i = 1; i <= nn; i++) {
            st = st * osn;
        }
        return st;
    }
}
