import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int result = 1;
            for (int j = 1; j <= k; j++) {
                result *= i;
            }
            System.out.printf("%d = %d\n", i, result);
            System.out.println();
            sum += result;
        }
        System.out.println(sum);
    }
}