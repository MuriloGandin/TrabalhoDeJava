package Controller;

import Model.Inimigo;
import Model.Personagem;

public class InimigoController {
    public static void executarTurnoInimigo(Inimigo inimigo, Personagem jogador) {
        System.out.println("\n" + inimigo.getNome() + " atacou " + jogador.getNome() + "!");

        int dano = inimigo.getDano();
        if (jogador.isDefendendo()) {
            dano = dano / 2;
            System.out.println("Defesa ativada! Dano reduzido pela metade.");
        }

        jogador.receberDano(dano);
        System.out.println(jogador.getNome() + " ficou com " + jogador.getPontosDeVida() + " HP.");
    }
}
