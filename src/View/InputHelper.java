package View;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scan = new Scanner(System.in);

    // Mostra uma mensagem no terminal e retorna o texto digitado pelo usuario
    public static String lerTexto(String texto) {
        System.out.println(texto);
        return scan.nextLine();
    }
    // Retorna o texto digitado sem exibir texto
    public static String lerTexto() {
        return scan.nextLine();
    }

    // Mostra uma mensagem e lê o conteúdo digitado no terminal, em seguida, tenta transformar o texto em um número inteiro.
    // Caso o usuário digite um valor inválido, o terminal repetirá a operação
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
    // Funciona como a função anterior, mas sem exibir qualquer mensagem
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
    // Exibe uma mensagem, lê e retorna um número decimal (ex: 2.5).
    // Tipos inválidos farão a operção se repetir
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
    // Funciona como a função anterior, mas não exibe qualquer texto
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

}
