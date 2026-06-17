package Controller;

import Model.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemController {

    final static String pathItens = "data/Itens.txt";


    public static List<Item> carregarItens() {
        List<Item> resultado = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathItens))) {

            String linha;

            while ((linha = br.readLine()) != null) {
                resultado.add(converterStringParaItem(linha));
            }

        } catch (IOException e) {

            System.out.println("Nenhum item cadastrado");
        } catch (Exception e) {
            System.out.println("Erro ao ler inimigos " + e.getMessage());
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

            Item item = new Item(id, nome, descricao, tipo, efeitoItem, preco);

            return item;
        }
        else return null;
    }

}
