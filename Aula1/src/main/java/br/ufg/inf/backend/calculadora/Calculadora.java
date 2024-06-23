package br.ufg.inf.backend.calculadora;

/**
 *
 * @author Danillo Tomaz Parreira
 */
public class Calculadora {

    //adição, subtração, multiplicação e divisão.
    public static int somar(int a, int b) {
        return a + b;
    }

    public static double somar(double a, double b) {
        return a + b;
    }

    public static int subtrair(int a, int b) {
        return a - b;
    }

    public static double subtrair(double a, double b) {
        return a - b;
    }

    public static double multiplicar(int a, int b) {
        return a * b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Não é possível dividir por 0");
        }
        return a / b;
    }

    public static double dividir(double a, double b) {
        if (b == 0.0) {
            throw new RuntimeException("Nao e possivel dividir por 0.");
        }
        return a / b;
    }
}
