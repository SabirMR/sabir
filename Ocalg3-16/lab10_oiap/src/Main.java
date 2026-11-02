import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();

        int start = 1;
        int end = 15;

        System.out.println("S = " + f(x, start, end));
    }

    private static double f(double x, int start, int end) {
        if (start > end) {
            return 0;
        }

        double currentTerm = start * x * Math.sin(start * x);

        return currentTerm + f(x, start + 1, end);
    }
}
