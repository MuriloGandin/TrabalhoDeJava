package View;

import Controller.*;
import Model.*;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    public static void executar() {

        Loja lojaInicial = new Loja();

        for (Item i : ItemController.itensCadastrados)
            lojaInicial.adicionarAoEstoque(i);

        mostrarMenuInicial();

        int opcaoInicial = lerOpcaoInicial();

        Personagem jogador = SaveView.menuSave(opcaoInicial);

        SaveView.menuContinuarSave(OndaController.ondas, lojaInicial, jogador);

        if (jogador.EstaVivo()) {
            OutputHelper.printlnColorido("\nParabéns! Você completou o jogo!", "verde");
            SaveController.deletarSave();
        }

        int ondainicial = 1;
        for (int i = ondainicial - 1; i < OndaController.ondas.length; i++) {
            int numOnda = i + 1;
            LojaView.menuLoja(lojaInicial, jogador);
            if (numOnda == 5) {

                String boss = OutputHelper.colorirTexto("""
                    
                                     ██████╗  ██████╗ ███████╗███████╗
                                     ██╔══██╗██╔═══██╗██╔════╝██╔════╝
                                     ██████╔╝██║   ██║███████╗███████╗
                                     ██╔══██╗██║   ██║╚════██║╚════██║
                                     ██████╔╝╚██████╔╝███████║███████║
                                     ╚═════╝  ╚═════╝ ╚══════╝╚══════╝
                    
                                 ╔════════════════════════════════════════════╗
                                 ║              ⚠️  CHEFE FINAL  ⚠️           ║
                                 ╠════════════════════════════════════════════╣
                                 ║        O DRAGÃO DO END APARECEU!           ║
                                 ╚════════════════════════════════════════════╝
                    
                    """, "vermelho");

                OutputHelper.printGradual(boss, 15);

                OutputHelper.printGradualD(
                        "\n                O céu escurece...\n",
                        "amarelo", 39
                );

                OutputHelper.printGradualD(
                        "                As chamas iluminam o campo de batalha...\n",
                        "amarelo", 39
                );

                System.out.print("                🐉 ");
                OutputHelper.printGradualD(
                        "O Dragão abre suas asas e solta um rugido ensurdecedor!\n",
                        "vermelho", 39
                );

                OutputHelper.printGradualD(
                        "\n                ⚔️ Esta é sua última batalha. Derrote o Dragão ou seja destruído!\n\n",
                        "amarelo", 39
                );
            }

            iniciarOnda(jogador, (i+1), OndaController.ondas[i].getInimigos());
        }

    }


    public static Personagem criarNovoPersonagem() {
        String nomePersonagem = InputHelper.lerTexto(OutputHelper.colorirTexto("Digite o nome do seu personagem: ", "ciano"), 30);
        return new Personagem(nomePersonagem, 20, 6);
    }

    public static void mostrarMenuInicial() {
        OutputHelper.limparTela();

        String titulo = OutputHelper.colorirTexto("""
                    ███  ██ ██  ██ ██     ██     █████▄ ▄████▄ ██ ███  ██ ██████ ██████ █████▄ \s
                    ██ ▀▄██ ██  ██ ██     ██     ██▄▄█▀ ██  ██ ██ ██ ▀▄██   ██   ██▄▄   ██▄▄██▄\s
                    ██   ██ ▀████▀ ██████ ██████ ██     ▀████▀ ██ ██   ██   ██   ██▄▄▄▄ ██   ██\s
                
                
                                       ▄█████▄ ██  ██ ██████ ▄█████ ██████          \s
                                       ██ ▄ ██ ██  ██ ██▄▄   ▀▀▀▄▄▄   ██            \s
                                       ▀█████▀ ▀████▀ ██▄▄▄▄ █████▀   ██            \s
                                            ▀▀                                      \s
                                             NULLPOINTER QUEST
                
                """, "amarelo");

        OutputHelper.printGradual(titulo, 3);
    }

    private static int lerOpcaoInicial() {
        boolean temSave = SaveController.existeSave();
        if (temSave) {
            OutputHelper.printGradual("""
                                            1 - Novo Jogo
                                            2 - Continuar
                                            3 - Sair
            """, "amarelo");
            int op;
            do {
                op = InputHelper.lerNumero();
                if (op == 3) {
                    Log.Registrar("Programa encerrado.");
                    System.exit(0);
                }
                if (op < 1 || op > 3)
                    OutputHelper.printlnColorido("Operação inválida!", "vermelho");
            } while (op < 1 || op > 3);
            return op;
        } else {
            OutputHelper.printGradual("""
                                            1 - Novo Jogo
                                            2 - Sair
                    """, "amarelo");
            int op;
            do {
                op = InputHelper.lerNumero();
                if (op == 2) {
                    Log.Registrar("Programa encerrado.");
                    System.exit(0);
                }
                if (op < 1 || op > 2)
                    OutputHelper.printlnColorido("Operação inválida!", "vermelho");
            } while (op < 1 || op > 2);
            return 1;
        }
    }

    public static Inimigo selecionarAlvo(List<Inimigo> alvos) {
        while (true) {
            OutputHelper.printGradual("Selecione o alvo: \n");

            for (int i = 0; i < alvos.size(); i++) {
                OutputHelper.printGradual((i + 1) + "- " + alvos.get(i).getNome() + "\n", "amarelo");
            }
            int op;

            op = InputHelper.lerNumero();
            if (op <= 0 || op > alvos.size()) {
                OutputHelper.printGradual("Alvo inválido");

            } else {
                return alvos.get(op - 1);
            }
        }


    }

    public static void mostrarMenuCombate(Personagem jogador, List<Inimigo> inimigos) {
        OutputHelper.printGradual("\n--- TURNO " + RodadasController.rodada + " ---\n");
        String equipamento = "";
        if (jogador.getEquipamento() != null)
            equipamento += " 🗡️(+" + jogador.getEquipamento().getValorEfeito() + " ATK)";
        if (jogador.getArmadura() != null)
            equipamento += " 🛡️(+"  + jogador.getArmadura().getValorEfeito() + " DEF)";
        OutputHelper.printGradual(jogador.getNome() + "  ❤️: " + jogador.getPontosDeVida() + "/" + jogador.getVidaMax() + equipamento + "\n");

        for (Inimigo inimigo : inimigos) {
            OutputHelper.printGradual(inimigo.getNome() + "  ❤️: " + inimigo.getPontosDeVida() + "/" + inimigo.getVidaMax() + "\n");
        }
        OutputHelper.printGradual("""
                -------------
                1. Atacar
                2. Defender
                3. Usar Item
                -------------
                """);
    }

    public static boolean iniciarOnda(Personagem jogador, int numOnda, List<Inimigo> inimigos) {


        boolean ondaEncerrada;

        String iniciouOnda = """
                ┌──────────────────────┐
                │       INICIOU        │
                │    === Onda\s""" +
                numOnda + """
                 ===    │
                └──────────────────────┘
                """;

        OutputHelper.printGradual(iniciouOnda, "verde");

        for (Inimigo inimigo : inimigos) {
            OutputHelper.printGradual("\nUm " + inimigo.getNome() + " apareceu!", "vermelho");
        }

        RodadasController.iniciarCombate(inimigos);

        do {
            RodadasController.executarRodada(jogador);
            ondaEncerrada = true;
            for (Inimigo i : inimigos) {
                if (i.EstaVivo()) {
                    ondaEncerrada = false;
                    break;
                }
            }



        } while (!ondaEncerrada && jogador.EstaVivo());

        RodadasController.encerrarCombate(inimigos);

        if (jogador.EstaVivo()) {
            jogador.limparEfeitosNegativos();
            OutputHelper.printlnColorido("Vitória! A onda " + numOnda + " foi derrotada!", "verde");
            jogador.setPontosDeVida(Math.min(jogador.getPontosDeVida() + 5, jogador.getVidaMax()));
            OutputHelper.printGradual("Voce ganhou 5 pontos de vida! por derrotar a onda " +  numOnda + ".","verde");
            return true;
        } else {
            OutputHelper.printGradual(jogador.getNome() + " foi derrotado...");
            mostrarFimDeJogo();
            return false;
        }
    }

    public static void mostrarFimDeJogo() {
        OutputHelper.printGradual("""


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
                    Log.Registrar("Programa encerrado.");
                    System.exit(0);

                default:
                    OutputHelper.printlnColorido("Operação inválida!", "vermelho");
                    break;
            }

        } while (op > 2 || op < 1);

        executar();
    }
}
