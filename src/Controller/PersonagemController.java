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
        if (opcao != ITEM) {
            if (jogador.getTurnosEnvenenado() > 0) {

                jogador.receberDano(2);

                jogador.setTurnosEnvenenado(
                        jogador.getTurnosEnvenenado() - 1
                );

                PersonagemView.dadosDeEfeitos("veneno");

            }

            if (jogador.getTurnosQueimado() > 0) {

                jogador.receberDano(3);

                jogador.setTurnosQueimado(
                        jogador.getTurnosQueimado() - 1
                );

                PersonagemView.dadosDeEfeitos("queimadura");
            }
            if (!jogador.EstaVivo()) {
                return;
            }
            if (jogador.getTurnosPegajoso() > 0) {

                jogador.setTurnosPegajoso(
                        jogador.getTurnosPegajoso() - 1
                );

                PersonagemView.dadosDeEfeitos("pegajoso");
                return;
            }
        }
        switch (opcao) {
            case DEFENDER:
                jogador.setDefendendo(true);
                PersonagemView.feedbackDeDefesa(jogador);
                break;

            case ITEM:
                PersonagemView.menuInventario(jogador);
                break;

            case ATACAR:
                jogador.setDefendendo(false);
                Inimigo alvo = Sistema.selecionarAlvo(inimigos);
                jogador.atacar(alvo);
                PersonagemView.feedbackDeAtaque(jogador, alvo);
                jogador.danoExtraTemporario = 0;
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
                if (!item.estaEquipado() && jogador.getEquipamento() != null) {
                    jogador.getEquipamento().setEquipado(false);
                    jogador.setEquipamento(null);
                    jogador.equiparItem(item);
                }
                else if (item.estaEquipado() && jogador.getEquipamento() != null)
                    jogador.desequiparItem(item);
                else
                    jogador.equiparItem(item);

                break;

            case EQUIPAVEL_ARMADURA:
                if (!item.estaEquipado() && jogador.getArmadura() != null) {
                    jogador.getArmadura().setEquipado(false);
                    jogador.setArmadura(null);
                    jogador.equiparArmadura(item);
                } else if (item.estaEquipado() && jogador.getArmadura() != null)
                    jogador.desequiparArmadura(item);
                else
                    jogador.equiparArmadura(item);

                break;

            case CONSUMIVEL_FORCA:
                jogador.danoExtraTemporario += item.getValorEfeito();
                jogador.removerItem(item);
        }

        PersonagemView.mostrarInventario(jogador);
    }



}
