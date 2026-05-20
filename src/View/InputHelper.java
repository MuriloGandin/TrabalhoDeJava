package View;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scan = new Scanner(System.in);

    public static String lerTexto(String texto){
        System.out.println(texto);
        return scan.nextLine();
    }

    public static int lerNumero(String texto){
        return Integer.parseInt( lerTexto(texto) );
    }
}
