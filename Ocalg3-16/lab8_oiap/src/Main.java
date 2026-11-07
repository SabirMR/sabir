public class Main {
    public static void main(String[] args) {
        double sum = 0.0;

        for (int i = 1; i <= 2; i++) {
            double product = 1.0;
            
            for (int p = 1; p <= 3; p++) {
                double term = Math.log(Math.pow(p, 3) + i);
                product *= term;
            }

            sum += product;
        }

        System.out.printf("Результат вычисления: %.4f%n", sum);
    }
}
