package View;

import Model.Item;
import Model.Personagem;

public class PersonagemView {

    public static void mostrarInventario(Personagem jogador) {
        OutputHelper.printGradual("==== Inventário ====", "verde");
        for (Item i : jogador.getInventario()) {
            String tipo;
            switch (i.getTipo()) {
                case EQUIPAVEL_ARMA -> tipo = "Equipável";
                case CONSUMIVEL_CURA -> tipo = "Consumível";
                case EQUIPAVEL_ARMADURA -> tipo = "Armadura";
            }
            OutputHelper.printGradual(i.getNome() + " - "+ i.getTipo());
        }
    }
}
