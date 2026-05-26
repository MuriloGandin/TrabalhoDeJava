package View;

import Model.Inimigo;
import Model.Personagem;

public class Sistema {
    public static void executar(){
        mostrarMenuInicial();
        InputHelper.scan.nextLine();

        Inimigo creeper = new Inimigo("Creeper", 12, 6);

        String nomePersonagem = InputHelper.lerTexto("Digite o nome do seu personagem:");
        Personagem steve = new Personagem(nomePersonagem, 20, 6);
        Ondas();

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

    public static void Ondas(){
        for (int onda = 1; onda <= 1 ; onda++) {

            System.out.println("Onda " + onda);

            int quantidadeDeInimigos = onda * 1; // define quantos enimigos tem por onda //
            for (int inimigos = 0; inimigos < quantidadeDeInimigos ; inimigos++) {

//                Inimigo crepper = new Inimigo("Crepper", 12, 6);

                System.out.println("Inimigo " + (inimigos + 1) + " " +
                        "Apareceu");
            }
            System.out.println("----------------");
        }
    }
}
