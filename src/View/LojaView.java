package View;

import Controller.PersonagemController;
import Model.Item;
import Model.Loja;
import Model.Personagem;

import java.util.HashMap;
import java.util.List;

public class LojaView {

    public static void menuLoja(Loja loja, Personagem jogador) {

        int op;
        String logista = OutputHelper.colorirTexto("""
                              _____
                            /       \\
                           |  o   o  |
                           |    >    |
                           |  \\___/  |
                            \\_______/
                """, "amarelo");

        OutputHelper.printGradual(logista, 2);
        OutputHelper.printGradual("Lojista: Seja bem-vindo a loja! ", "verde");

        do {
            OutputHelper.printGradual("Você tem: ");
            OutputHelper.printGradual("" + jogador.getDiamantes(), "azul");
            OutputHelper.printGradual("💎\n");
            OutputHelper.printGradual("Dica: comprar poções pode salvar sua vida!\n","azul");
            op = InputHelper.lerNumero("""
                Escolha uma operação:
                1 - 💲 Comprar item 💲; | 2 - 💎 Vender item 💎; | 3 - ⚔️ Ir para o combate ⚔️;
                """, 2);

            switch (op) {
                case 1:
                    menuCompra(loja, jogador);
                    break;

                case 2:
                    menuVenda(loja, jogador);
                    break;

                case 3:
                    OutputHelper.printGradual("Lojista: Volte sempre!\n", "verde");
                    break;

                default:
                    OutputHelper.printGradual("Operação inválida");
                    break;
            }

        } while (op != 3);
    }

    public static void menuCompra(Loja loja, Personagem jogador) {
        int op;

        String titulo = OutputHelper.colorirTexto(""" 
                    ╷  ╭─╮ ╭╮╭─╮   ╶┬╮╭─╴   ╷╶┬╴╭─╴╭╮╷╭─╮
                    │  │ │  │├─┤    ││├╴    │ │ ├╴ │╰┤╰─╮
                    ╰─╴╰─╯╰─╯╵ ╵   ╶┴╯╰─╴   ╵ ╵ ╰─╴╵ ╵╰─╯
              ┌───────────────────────────────────────────────┐
                """, "azul");

        OutputHelper.printGradual(titulo, 1);

        for (int i = 0; i < loja.getEstoque().size(); i++) {
            Item item = loja.getEstoque().get(i);
            OutputHelper.printGradual( "Item " + (i+1) + ": " + item.getNome() + " - " , 2);
            OutputHelper.printGradual( OutputHelper.colorirTexto("Preço: " + item.getPreco(), "verde") , 2);
            OutputHelper.printGradual( "💎\n");

        }

        OutputHelper.printGradual(OutputHelper.colorirTexto("└───────────────────────────────────────────────┘\n", "azul"), 1);

        do {
            OutputHelper.printGradual("Você tem: ");
            OutputHelper.printGradual("" + jogador.getDiamantes(), "azul");
            OutputHelper.printGradual("💎\n");
            op = InputHelper.lerNumero("Insira o número do item que deseja comprar: ");

        } while (op < 1 || op > loja.getEstoque().size());

        Item itemSelecionado = loja.getEstoque().get(op-1);

        Item i = new Item(itemSelecionado.getId(), itemSelecionado.getNome(), itemSelecionado.getTipo(), itemSelecionado.getValorEfeito(), itemSelecionado.getPreco());

        if (PersonagemController.comprarItem(i, jogador)) {
            OutputHelper.printGradual(i.getNome() + " comprado com sucesso!\n", "verde");
            return;
        }
        OutputHelper.printGradual("Você não tem diamantes o suficiente para comprar este item!\n", "vermelho");
    }

    public static void menuVenda(Loja loja, Personagem jogador) {
        List<Item> inventario = jogador.getInventario();
        if (inventario.isEmpty()) {
            OutputHelper.printColorido("Seu inventário está vazio!\n", "vermelho");
            return;
        }
        OutputHelper.printColorido("Itens só podem ser vendidos a 60% do preço original\n", "amarelo");
        OutputHelper.printGradual("=== Inventário ===\n", "azul");
        for (int i = 0; i < jogador.getInventario().size(); i++) {
            Item item = inventario.get(i);
            OutputHelper.printGradual((i+1) + ". " + item.getNome() + " - Preço de venda: " + Math.round(item.getPreco() * 0.6) + "\n");
        }

        String input;
        int op;

        do {

            input = InputHelper.lerTexto("Insira o número do item que deseja vender (ou C para cancelar): ");
            if (input.equalsIgnoreCase("c"))
                return;

            try {
                op = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                return;
            }

        } while (op < 1 || op > inventario.size());

        Item produto = inventario.get(op-1);
        int preco = (int) Math.round(produto.getPreco() * 0.7);
        jogador.setDiamantes(jogador.getDiamantes() + preco);
        produto.setEquipado(false);
        OutputHelper.printColorido(produto.getNome() + " vendido com sucesso!\n", "verde");
        jogador.removerItem(produto);
    }
}
