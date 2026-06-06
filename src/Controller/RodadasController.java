package Controller;

import Model.Inimigo;
import View.RodadasView;

public class RodadasController {

    public static void iniciarCombate(Inimigo[] inimigos) {
        for (Inimigo i : inimigos) {
            RodadasView.inimigosEmCombate.add(i);
        }
    }

    public static void encerrarCombate(Inimigo[] inimigos) {
        RodadasView.inimigosEmCombate.clear();
    }
}
