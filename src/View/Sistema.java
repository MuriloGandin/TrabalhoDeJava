package View;

import Controller.InimigoController;
import Controller.RodadasController;
import Log.Log;
import Model.*;

import java.security.Key;
import java.util.HashMap;
import java.util.List;

public class Sistema {

    public static void executar() {

        List<Inimigo> inimigos = InimigoCRUD.listarInimigos();

        Inimigo ender = InimigoController.buscarInimigo("ender",  inimigos);
        Inimigo creeper = InimigoController.buscarInimigo("creeper",  inimigos);

        Inimigo[] onda1 = {creeper, ender};

        Onda[] ondas = new Onda[2];
        ondas[0] = new Onda(onda1);

        mostrarMenuInicial();

        Item pocao = new Item("Pocao de cura", Item.tipo.CONSUMIVEL);
        Item espada = new Item("Espada", Item.tipo.EQUIPAVEL);

        Loja loja1 = new Loja();

        loja1.adicionarAoEstoque(pocao, 5f);
        loja1.adicionarAoEstoque(espada, 10f);

        LojaView.menuLoja(loja1);



        String nomePersonagem = InputHelper.lerTexto("Digite o nome do seu personagem: ", 30);
        Personagem jogador = new Personagem(nomePersonagem, 20, 6);

        iniciarOnda(jogador, 1, onda1);

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
                
                                              1 - Jogar
                                              2 - Sair
                """, "amarelo");

        OutputHelper.printGradual(titulo, 3);
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
            }
        } while (op < 1 || op > 2);


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
        OutputHelper.printGradual(jogador.getNome() + "  ❤️: " + jogador.getPontosDeVida() + "\n");

        for (Inimigo inimigo : inimigos) {
            OutputHelper.printGradual(inimigo.getNome() + "  ❤️: " + inimigo.getPontosDeVida() + "\n");
        }
        OutputHelper.printGradual("-------------" + "\n");
        OutputHelper.printGradual("1. Atacar" + "\n");
        OutputHelper.printGradual("2. Defender" + "\n");
        OutputHelper.printGradual("3. Usar Item  [pocoes: " + "]" + "\n");
        OutputHelper.printGradual("-------------" + "\n");
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

        OutputHelper.printGradual(iniciouOnda, "verde");

        for (Inimigo inimigo : inimigos) {
            OutputHelper.printGradual("\nUm " + inimigo.getNome() + " apareceu!", "vermelho");
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
            OutputHelper.printlnColorido("Vitória! A onda " + numOnda + " foi derrotada!", "verde");
        } else {
            OutputHelper.printGradual(jogador.getNome() + " foi derrotado...");
            mostrarFimDeJogo();
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
