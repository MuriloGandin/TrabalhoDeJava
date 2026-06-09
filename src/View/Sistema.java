package View;

import Controller.RodadasController;
import Model.Inimigo;
import Model.InimigoCRUD;
import Model.Onda;
import Model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    public static void executar() {


        List<Inimigo> inimigos = InimigoCRUD.listarInimigos();

        Inimigo ender = inimigos.get(0);
        Inimigo creeper = inimigos.get(1);
        Inimigo zumbi = new Inimigo("Zumbi", 10, 3);
        Inimigo guardiao = new Inimigo("Guardiao", 20, 3);


        for (Inimigo i : inimigos) {
            i.exibirInfo();
        }

        Inimigo[] onda1 = {creeper, ender};
        Inimigo[] onda2 = {zumbi, guardiao};

        Onda[] ondas = new Onda[2];
        ondas[0] = new Onda(onda1);

        mostrarMenuInicial();

        String nomePersonagem = InputHelper.lerTexto("Digite o nome do seu personagem: ", 30);
        Personagem jogador = new Personagem(nomePersonagem, 20, 6);

        iniciarOnda(jogador, 1, onda1);

    }

    public static void mostrarMenuInicial() {
        TerminalView.limparTela();

        String titulo = TerminalView.colorirTexto("""
                    ███  ██ ██  ██ ██     ██     █████▄ ▄████▄ ██ ███  ██ ██████ ██████ █████▄ \s
                    ██ ▀▄██ ██  ██ ██     ██     ██▄▄█▀ ██  ██ ██ ██ ▀▄██   ██   ██▄▄   ██▄▄██▄\s
                    ██   ██ ▀████▀ ██████ ██████ ██     ▀████▀ ██ ██   ██   ██   ██▄▄▄▄ ██   ██\s
                
                
                                       ▄█████▄ ██  ██ ██████ ▄█████ ██████          \s
                                       ██ ▄ ██ ██  ██ ██▄▄   ▀▀▀▄▄▄   ██            \s
                                       ▀█████▀ ▀████▀ ██▄▄▄▄ █████▀   ██            \s
                                            ▀▀                                      \s
                                             NULLPOINTER QUEST
                
                                              1 - Jogar
                                              2 - Sair
                """, "amarelo");

        TerminalView.printGradual(titulo, 3);
        int op;
        do {
            op = InputHelper.lerNumero();

            switch (op) {
                case 1:
                    break;
                case 2:
                    System.exit(0);
                default:
                    TerminalView.printlnColorido("Operação inválida!", "vermelho");
            }
        } while (op < 1 || op > 2);


    }


    public static Inimigo selecionarAlvo(List<Inimigo> alvos) {

        while (true) {
            TerminalView.printGradual("Selecione o alvo: \n");

            for (int i = 0; i < alvos.size(); i++) {
                TerminalView.printGradual((i + 1) + "- " + alvos.get(i).getNome() + "\n", "amarelo");
            }
            int op;

            op = InputHelper.lerNumero();
            if (op <= 0 || op > alvos.size()) {
                TerminalView.printGradual("Alvo inválido");

            } else {
                return alvos.get(op - 1);
            }
        }


    }

    public static void mostrarMenuCombate(Personagem jogador, List<Inimigo> inimigos) {
        TerminalView.printGradual("\n--- TURNO ---\n");
        TerminalView.printGradual(jogador.getNome() + "  ❤️: " + jogador.getPontosDeVida() + "\n");

        for (Inimigo inimigo : inimigos) {
            TerminalView.printGradual(inimigo.getNome() + "  ❤️: " + inimigo.getPontosDeVida() + "\n");
        }
        TerminalView.printGradual("-------------" + "\n");
        TerminalView.printGradual("1. Atacar" + "\n");
        TerminalView.printGradual("2. Defender" + "\n");
        TerminalView.printGradual("3. Usar Item  [pocoes: " + jogador.getPocoes() + "]" + "\n");
        TerminalView.printGradual("-------------" + "\n");
    }

    public static void iniciarOnda(Personagem jogador, int numOnda, Inimigo[] inimigos) {


        boolean ondaEncerrada;

        String iniciouOnda = """
                ┌──────────────────────┐
                │       INICIOU        │
                │    === Onda\s""" +
                numOnda + """
                 ===    │
                └──────────────────────┘
                """;

        TerminalView.printGradual(iniciouOnda, "verde");

        for (Inimigo inimigo : inimigos) {
            TerminalView.printGradual("\nUm " + inimigo.getNome() + " apareceu!", "vermelho");
        }

        RodadasController.iniciarCombate(inimigos);

        do {
            ondaEncerrada = true;
            for (Inimigo i : inimigos) {
                if (i.EstaVivo()) {
                    ondaEncerrada = false;
                }
            }

            RodadasView.executarRodada(jogador);

        } while (!ondaEncerrada && jogador.EstaVivo());

        RodadasController.encerrarCombate(inimigos);

        if (jogador.EstaVivo()) {
            TerminalView.printlnColorido("Vitória! A onda " + numOnda + " foi derrotada!", "verde");
        } else {
            TerminalView.printGradual(jogador.getNome() + " foi derrotado...");
            mostrarFimDeJogo();
        }
    }

    public static void mostrarFimDeJogo() {
        TerminalView.printGradual("""


                             ▄████  ▄████▄ ██▄  ▄██ ██████   ▄████▄ ██  ██ ██████ █████▄ \s
                            ██  ▄▄▄ ██▄▄██ ██ ▀▀ ██ ██▄▄     ██  ██ ██▄▄██ ██▄▄   ██▄▄██▄\s
                             ▀███▀  ██  ██ ██    ██ ██▄▄▄▄   ▀████▀  ▀██▀  ██▄▄▄▄ ██   ██\s

                                                   1 - Jogar novamente
                                                        2 - Sair
                            """, "vermelho");
        int op;

        do {
            op = InputHelper.lerNumero();

            switch (op) {
                case 1:
                    break;

                case 2:
                    System.exit(0);

                default:
                    TerminalView.printlnColorido("Operação inválida!", "vermelho");
                    break;
            }

        } while (op > 2 || op < 1);

        executar();
    }

}
