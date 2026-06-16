package View;

import Controller.PersonagemController;
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
            OutputHelper.printGradual((i+1) + ". " + item.getNome() + " - " + tipo + equipado + "\n", "azul");
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
                        op = InputHelper.lerNumero("Insira o número do item que deseja usar: ");
                    } while (op < 1 || op > jogador.getInventario().size());
                    Item item = jogador.getInventario().get(op-1);

                    PersonagemController.usarItem(item, jogador);
                    break;

                case 2:
                    break;
            }

        } while (opcao != 2);
    }
}
