package View;

import Controller.InimigoController;
import Controller.Log;
import Controller.PersonagemController;
import Controller.RodadasController;
import Model.Inimigo;
import Model.Personagem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RodadasView {

    public static int menuRodada(Personagem jogador) {
        int opcao;
        while (true) {
            Sistema.mostrarMenuCombate(jogador, RodadasController.inimigosEmCombate);

            opcao = InputHelper.lerNumero("Escolha uma ação (1-3): ");

            if (opcao < 1 || opcao > 3) {
                OutputHelper.printGradual("Opção inválida! Escolha entre 1 e 3.");
                continue;
            }
            return opcao;
        }
    }

    public static void mostrarGanhoDeDiamantes(Personagem jogador, int DiamantesAleatorios, Inimigo i) {
        Log.Registrar(jogador.getNome() + " Ganhou " + DiamantesAleatorios + " Diamantes");
        OutputHelper.printGradual("\nVoce ganhou 💎 " + DiamantesAleatorios + " Diamantes Apos Derrotar " + i.getNome());
    }

    public static void mostrarInimigoDerrotado(Inimigo i) {
        OutputHelper.printGradual( "O inimigo " + i.getNome() + " foi derrotado!","amarelo");
    }


}
