package View;

import Controller.Log;
import Controller.SaveController;
import Model.Loja;
import Model.Onda;
import Model.Personagem;

public class SaveView {

    private static int ondaInicial = 0; // privado — só esta classe acessa

    public static int getOndaInicial() { return ondaInicial; }

    // ── Carrega ou cria personagem dependendo da opção do menu ────────────────

    public static Personagem menuSave(int opcaoInicial) {
        if (opcaoInicial == 2 && SaveController.existeSave()) {
            return tentarCarregarSave();
        }
        SaveController.deletarSave();
        ondaInicial = 0;
        return Sistema.criarNovoPersonagem();
    }

    private static Personagem tentarCarregarSave() {
        OutputHelper.printGradual("\nCarregando save...\n", "amarelo");
        Object[] save = SaveController.carregar();

        if (save != null) {
            Personagem jogador = (Personagem) save[0];
            ondaInicial = (int) save[1];
            OutputHelper.printGradual("Bem-vindo de volta, ", "verde");
            OutputHelper.printGradual(jogador.getNome() + "!\n", "amarelo");
            OutputHelper.printGradual("Retomando da onda " + (ondaInicial + 1) + "...\n", "verde");
            return jogador;
        }

        OutputHelper.printGradual("Erro ao carregar save. Iniciando novo jogo...\n", "vermelho");
        ondaInicial = 0;
        return Sistema.criarNovoPersonagem();
    }


    public static void menuContinuarSave(Onda[] ondas, Loja lojaInicial, Personagem jogador) {
        for (int i = ondaInicial; i < ondas.length; i++) {
            LojaView.menuLoja(lojaInicial, jogador);

            boolean venceuOnda = Sistema.iniciarOnda(jogador, (i + 1), ondas[i].getInimigos());

            if (!venceuOnda || !jogador.EstaVivo()) return;

            // Não pergunta na última onda
            boolean ultimaOnda = (i == ondas.length - 1);
            if (!ultimaOnda) {
                menuPosSave(jogador, i);
            }
        }
    }


    private static void menuPosSave(Personagem jogador, int ondaAtual) {
        OutputHelper.printGradual("\n╔══════════════════════════════╗\n", "azul");
        OutputHelper.printGradual(  "║        O que deseja?         ║\n", "azul");
        OutputHelper.printGradual(  "║  1 - Salvar e continuar      ║\n", "azul");
        OutputHelper.printGradual(  "║  2 - Salvar e sair           ║\n", "azul");
        OutputHelper.printGradual(  "╚══════════════════════════════╝\n", "azul");

        int op;
        do {
            op = InputHelper.lerNumero();
            if (op < 1 || op > 2)
                OutputHelper.printlnColorido("Opção inválida!", "vermelho");
        } while (op < 1 || op > 2);

        SaveController.salvar(jogador, ondaAtual + 1);

        if (op == 2) {
            OutputHelper.printGradual("\nJogo salvo! Até logo!\n", "verde");
            Log.Registrar("Programa encerrado pelo jogador após salvar.");
            System.exit(0);
        }

        OutputHelper.printGradual("Jogo salvo! Boa sorte na próxima onda!\n", "verde");
    }
}