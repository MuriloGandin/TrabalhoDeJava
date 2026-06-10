package View;

import Controller.InimigoController;
import Controller.PersonagemController;
import Controller.RodadasController;
import Model.Inimigo;
import Model.Personagem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RodadasView {

    public static List<Inimigo> inimigosEmCombate = new ArrayList<>();

    public static int menuRodada(Personagem jogador) {
        int opcao;
        while (true) {

            // Ação do jogador

            Sistema.mostrarMenuCombate(jogador, inimigosEmCombate);

            opcao = InputHelper.lerNumero("Escolha uma ação (1-3): ");

            if (opcao < 1 || opcao > 3) {
                OutputHelper.printGradual("Opção inválida! Escolha entre 1 e 3.");
                continue;
            }
            return opcao;
        }
    }

    public static void executarRodada(Personagem jogador) {

        RodadasController.rodada++;

        if (inimigosEmCombate.isEmpty()) {
            return;
        }

        // Turno do personagem
        int opcao = menuRodada(jogador);

        PersonagemController.executarAcao(opcao, jogador, inimigosEmCombate);

        // Ação do inimigo + menu inimigo derrotado

        if (!inimigosEmCombate.isEmpty()) {

            Iterator<Inimigo> it = inimigosEmCombate.iterator();

            while (it.hasNext()) {
                Inimigo i = it.next();

                if (!i.EstaVivo()) {
                    OutputHelper.printGradual( "O inimigo " + i.getNome() + " foi derrotado!");
                    it.remove();
                }
            }
        }

        if (!inimigosEmCombate.isEmpty()){
            InimigoController.executarTurnoInimigos(inimigosEmCombate, jogador);
        }

        InputHelper.lerTexto("\nPressione ENTER para continuar...");
    }



}
