import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();
        int start = 1;
        int end = 7;
        System.out.println("S = " + f(x, start, end));
    }

    private static double f(double x, int start, int end) {
        if (start > end) return 0;
        return Math.sin(start * x) / (start * 2) + f(x, start + 1, end);
    }
}
