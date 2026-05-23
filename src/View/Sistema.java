package View;

import Model.Inimigo;
import Model.Personagem;

public class Sistema {
    public static void executar(){
        mostrarMenuInicial();
        InputHelper.scan.nextLine();

        Inimigo creeper = new Inimigo("Creeper", 12, 6);

        Personagem steve = new Personagem("Steve", 20, 6);

        System.out.println("Vida do creeper: " + creeper.getPontosDeVida());
        System.out.println("Pressione enter para atacar");
        InputHelper.scan.nextLine();
        steve.atacar(creeper);
        System.out.println("Vida do creeper: " + creeper.getPontosDeVida());

    }

    public static void mostrarMenuInicial() {
        System.out.println("----- NullPointer Quest -----");
        System.out.println("-- Pressione ENTER para jogar --");
    }
}
