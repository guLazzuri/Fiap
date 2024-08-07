// Classe Calculadora
public class Calculadora {
    // Método para soma
    public static double soma(double num1, double num2) {
        return num1 + num2;
    }

    // Método para subtração
    public static double subtracao(double num1, double num2) {
        return num1 - num2;
    }

    // Método para multiplicação
    public static double multiplicacao(double num1, double num2) {
        return num1 * num2;
    }

    // Método para divisão
    public static double divisao(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("Não é possível dividir por zero.");
            return Double.NaN; // Retorna NaN (Not a Number) para indicar erro
        }
    }
}
