package View;

import Controller.Log;
import Model.Inimigo;
import Model.Personagem;

public class InimigoView {

    public static void feedbackAtaqueNormal(Inimigo inimigo, Personagem jogador, int dano) {
        OutputHelper.printGradual(
                "\n" + inimigo.getNome() + " atacou " + jogador.getNome() +
                        " e causou " + dano + " de dano!\n",
                "vermelho"
        );

        Log.Registrar(
                inimigo.getNome() +
                        " atacou " +
                        jogador.getNome() +
                        " causando " +
                        dano +
                        " de dano."
        );
    }
    public static void feedbackAtaqueEspecial(Inimigo inimigo, int dano) {

        switch (inimigo.getTipoAtaqueEspecial()) {

            case "GRITO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " soltou um grito assustador e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "PULO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " pulou em você e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "MORDIDA":
                OutputHelper.printGradual(
                        inimigo.getNome() + " mordeu você e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "FLECHADA":
                OutputHelper.printGradual(
                        inimigo.getNome() + " acertou uma flechada e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "VENENO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " envenenou você e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "DESIDRATACAO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " causou desidratação e deu " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "TRIDENTE":
                OutputHelper.printGradual(
                        inimigo.getNome() + " lançou um tridente e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "SOMBRIO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " usou ataque sombrio e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "EXPLOSAO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " explodiu e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "POCAO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " lançou uma poção e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "BOLA_DE_FOGO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " lançou uma bola de fogo e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "MACHADADA":
                OutputHelper.printGradual(
                        inimigo.getNome() + " deu uma machadada e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "MAGIA":
                OutputHelper.printGradual(
                        inimigo.getNome() + " usou magia e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "LENTIDAO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " usou lentidão e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            case "BAFORADA_DO_DRAGAO":
                OutputHelper.printGradual(
                        inimigo.getNome() + " soltou uma baforada de dragão e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
                break;

            default:
                OutputHelper.printGradual(
                        inimigo.getNome() + " usou um ataque especial e causou " + dano + " de dano!!\n",
                        "vermelho"
                );
        }
        Log.Registrar(
                inimigo.getNome() +
                        " usou ataque especial causando " +
                        dano +
                        " de dano."
        );
    }

    public static void feedbackDefesaNormal(Personagem jogador) {
        OutputHelper.printGradual(
                "\nDefesa ativada! Dano reduzido em 50%.\n",
                "amarelo"
        );

        Log.Registrar(jogador.getNome() + " usou defesa e o dano foi reduzido em 50%");
    }

    public static void feedbackDefesaEspecial(Personagem jogador) {
        OutputHelper.printGradual(
                "\nDefesa ativada! Dano do Ataque Especial reduzido em 50%.\n",
                "amarelo"
        );

        Log.Registrar(jogador.getNome() + " usou defesa e o dano do especial foi reduzido em 50%");
    }

    public static void mostrarHpJogador(Personagem jogador) {
        OutputHelper.printGradual(
                jogador.getNome() + " ficou com " + jogador.getPontosDeVida() + " HP.\n",
                "amarelo"
        );
    }

    public static void mostrarAvisos(String avisos) {
        if (!avisos.isEmpty()) {
            OutputHelper.printGradual(avisos, "vermelho");
        }
    }
    public static String mensagemPreparandoEspecial(Inimigo inimigo) {
        Log.Registrar(inimigo.getNome() + " está preparando um ataque especial");

        return "⚠️⚠️ " + inimigo.getNome()
                + " está preparando um ataque especial!\n";
    }
    public static void mostrarEntradaBoss() {

        String boss = OutputHelper.colorirTexto("""
            
                             ██████╗  ██████╗ ███████╗███████╗
                             ██╔══██╗██╔═══██╗██╔════╝██╔════╝
                             ██████╔╝██║   ██║███████╗███████╗
                             ██╔══██╗██║   ██║╚════██║╚════██║
                             ██████╔╝╚██████╔╝███████║███████║
                             ╚═════╝  ╚═════╝ ╚══════╝╚══════╝
            
                         ╔════════════════════════════════════════════╗
                         ║              ⚠️  CHEFE FINAL  ⚠️           ║
                         ╠════════════════════════════════════════════╣
                         ║        O DRAGÃO DO END APARECEU!           ║
                         ╚════════════════════════════════════════════╝
            
            """, "vermelho");

        OutputHelper.printGradual(boss, 15);

        OutputHelper.printGradualD(
                "\n                O céu escurece...\n",
                "amarelo", 39
        );

        OutputHelper.printGradualD(
                "                As chamas iluminam o campo de batalha...\n",
                "amarelo", 39
        );

        OutputHelper.printGradual("                🐉 ");
        OutputHelper.printGradualD(
                "O Dragão abre suas asas e solta um rugido ensurdecedor!\n",
                "vermelho", 39
        );

        OutputHelper.printGradualD(
                "\n                ⚔️ Esta é sua última batalha. Derrote o Dragão ou seja destruído!\n\n",
                "amarelo", 39
        );
    }
}