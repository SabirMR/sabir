import java.util.Scanner;

public class Main {
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
        System.out.print("y1 = ");
        double y1 = in.nextDouble();

        double f = (x + F(a, n)) + y1 / F(a, m);
        System.out.println("F = " + f);
    }

    static double F(double a, int n) {
        double p = 1;
        for (int i = 1; i <= n; i++) {
            p = p * a;
        }
        return p;
    }
}
