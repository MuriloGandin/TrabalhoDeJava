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
        if (jogador.getTurnosEnvenenado() > 0) {

            jogador.receberDano(2);

            jogador.setTurnosEnvenenado(
                    jogador.getTurnosEnvenenado() - 1
            );

            OutputHelper.printGradual(
                    "☠ Você sofreu 2 de dano de veneno!\n",
                    "vermelho"
            );
        }

        if (jogador.getTurnosQueimado() > 0) {

            jogador.receberDano(3);

            jogador.setTurnosQueimado(
                    jogador.getTurnosQueimado() - 1
            );

            OutputHelper.printGradual(
                    "🔥 Você sofreu 3 de dano de queimadura!\n",
                    "vermelho"
            );
        }

        if (jogador.getTurnosPegajoso() > 0 &&
                opcao == DEFENDER) {

            jogador.setTurnosPegajoso(0);

            OutputHelper.printGradual(
                    "🟢 Você está pegajoso e não conseguiu se defender!\n",
                    "amarelo"
            );

            opcao = ATACAR;
        }

        if (jogador.getTurnosPegajoso() > 0) {


            jogador.setTurnosPegajoso(
                    jogador.getTurnosPegajoso() - 1
            );

            OutputHelper.printGradual(
                    "🟢 Você está coberto de gosma e perdeu o turno!\n",
                    "amarelo"
            );

            return;
        }

        switch (opcao) {
            case DEFENDER:
                jogador.setDefendendo(true);
                Log.Registrar(jogador.getNome() + " entrou em modo defesa.");
                System.out.println("\n" + jogador.getNome() + " está se defendendo!");
                break;

            case ITEM:
                PersonagemView.menuInventario(jogador);
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
                jogador.danoExtraTemporario = 0;
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
                if (!item.estaEquipado())
                    jogador.equiparItem(item);
                else
                    jogador.desequiparItem(item);
                break;

            case EQUIPAVEL_ARMADURA:
                if (!item.estaEquipado())
                    jogador.equiparArmadura(item);
                else
                    jogador.desequiparItem(item);
                break;

            case CONSUMIVEL_FORCA:
                jogador.danoExtraTemporario += item.getValorEfeito();
                jogador.removerItem(item);
        }

        PersonagemView.mostrarInventario(jogador);
    }



}
