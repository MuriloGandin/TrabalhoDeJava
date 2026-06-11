package Model;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class Loja {

    List<Item> estoque = new ArrayList<>();

    public List<Item> getEstoque() {
        return estoque;
    }

    public void adicionarAoEstoque(Item item) {
        estoque.add(item);
    }

}
