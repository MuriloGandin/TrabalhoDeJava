package View;

public class Sistema {
    public static void executar(){
        mostrarMenuInicial();
        InputHelper.scan.nextLine();
    }

    public static void mostrarMenuInicial() {
        System.out.println("----- NullPointer Quest -----");
        System.out.println("-- Pressione ENTER para jogar --");
    }
}
