package View;

import Model.Inimigo;
import Model.Personagem;

public class Sistema {
    public static void executar(){
        mostrarMenuInicial();
        InputHelper.scan.nextLine();

        Inimigo creeper = new Inimigo(12, true);
        creeper.setDano(5);
        creeper.setNome("Creeper");

        Personagem steve = new Personagem(20, true);
        steve.setDano(6);
        steve.setNome("Steve");

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
