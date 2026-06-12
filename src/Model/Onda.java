package Model;

import java.util.ArrayList;
import java.util.List;

public class Onda {
    private List<Inimigo> inimigos = new ArrayList<Inimigo>();

    public Onda(Inimigo[] inimigos) {
        addInimigos(inimigos);
    }

    public void addInimigo(Inimigo inimigo) {
        inimigos.add(inimigo);
    }

    public void addInimigos(List<Inimigo> inimigos) {
        for (Inimigo inimigo : inimigos) {
            addInimigo(inimigo);
        }
    }

    public void addInimigos(Inimigo[] inimigos) {
        for (Inimigo inimigo : inimigos) {
            addInimigo(inimigo);
        }
    }

    public List<Inimigo> getInimigos() {
        return inimigos;
    }
}
