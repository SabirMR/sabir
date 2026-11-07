import java.util.Scanner;

public class Main {
    public static void main(String args) {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();

        int start = 1;
        int end = 15;
        double S = f(x, start, end);
        System.out.println("S = " + S);
    }

    private static double f(double x, int start, int end) {
        if (start > end) {
            return 0; 
        }
        double term = start * x * Math.sin(start * x);
        return term + f(x, start + 1, end);          
    }
}
