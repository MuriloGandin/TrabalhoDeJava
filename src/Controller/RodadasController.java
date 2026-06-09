package Controller;

import Log.Log;
import Model.Inimigo;
import View.RodadasView;

public class RodadasController {

    public static int rodada;

    public static void iniciarCombate(Inimigo[] inimigos) {
        for (Inimigo i : inimigos) {
            RodadasView.inimigosEmCombate.add(i);
        }
        Log.Registrar("Combate Iniciado");
        rodada = 0;
    }

    public static void encerrarCombate(Inimigo[] inimigos) {
        RodadasView.inimigosEmCombate.clear();
        Log.Registrar("Combate Encerrado");
        rodada = 0;
    }
}
