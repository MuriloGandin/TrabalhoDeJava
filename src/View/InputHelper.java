package View;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scan = new Scanner(System.in);

    public static String lerTexto(String texto) {
        System.out.println(texto);
        return scan.nextLine();
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
                System.out.println("Tipo de dado inválido. Insira um número inteiro");
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
                System.out.println("Tipo de dado inválido. Insira um número inteiro");
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
                System.out.println("Tipo de dado inválido. Insira um número decimal");
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
                System.out.println("Tipo de dado inválido. Insira um número decimal");
            }
        }

        return resultado;
    }

    public static void printColorido(String texto, String cor) {
        String codigoCor;

        if (cor.equalsIgnoreCase("vermelho"))
            codigoCor = "\u001B[31m";
        else if (cor.equalsIgnoreCase("verde"))
            codigoCor = "\u001B[32m";
        else if (cor.equalsIgnoreCase("amarelo"))
            codigoCor = "\u001B[33m";
        else
            throw new RuntimeException("Cor inválida para string (apenas vermelho, verde ou amarelo)");

        System.out.println(codigoCor + texto + "\u001B[0m");
    }

}
