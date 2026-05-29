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


        mostrarMenuInicial();
        InputHelper.scan.nextLine();


        String nomePersonagem = InputHelper.lerTexto("Digite o nome do seu personagem:");
        Personagem jogador = new Personagem(nomePersonagem, 20, 6);

        iniciarOndas(jogador, 3, onda1);

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

    public static Inimigo selecionarAlvo(Inimigo[] alvos) {

        while (true) {
            TerminalView.printGradual("Selecione o alvo: \n");

            for (int i = 0; i < alvos.length; i++) {
                TerminalView.printGradual((i + 1) + "- " + alvos[i].getNome() + "\n", "amarelo");
            }
            int op;

            op = InputHelper.lerNumero();
            if (op <= 0 || op > alvos.length) {
                TerminalView.printGradual("Alvo inválido");

            } else {
                return alvos[op - 1];
            }
        }


    }

    public static void mostrarMenuCombate(Personagem jogador, Inimigo[] inimigos) {
        TerminalView.printGradual("\n--- TURNO ---\n");
        TerminalView.printGradual(jogador.getNome() + "  ❤️: " + jogador.getPontosDeVida() + "\n");

        for (Inimigo inimigo : inimigos) {
            TerminalView.printGradual(inimigo.getNome()  + "  ❤️: " + inimigo.getPontosDeVida() + "\n");
        }
        TerminalView.printGradual("-------------" + "\n");
        TerminalView.printGradual("1. Atacar" + "\n");
        TerminalView.printGradual("2. Defender" + "\n");
        TerminalView.printGradual("3. Usar Item  [pocoes: " + jogador.getPocoes() + "]" + "\n");
        TerminalView.printGradual("-------------" + "\n");
    }

    public static void iniciarOndas(Personagem jogador, int numOndas, Inimigo[] inimigos) {

        for (int onda = 0; onda < numOndas; onda++) {

            String iniciouOnda = """
                  ┌──────────────────────┐
                  │       INICIOU        │
                  │    === Onda\s""" +
                  onda + """
                   ===    │
                  └──────────────────────┘
                  """;

            TerminalView.printGradual(iniciouOnda, "verde");

            for (Inimigo inimigo : inimigos) {
                TerminalView.printGradual("\nUm " + inimigo.getNome() + " apareceu!" , "vermelho");

            }

            int opcao;
            while (true) {

                mostrarMenuCombate(jogador, inimigos);

                opcao = InputHelper.lerNumero("Escolha uma ação (1-3):");

                if (opcao < 1 || opcao > 3) {
                    TerminalView.printGradual("Opção inválida! Escolha entre 1 e 3.");
                    continue;
                }
                break;
            }

            PersonagemController.executarAcao(opcao, jogador, inimigos);





//
//
//        while (jogador.EstaVivo() && inimigo.EstaVivo()) {

//

//            if (inimigo.EstaVivo()) {
//                InimigoController.executarTurnoInimigo(inimigo, jogador); // ← chama o controller
//            }
//
//            InputHelper.lerTexto("\nPressione ENTER para continuar...");
        }

//            if (!jogador.EstaVivo()) {
//                TerminalView.printGradual(jogador.getNome() + " foi derrotado...");
//                    TerminalView.printGradual("""
//
//
//                             ▄████  ▄████▄ ██▄  ▄██ ██████   ▄████▄ ██  ██ ██████ █████▄ \s
//                            ██  ▄▄▄ ██▄▄██ ██ ▀▀ ██ ██▄▄     ██  ██ ██▄▄██ ██▄▄   ██▄▄██▄\s
//                             ▀███▀  ██  ██ ██    ██ ██▄▄▄▄   ▀████▀  ▀██▀  ██▄▄▄▄ ██   ██\s
//
//                            """, "vermelho");
//            } else {
//                TerminalView.printGradual(inimigo.getNome() + " foi derrotado!");
//                continue;
//            }
//            TerminalView.printGradual("----------------");
//        }
    }
}
