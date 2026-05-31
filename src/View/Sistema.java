package View;

import Model.Inimigo;
import Model.Onda;
import Model.Personagem;

import java.util.List;

public class Sistema {
    public static void executar() {

        Inimigo creeper = new Inimigo("Creeper", 6, 7);
        Inimigo ender = new Inimigo("Ender", 15, 5);
        Inimigo zumbi = new Inimigo("Zumbi", 10, 3);
        Inimigo guardiao = new Inimigo("Guardiao", 20, 3);

        Inimigo[] onda1 = {creeper, ender};
        Inimigo[] onda2 = {zumbi, guardiao};

        Onda[] ondas = new Onda[2];
        ondas[0] = new Onda(onda1);

        mostrarMenuInicial();
        InputHelper.scan.nextLine();


        String nomePersonagem = InputHelper.lerTexto("Digite o nome do seu personagem:");
        Personagem jogador = new Personagem(nomePersonagem, 20, 6);

        iniciarOnda(jogador, 1, onda1);

    }

    public static void mostrarMenuInicial() {
        TerminalView.limparTela();

        String titulo = """
                    ███  ██ ██  ██ ██     ██     █████▄ ▄████▄ ██ ███  ██ ██████ ██████ █████▄ \s
                    ██ ▀▄██ ██  ██ ██     ██     ██▄▄█▀ ██  ██ ██ ██ ▀▄██   ██   ██▄▄   ██▄▄██▄\s
                    ██   ██ ▀████▀ ██████ ██████ ██     ▀████▀ ██ ██   ██   ██   ██▄▄▄▄ ██   ██\s
                
                
                                       ▄█████▄ ██  ██ ██████ ▄█████ ██████          \s
                                       ██ ▄ ██ ██  ██ ██▄▄   ▀▀▀▄▄▄   ██            \s
                                       ▀█████▀ ▀████▀ ██▄▄▄▄ █████▀   ██            \s
                                            ▀▀                                      \s
                                             NULLPOINTER QUEST
                
                                        Pressione ENTER para jogar
                """;

        TerminalView.printGradual(titulo, "amarelo");

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

        RodadasView.iniciarCombate(inimigos);

        do {
            ondaEncerrada = true;
            for (Inimigo i : inimigos) {
                if (i.EstaVivo()) {
                    ondaEncerrada = false;
                }
            }

            RodadasView.executarRodada(jogador);

        } while (!ondaEncerrada && jogador.EstaVivo());

        if (jogador.EstaVivo()) {
            TerminalView.printColorido("Vitória! A onda " + numOnda + " foi derrotada!", "verde");
        } else {
            TerminalView.printGradual(jogador.getNome() + " foi derrotado...");
                    TerminalView.printGradual("""


                             ▄████  ▄████▄ ██▄  ▄██ ██████   ▄████▄ ██  ██ ██████ █████▄ \s
                            ██  ▄▄▄ ██▄▄██ ██ ▀▀ ██ ██▄▄     ██  ██ ██▄▄██ ██▄▄   ██▄▄██▄\s
                             ▀███▀  ██  ██ ██    ██ ██▄▄▄▄   ▀████▀  ▀██▀  ██▄▄▄▄ ██   ██\s

                            """, "vermelho");
        }
    }

}
