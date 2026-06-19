package View;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scan = new Scanner(System.in);

    public static String lerTexto(String texto) {
        OutputHelper.printGradual(texto, 10);
        return scan.nextLine();
    }

    public static String lerTexto(String texto, int velocidadePrint) {
        OutputHelper.printGradual(texto, velocidadePrint);
        return scan.nextLine();
    }

    public static void insiraEnter() {
        InputHelper.lerTexto("\nPressione ENTER para continuar...");
    }

    public static String lerTexto() {
        return scan.nextLine();
    }

    public static int lerNumero(String texto) {
        int resultado;
        while (true) {
            try {
                resultado = Integer.parseInt( lerTexto(texto) );
                break;

            } catch (Exception e) {
                OutputHelper.printGradual("Tipo de dado inválido. Insira um número inteiro\n", 10);
            }
        }

        return resultado;
    }

    public static int lerNumero(String texto, int velocidade) {
        int resultado;
        while (true) {
            try {
                resultado = Integer.parseInt( lerTexto(texto, velocidade) );
                break;

            } catch (Exception e) {
                OutputHelper.printGradual("Tipo de dado inválido. Insira um número inteiro\n", 20);
            }
        }

        return resultado;
    }

    public static int lerNumero() {

        int resultado;
        while (true) {
            try {
                resultado = Integer.parseInt( lerTexto() );
                break;

            } catch (Exception e) {
                OutputHelper.printGradual("Tipo de dado inválido. Insira um número inteiro\n");
            }
        }

        return resultado;
    }

    public static float lerFloat(String texto) {
        float resultado;
        while (true) {
            try {
                resultado = Float.parseFloat( lerTexto(texto) );
                break;

            } catch (Exception e) {
                OutputHelper.printGradual("Tipo de dado inválido. Insira um número decimal\n");
            }
        }

        return resultado;
    }

    public static float lerFloat() {
        float resultado;
        while (true) {
            try {
                resultado = Float.parseFloat( lerTexto() );
                break;

            } catch (Exception e) {
                OutputHelper.printGradual("Tipo de dado inválido. Insira um número decimal\n");
            }
        }

        return resultado;
    }

}
