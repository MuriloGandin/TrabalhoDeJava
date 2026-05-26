package View;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scan = new Scanner(System.in);

// mostra uma mensagem na tela e le um texto digitado pelo usuario
    public static String lerTexto(String texto) {
        System.out.println(texto);
        return scan.nextLine();
    }
// le um texto digitado sem mostrar a mensagem antes
    public static String lerTexto() {
        return scan.nextLine();
    }

// mostra uma mensagem e le o que o usuário digitou e tenta transformar em número inteiro, se ele errar pede de novo até estar correto.
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
    // faz o mesmo que o de cima porem não mostra a mensagem antes
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
    // mostra uma mensagem e le um número decimal (tipo 2.5) e valida, se digitar errado ele repete até acertar.
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
// faz o mesmo que o de cima porem não mostra a mensagem antes.
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
