package View;

import Controller.InimigoController;
import Controller.PersonagemController;
import Model.Inimigo;
import Model.Personagem;

public class Sistema {
    public static void executar(){
        mostrarMenuInicial();
        InputHelper.scan.nextLine();

        Inimigo creeper = new Inimigo("Creeper", 12, 6);

        String nomePersonagem = InputHelper.lerTexto("Digite o nome do seu personagem:");
        Personagem steve = new Personagem(nomePersonagem, 20, 6);
        Ondas(steve, creeper);

        System.out.println("Vida do creeper: " + creeper.getPontosDeVida());
        System.out.println("Pressione enter para atacar");
        InputHelper.scan.nextLine();
        steve.atacar(creeper);
        System.out.println("Vida do creeper: " + creeper.getPontosDeVida());

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

        try {
            TerminalView.printGradual(titulo, "amarelo");
        } catch (InterruptedException e) {
            return;
        }
    }

    public static void mostrarMenuCombate(Personagem jogador, Inimigo inimigo) {
        System.out.println("\n--- TURNO ---");
        System.out.println(jogador.getNome() + "  HP: " + jogador.getPontosDeVida());
        System.out.println(inimigo.getNome()  + "  HP: " + inimigo.getPontosDeVida());
        System.out.println("-------------");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Usar Item  [pocoes: " + jogador.getPocoes() + "]");
        System.out.println("-------------");
    }

    public static void Ondas(Personagem jogador, Inimigo inimigo) {
        for (int onda = 1; onda <= 1; onda++) {
            System.out.println("\n=== Onda " + onda + " ===");
            System.out.println("Um " + inimigo.getNome() + " apareceu!");

            while (jogador.EstaVivo() && inimigo.EstaVivo()) {
                mostrarMenuCombate(jogador, inimigo);

                int opcao = InputHelper.lerNumero("Escolha uma ação (1-3):");

                if (opcao < 1 || opcao > 3) {
                    System.out.println("Opção inválida! Escolha entre 1 e 3.");
                    continue;
                }

                PersonagemController.executarAcao(opcao, jogador, inimigo); // ← chama o controller

                if (inimigo.EstaVivo()) {
                    InimigoController.executarTurnoInimigo(inimigo, jogador); // ← chama o controller
                }

                InputHelper.lerTexto("\nPressione ENTER para continuar...");
            }

            if (jogador.EstaVivo()) {
                System.out.println("\nVoce venceu a onda " + onda + "!");
            } else {
                System.out.println("\nVoce foi derrotado...");
                break;
            }

            System.out.println("----------------");
        }
    }
}
