package Controller;

import Model.Inimigo;
import Model.Item;
import Model.Personagem;
import View.PersonagemView;
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
//                System.out.println("\n" + jogador.getNome() + " está se defendendo!"); removi para teste no modo defesa
                break;

            case ITEM:
                PersonagemView.mostrarInventario(jogador);
                PersonagemView.operacaoInventario(jogador);
                break;

            case ATACAR:
                jogador.setDefendendo(false);
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

    public static boolean comprarItem(Item item, Personagem jogador) {
        if (jogador.getDiamantes() < item.getPreco()) {
            return false;
        }
        jogador.adicionarItem(item);
        jogador.setDiamantes(jogador.getDiamantes() - item.getPreco());
        return true;
    }

    public static void usarItem(Item item, Personagem jogador) {
        switch (item.getTipo()) {
            case CONSUMIVEL_CURA:
                jogador.recuperarVida(item.getValorEfeito());
                jogador.removerItem(item);
                break;

            case EQUIPAVEL_ARMA:
                break;

            case EQUIPAVEL_ARMADURA:
                break;
        }
    }



}
