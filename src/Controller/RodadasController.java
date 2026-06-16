package Controller;

import Model.Inimigo;
import Model.Personagem;
import View.InputHelper;
import View.RodadasView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RodadasController {

    public static List<Inimigo> inimigosEmCombate = new ArrayList<>();
    public static int rodada;

    public static void iniciarCombate(List<Inimigo> inimigos) {
        for (Inimigo i : inimigos) {
            inimigosEmCombate.add(i);
        }
        Log.Registrar("Combate Iniciado");
        rodada = 0;
    }

    public static void executarRodada(Personagem jogador) {

        RodadasController.rodada++;

        if (inimigosEmCombate.isEmpty()) {
            return;
        }

        // Turno do personagem
        int opcao;

        do {
            opcao = RodadasView.menuRodada(jogador);
            PersonagemController.executarAcao(opcao, jogador, inimigosEmCombate);
        } while (opcao == 3);

        // Ação do inimigo + menu inimigo derrotado

        if (!inimigosEmCombate.isEmpty()) {

            Iterator<Inimigo> it = inimigosEmCombate.iterator();

            while (it.hasNext()) {
                Inimigo i = it.next();

                if (!i.EstaVivo()) {
                    RodadasView.mostrarInimigoDerrotado(i);
                    int diamantesAleatorios = InimigoController.SortearMoedas(i);
                    jogador.AdicionarDiamantes(diamantesAleatorios);
                    RodadasView.mostrarGanhoDeDiamantes(jogador, diamantesAleatorios, i);

                    it.remove();
                }
            }
        }

        if (!inimigosEmCombate.isEmpty()){
            InimigoController.executarTurnoInimigos(inimigosEmCombate, jogador);
        }

        InputHelper.insiraEnter();
    }

    public static void encerrarCombate(List<Inimigo> inimigos) {
        inimigosEmCombate.clear();
        Log.Registrar("Combate Encerrado");
        rodada = 0;
    }
}
