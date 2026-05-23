package View;

import Model.Inimigo;
import Model.Personagem;

public class Sistema {
    public static void executar(){
        mostrarMenuInicial();
        InputHelper.scan.nextLine();

        Inimigo creeper = new Inimigo("Creeper", 12, 6);

        Personagem steve = new Personagem("Steve", 20, 6);
        Ondas();

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

    public static void Ondas(){
        for (int onda = 1; onda <= 1 ; onda++) {

            System.out.println("Onda " + onda);

            int quantidadeDeInimigos = onda * 1; // define quantos enimigos tem por onda //
            for (int inimigos = 0; inimigos < quantidadeDeInimigos ; inimigos++) {

//                Inimigo crepper = new Inimigo("Crepper", 12, 6);

                System.out.println("Inimigo " + (inimigos + 1) + " " +
                        "Apareceu");
            }
            System.out.println("----------------");
        }
    }
}
