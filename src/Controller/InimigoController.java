package Controller;

import Model.Inimigo;
import Model.Personagem;
import Log.Log;
import java.util.List;

public class InimigoController {


    public static void executarTurnoInimigos(List<Inimigo> inimigos, Personagem jogador) {

        for (Inimigo inimigo : inimigos) {
            System.out.println("\n" + inimigo.getNome() + " atacou " + jogador.getNome() + "!");

            int dano = inimigo.getDano();
            if (jogador.isDefendendo()) {
                dano = dano / 2;
                System.out.println("Defesa ativada! Dano reduzido pela metade.");
            }

            jogador.receberDano(dano);
            Log.Registrar(
                    inimigo.getNome() +
                            " atacou " +
                            jogador.getNome() +
                            " causando " +
                            dano +
                            " de dano."
            );

        }
        System.out.println(jogador.getNome() + " ficou com " + jogador.getPontosDeVida() + " HP.");
    }

    public static Inimigo buscarInimigo(String nomeInimigo, List<Inimigo> listaInimigos) {
        for (Inimigo i :  listaInimigos) {
            if (i.getNome().equalsIgnoreCase(nomeInimigo)) {
                return i;
            }
        }
        return null;
    }
}
