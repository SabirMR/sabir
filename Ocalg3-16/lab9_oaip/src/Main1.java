import java.util.Scanner;

public class Main {
    static class Power {
        double value;
    }

    // Процедура: возводит a в степень n,
    // результат возвращается через параметр p
    static void F(double a, int n, Power p) {
        p.value = 1;
        for (int i = 1; i <= n; i++) {
            p.value *= a;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("x = ");
        double x = in.nextDouble();
        System.out.print("a = ");
        double a = in.nextDouble();
        System.out.print("n = ");
        int n = in.nextInt();
        System.out.print("m = ");
        int m = in.nextInt();
        System.out.print("y = ");
        double y = in.nextDouble();

        Power p1 = new Power();
        Power p2 = new Power();

        F(a, n, p1);
        F(a, m, p2);

        double f = (x + p1.value) + y / p2.value;
        System.out.println("F= " + f);
    }
}


