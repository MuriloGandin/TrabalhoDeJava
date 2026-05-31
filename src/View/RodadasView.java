package View;

import Controller.InimigoController;
import Controller.PersonagemController;
import Model.Inimigo;
import Model.Personagem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RodadasView {

    public static List<Inimigo> inimigosEmCombate = new ArrayList<>();

    public static void executarRodada(Personagem jogador) {

        if (inimigosEmCombate.isEmpty()) {
            return;
        }

        int opcao;
        while (true) {

            // Ação do jogador

            Sistema.mostrarMenuCombate(jogador, inimigosEmCombate);

            opcao = InputHelper.lerNumero("Escolha uma ação (1-3): ");

            if (opcao < 1 || opcao > 3) {
                TerminalView.printGradual("Opção inválida! Escolha entre 1 e 3.");
                continue;
            }
            break;
        }

        PersonagemController.executarAcao(opcao, jogador, inimigosEmCombate);

        // Ação do inimigo


        if (!inimigosEmCombate.isEmpty()) {

            Iterator<Inimigo> it = inimigosEmCombate.iterator();

            while (it.hasNext()) {
                Inimigo i = it.next();

                if (!i.EstaVivo()) {
                    TerminalView.printGradual("O inimigo " + i.getNome() + " foi derrotado!");
                    it.remove();
                }
            }
        }

        if (!inimigosEmCombate.isEmpty()){
            InimigoController.executarTurnoInimigos(inimigosEmCombate, jogador);
        }

        InputHelper.lerTexto("\nPressione ENTER para continuar...");
    }

    public static void iniciarCombate(Inimigo[] inimigos) {
        for (Inimigo i : inimigos) {
            inimigosEmCombate.add(i);
        }
    }

}
