package Model;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class Loja {

    HashMap<Item, Float> estoque = new HashMap<>();

    public HashMap<Item, Float> getEstoque() {
        return estoque;
    }

    public void adicionarAoEstoque(Item item, Float valor) {
        estoque.put(item, valor);
    }

}
