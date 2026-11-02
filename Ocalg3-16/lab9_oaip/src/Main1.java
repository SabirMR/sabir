import java.util.Scanner;

public class Main {
    
    static class ResultHolder {
        double value;
    }

    static void calcPow(double base, int exp, ResultHolder holder) {
        holder.value = 1.0;
        for (int i = 0; i < exp; i++) {
            holder.value *= base;
        }
    }

    static void calcFact(int num, ResultHolder holder) {
        holder.value = 1.0;
        for (int i = 1; i <= num; i++) {
            holder.value *= i;
        }
    }

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

        ResultHolder h1 = new ResultHolder();
        ResultHolder h2 = new ResultHolder();
        ResultHolder h3 = new ResultHolder();

        calcPow(a, n, h1);
        
        calcPow(a, m, h2);
        
        calcFact(y, h3);

        double F = (x + h1.value) + (h3.value / h2.value);

        System.out.printf("F = %.6f%n", F);
    }
}

