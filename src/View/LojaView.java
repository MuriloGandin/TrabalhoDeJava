package View;

import Model.Item;
import Model.Loja;

import java.util.HashMap;

public class LojaView {

    public static void menuLoja(Loja loja) {
        for (HashMap.Entry<Item, Float> item : loja.getEstoque().entrySet()) {
            System.out.println("Item: " + item.getKey().getDescricao() + " - " + item.getValue());
        }

    }
}
