import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("x = ");
        double x = in.nextDouble(); 
        System.out.print("y = ");
        int y = in.nextInt();       
        System.out.print("a = ");
        double a = in.nextDouble(); 
        System.out.print("n = ");
        int n = in.nextInt();
        System.out.print("m = ");
        int m = in.nextInt();

        double part1 = x + pow(a, n);   
        double part2 = fact(y) / pow(a, m); 
        
        double F = part1 + part2;

        System.out.printf("F = %.6f%n", F);
    }

    static double pow(double base, int exp) {
        double result = 1.0;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    static double fact(int num) {
        double result = 1.0;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
