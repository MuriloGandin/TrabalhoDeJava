package Controller;

import Model.Inimigo;
import Model.Personagem;
import View.Sistema;
import View.OutputHelper;

import java.util.List;

public class PersonagemController {

    public static final int ATACAR   = 1;
    public static final int DEFENDER = 2;
    public static final int ITEM     = 3;

    public static void executarAcao(int opcao, Personagem jogador, List<Inimigo> inimigos) {
        switch (opcao) {
            case DEFENDER:
                jogador.setDefendendo(true);
                Log.Registrar(jogador.getNome() + "entrou em modo defesa.");
                System.out.println("\n" + jogador.getNome() + " está se defendendo!");
                break;

//            case ITEM:
//                jogador.setDefendendo(false);
//                if (jogador.getPocoes() > 0) {
//                    jogador.recuperarVida(30);
//                    jogador.setPocoes(jogador.getPocoes() - 1);
//                    System.out.println("\n" + jogador.getNome() + " usou uma poção! (+30 HP)");
//                    System.out.println("HP atual: " + jogador.getPontosDeVida());
//                    System.out.println("Poções restantes: " + jogador.getPocoes());
//                    Log.Registrar(jogador.getNome() + " usou uma pocao.");
//                } else {
//                    System.out.println("\nSem poções disponíveis!");
//                    Log.Registrar(jogador.getNome() + " tentou usar pocao sem possuir nenhuma.");
//                }
//                break;

            case ATACAR:
                Inimigo alvo = Sistema.selecionarAlvo(inimigos);
                jogador.atacar(alvo);
                System.out.println("O jogador " + jogador.getNome() + " atacou " + alvo.getNome() + " e causou " + jogador.getDano() + " de dano!");
                Log.Registrar(
                        jogador.getNome() +
                                " atacou " +
                                alvo.getNome() +
                                " causando " +
                                jogador.getDano() +
                                " de dano."
                );
                OutputHelper.printGradual(alvo.getNome() + " ficou com " + alvo.getPontosDeVida() + " pontos de vida!\n", "amarelo");
        }
    }

}
