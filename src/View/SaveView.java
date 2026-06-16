package View;

import Controller.Log;
import Controller.SaveController;
import Model.Loja;
import Model.Onda;
import Model.Personagem;

import java.util.List;

public class SaveView {

    public static int ondaInicial = 0;

    public static Personagem menuSave(int opcaoInicial) {
        Personagem jogador;
        if (opcaoInicial == 2 && SaveController.existeSave()) {
            // Continuar
            Object[] save = SaveController.carregar();
            if (save != null) {
                jogador = (Personagem) save[0];
                ondaInicial = (int) save[1];
                OutputHelper.printGradual("Bem-vindo de volta, " + jogador.getNome() + "!\n", "verde");
            } else {
                OutputHelper.printGradual("Erro ao carregar save. Iniciando novo jogo...\n", "vermelho");
                jogador = Sistema.criarNovoPersonagem();
            }
        } else {
            // Novo jogo
            SaveController.deletarSave();
            jogador = Sistema.criarNovoPersonagem();
        }
        return jogador;
    }

    public static void menuContinuarSave(Onda[] ondas, Loja lojaInicial, Personagem jogador) {
        for (int i = ondaInicial; i < ondas.length; i++) {
            LojaView.menuLoja(lojaInicial, jogador);
            boolean continuarJogo = Sistema.iniciarOnda(jogador, (i + 1), ondas[i].getInimigos());

            if (!jogador.EstaVivo()) {
                Sistema.mostrarFimDeJogo();
                return;
            }

            // Após cada onda, perguntar se quer salvar e sair
            if (continuarJogo && i < ondas.length - 1) {
                int op = InputHelper.lerNumero("O que deseja fazer?\n1 - Salvar e continuar\n2 - Salvar e sair\n");
                if (op == 2) {
                    SaveController.salvar(jogador, i + 1);
                    Log.Registrar("Programa encerrado pelo jogador após salvar.");
                    System.exit(0);
                } else SaveController.salvar(jogador, i+1);
            }
        }
    }
}
