import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Задайте количество элементов x-массива n = ");
        int n = in.nextInt();
        float[] x = InputMassiv(n);
        Output(x, "x");
        System.out.println("сумма элементов=" + SummaMassiv(x));
        System.out.print("Задайте количество элементов y-массива m = ");
        int m = in.nextInt();
        float[] y = InputMassiv(m);
        Output(y, "y");
        System.out.println("сумма элементов = " + SummaMassiv(y));
        float CH = SummaMassiv(x) + SummaMassiv(y);
        System.out.println("Сумма массивов = " + CH);

        System.out.print("a = ");
        float a = in.nextFloat();
        System.out.print("b = ");
        float c = in.nextFloat();

        float F = SummaMassiv(x) + (SummaMassiv(y) / Step(a, m) + Step(c, n)) + Factorial(n);
        System.out.println("F = " + F);
    }

    static float[] InputMassiv(int LengthMassiv) {
        float[] mas = new float[LengthMassiv];
        Random r = new Random();
        for (int i = 0; i < LengthMassiv; i++) {
            mas[i] = r.nextFloat();
        }
        return mas;
    }

    static void Output(float[] mas, String str) {
        for (int i = 0; i < mas.length; i++) {
            System.out.println(str + "[" + i + "] = " + mas[i]);
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

    static int Factorial(int fact) {
        int res = 1;
        for (int i = 1; i <= fact; i++) {
            res *= i;
        }
        return res;
    }
}