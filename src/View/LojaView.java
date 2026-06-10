package View;

import Model.Item;
import Model.Loja;

import java.util.HashMap;

public class LojaView {

    public static void menuLoja(Loja loja) {

        String logista = """
                
                """;

        String titulo = OutputHelper.colorirTexto("""
                
                
                ╷  ╭─╮ ╭╮╭─╮   ╶┬╮╭─╴   ╷╶┬╴╭─╴╭╮╷╭─╮
                │  │ │  │├─┤    ││├╴    │ │ ├╴ │╰┤╰─╮
                ╰─╴╰─╯╰─╯╵ ╵   ╶┴╯╰─╴   ╵ ╵ ╰─╴╵ ╵╰─╯
              ┌───────────────────────────────────────┐
                """, "azul");

        OutputHelper.printGradual(titulo, 1);

        for (HashMap.Entry<Item, Float> item : loja.getEstoque().entrySet()) {
            OutputHelper.printGradual(" Item: " + item.getKey().getDescricao() + " - Preço: " + item.getValue() + "\n", "azul");
        }

        OutputHelper.printGradual(OutputHelper.colorirTexto("└───────────────────────────────────────┘\n", "azul"), 1);

        OutputHelper.printGradual("Lojista: Seja bem-vindo a loja! ", "verde");

    }
}
