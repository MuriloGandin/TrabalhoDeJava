package View;

import Controller.InimigoController;
import Controller.PersonagemController;
import Model.Inimigo;
import Model.Onda;
import Model.Personagem;

public class Sistema {
    public static void executar(){

        Inimigo creeper = new Inimigo("Creeper", 6, 7);
        Inimigo ender = new Inimigo("Ender", 15, 5);
        Inimigo zumbi = new Inimigo("Zumbi", 10, 3);
        Inimigo guardiao = new Inimigo("Guardiao", 20, 3);
        Inimigo[] onda1 = {creeper, ender};
        Inimigo[] onda2 = {zumbi, guardiao};

        Onda[] ondas = new Onda[2];
        ondas[0] = new Onda(onda1);
        ondas[1] = new Onda(onda2);


        mostrarMenuInicial();
        InputHelper.scan.nextLine();



        String nomePersonagem = InputHelper.lerTexto("Digite o nome do seu personagem:");
        Personagem steve = new Personagem(nomePersonagem, 20, 6);
        Ondas(steve, creeper);

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

    public static void mostrarMenuCombate(Personagem jogador, Inimigo inimigo) {
        TerminalView.printGradual("\n--- TURNO ---\n");
        TerminalView.printGradual(jogador.getNome() + "  HP: " + jogador.getPontosDeVida() + "\n");
        TerminalView.printGradual(inimigo.getNome()  + "  HP: " + inimigo.getPontosDeVida() + "\n");
        TerminalView.printGradual("-------------" + "\n");
        TerminalView.printGradual("1. Atacar" + "\n");
        TerminalView.printGradual("2. Defender" + "\n");
        TerminalView.printGradual("3. Usar Item  [pocoes: " + jogador.getPocoes() + "]" + "\n");
        TerminalView.printGradual("-------------" + "\n");
    }

    public static void Ondas(Personagem jogador, Inimigo inimigo) {
        for (int onda = 1; onda <= 3; onda++) {
          String iniciou = """
                  ┌──────────────────────┐
                  │       INICIOU        │
                  │    === Onda\s""" +
                  onda + """
                   ===    │
                  └──────────────────────┘
                  """;

          TerminalView.printGradual(iniciou, "verde");

          TerminalView.printGradual("\nUm " + inimigo.getNome() + " apareceu!");

            while (jogador.EstaVivo() && inimigo.EstaVivo()) {
                mostrarMenuCombate(jogador, inimigo);

                int opcao = InputHelper.lerNumero("Escolha uma ação (1-3):");

                if (opcao < 1 || opcao > 3) {
                    TerminalView.printGradual("Opção inválida! Escolha entre 1 e 3.");
                    continue;
                }

                PersonagemController.executarAcao(opcao, jogador, inimigo); // ← chama o controller

                if (inimigo.EstaVivo()) {
                    InimigoController.executarTurnoInimigo(inimigo, jogador); // ← chama o controller
                }

                InputHelper.lerTexto("\nPressione ENTER para continuar...");
            }

            if (!jogador.EstaVivo()) {
                TerminalView.printGradual(jogador.getNome() + " foi derrotado...");
                    TerminalView.printGradual("""
                        
                            
                             ▄████  ▄████▄ ██▄  ▄██ ██████   ▄████▄ ██  ██ ██████ █████▄ \s
                            ██  ▄▄▄ ██▄▄██ ██ ▀▀ ██ ██▄▄     ██  ██ ██▄▄██ ██▄▄   ██▄▄██▄\s
                             ▀███▀  ██  ██ ██    ██ ██▄▄▄▄   ▀████▀  ▀██▀  ██▄▄▄▄ ██   ██\s
                            
                            """, "vermelho");
            } else {
                TerminalView.printGradual(inimigo.getNome() + " foi derrotado!");
                continue;
            }
            TerminalView.printGradual("----------------");
        }
    }
}
