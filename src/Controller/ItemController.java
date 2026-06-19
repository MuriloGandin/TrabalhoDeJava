package Controller;

import Model.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemController {

    final static String pathItens = "data/Itens.txt";

    public static List<Item> itensCadastrados = ItemController.carregarItens();

    public static List<Item> carregarItens() {
        List<Item> resultado = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathItens))) {

            String linha;

            while ((linha = br.readLine()) != null) {
                resultado.add(converterStringParaItem(linha));
            }

        } catch (IOException e) {
            resultado = null;
        } catch (Exception e) {
            return null;
        }

        return resultado;
    }

    public static Item converterStringParaItem(String texto) {
        String[] dados = texto.split(",");
        if (dados.length == 6) {

            int id = Integer.parseInt(dados[0]);
            String nome = dados[1];
            String descricao = dados[2];
            Item.tipo tipo = Item.tipo.valueOf(dados[3]);
            int efeitoItem = Integer.parseInt(dados[4]);
            int preco = Integer.parseInt(dados[5]);

            return new Item(id, nome, descricao, tipo, efeitoItem, preco);
        }
        else return null;
    }

    public static void registrarItem(Item novoItem) {
        try (FileWriter bf = new FileWriter(pathItens, true)){
            String resultado = novoItem.getId() + "," +
                    novoItem.getNome() + "," +
                    novoItem.getDescricao() + "," +
                    novoItem.getTipo() + "," +
                    novoItem.getValorEfeito() + "," +
                    novoItem.getPreco();

            bf.write('\n' + resultado);
            itensCadastrados.add(novoItem);
        } catch (Exception ignored){
            return;
        }
    }

}
