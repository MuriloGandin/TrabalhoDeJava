package View;

import Controller.Log;
import Controller.PersonagemController;
import Model.Inimigo;
import Model.Item;
import Model.Personagem;

public class PersonagemView {

    public static void menuInventario(Personagem jogador) {
        if (jogador.getInventario().isEmpty()){
            OutputHelper.printColorido("Seu inventário está vazio", "vermelho");
            return;
        }
        mostrarInventario(jogador);
        operacaoInventario(jogador);
    }

    public static void mostrarInventario(Personagem jogador) {

        OutputHelper.printGradual("==== Inventário ====\n", "verde");

        for (int i = 0; i < jogador.getInventario().size(); i++) {

            Item item = jogador.getInventario().get(i);
            String tipo = "";
            String equipado = item.estaEquipado() ? " <Equipado> " : "";
            switch (item.getTipo()) {
                case EQUIPAVEL_ARMA -> tipo = "Equipável";
                case CONSUMIVEL_CURA, CONSUMIVEL_FORCA -> tipo = "Consumível";
                case EQUIPAVEL_ARMADURA -> tipo = "Armadura";
            }
            OutputHelper.printGradual(OutputHelper.colorirTexto((i+1) + ". " + item.getNome() + " - " + tipo + equipado + "\n", "azul"), 3);
        }
    }

    public static void operacaoInventario(Personagem jogador) {
        int opcao;

        do {
            opcao = InputHelper.lerNumero("""
                    1 - Usar item
                    2 - Voltar
                    """);

            switch (opcao) {
                case 1:
                    int op;

                    do {
                        op = InputHelper.lerNumero("Insira o número do item que deseja usar (0 para cancelar): ");
                    } while (op < 0 || op > jogador.getInventario().size());
                    if (op == 0)
                        return;

                    Item item = jogador.getInventario().get(op-1);

                    PersonagemController.usarItem(item, jogador);
                    break;

                case 2:
                    break;

            }

        } while (opcao != 2);
    }

    public static void dadosDeEfeitos(String efeito) {

        switch (efeito) {
            case "veneno":
                OutputHelper.printGradual(
                        "☠ Você sofreu 2 de dano de veneno!\n",
                        "vermelho"
                );
                break;

            case "queimadura":
                OutputHelper.printGradual(
                    "🔥 Você sofreu 3 de dano de queimadura!\n",
                    "vermelho"
                );
                break;

            case "pegajoso":
                OutputHelper.printGradual(
                        "🟢 Você está coberto de gosma e perdeu o turno!\n",
                        "amarelo"
                );
        }

    }

    public static void feedbackDeDefesa(Personagem jogador) {
                Log.Registrar(jogador.getNome() + " entrou em modo defesa.");
                System.out.println("\n" + jogador.getNome() + " está se defendendo!");
    }

    public static void feedbackDeAtaque(Personagem jogador, Inimigo alvo) {
        System.out.println("O jogador " + jogador.getNome() + " atacou " + alvo.getNome() + " e causou " + jogador.getDano() + " de dano!");
        Log.Registrar(
                jogador.getNome() +
                        " atacou " +
                        alvo.getNome() +
                        " causando " +
                        jogador.getDano() +
                        " de dano."
        );
        OutputHelper.printGradual(alvo.getNome() + " ficou com " + alvo.getPontosDeVida() + " pontos de vida!\n", "amarelo");
    }
}
