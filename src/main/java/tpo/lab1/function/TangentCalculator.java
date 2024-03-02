package tpo.lab1.function;

public class TangentCalculator {
    
    public static double calculateTangent(double x, int n) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            double term = ((Math.pow(-1, i) * Math.pow(x, 2 * i + 1)) / factorial(2 * i + 1));
            result += term;
        }
        return result;
    }
    
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        double x = 4; // Угол в радианах
        int n = 10; // Количество итераций
        double tangent = calculateTangent(x, n);
        System.out.println("Tangent of " + x + " is: " + tangent);
        System.out.println(Math.tan(x));
    }
}