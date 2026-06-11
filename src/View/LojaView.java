package View;

import Model.Item;
import Model.Loja;
import Model.Personagem;

import java.util.HashMap;

public class LojaView {

    public static void menuLoja(Loja loja, Personagem player) {

        String logista = """
                              _____
                            /       \\
                           |  o   o  |
                           |    >    |
                           |  \\___/  |
                            \\_______/
                             .----.
                             |    |
                           __|____|__
                          |  ______--|
                          `-/.::::.\\-'
                           `--------'
                """;
         String titulo = OutputHelper.colorirTexto("""
                
                
                ╷  ╭─╮ ╭╮╭─╮   ╶┬╮╭─╴   ╷╶┬╴╭─╴╭╮╷╭─╮
                │  │ │  │├─┤    ││├╴    │ │ ├╴ │╰┤╰─╮
                ╰─╴╰─╯╰─╯╵ ╵   ╶┴╯╰─╴   ╵ ╵ ╰─╴╵ ╵╰─╯
              ┌───────────────────────────────────────────────┐
                """, "azul");

        OutputHelper.printGradual(logista, 2);
        OutputHelper.printGradual("Lojista: Seja bem-vindo a loja! ", "verde");
        OutputHelper.printGradual(titulo, 1);

        for (int i = 0; i < loja.getEstoque().size(); i++) {
            Item item = loja.getEstoque().get(i);
            OutputHelper.printGradual( "Item " + (i+1) + ": " + item.getNome() + " - Preço: " + item.getPreco() + " diamantes\n", "azul");
        }

        OutputHelper.printGradual(OutputHelper.colorirTexto("└───────────────────────────────────────────────┘\n", "azul"), 1);


        OutputHelper.printGradual("Seus diamantes: " + player.getDiamantes() + "\n", "verde");

    }
}
