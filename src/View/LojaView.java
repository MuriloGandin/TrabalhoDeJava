package View;

import Model.Item;
import Model.Loja;
import Model.Personagem;

import java.util.HashMap;
import java.util.List;

public class LojaView {

    public static void menuLoja(Loja loja, Personagem player) {

        String logista = OutputHelper.colorirTexto("""
                              _____
                            /       \\
                           |  o   o  |
                           |    >    |
                           |  \\___/  |
                            \\_______/
                """, "amarelo");
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

        int op;

        do {
            OutputHelper.printGradual("Seus diamantes: " + player.getDiamantes() + "\n", "verde");
            op = InputHelper.lerNumero("""
                Escolha uma operação:
                1 - Comprar item; 2 - Vender item; 3 - Sair;
                """);

            switch (op) {
                case 1:
                    menuCompra(loja, player);
                    break;

                case 2:
                    menuVenda(loja, player);
                    break;

                case 3:
                    OutputHelper.printGradual("Lojista: Volte sempre!", "verde");
                    break;

                default:
                    OutputHelper.printGradual("Operação inválida");
                    break;
            }

        } while (op < 1 || op > 3);
    }

    public static void menuCompra(Loja loja, Personagem player) {}

    public static void menuVenda(Loja loja, Personagem player) {}

}
