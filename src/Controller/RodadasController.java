package Controller;

import Model.Inimigo;
import View.RodadasView;

import java.util.List;

public class RodadasController {

    public static int rodada;

    public static void iniciarCombate(List<Inimigo> inimigos) {
        for (Inimigo i : inimigos) {
            RodadasView.inimigosEmCombate.add(i);
        }
        Log.Registrar("Combate Iniciado");
        rodada = 0;
    }

    public static void encerrarCombate(List<Inimigo> inimigos) {
        RodadasView.inimigosEmCombate.clear();
        Log.Registrar("Combate Encerrado");
        rodada = 0;
    }
}
