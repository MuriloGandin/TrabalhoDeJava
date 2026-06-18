package Controller;

import Model.Inimigo;
import Model.Personagem;
import View.OutputHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InimigoController {

    final static String pathInimigos = "data/inimigos.txt";


    public static List<Inimigo> inimigos = InimigoController.listarInimigos();

    public static void executarTurnoInimigos(List<Inimigo> inimigos, Personagem jogador) {
        String avisos = "";
        for (Inimigo inimigo : inimigos) {


            if (inimigo.isPreparandoAtaqueEspecial()) {

                int dano = 0;
                switch (inimigo.getTipoAtaqueEspecial()){

                    case "GRITO":
                        dano = inimigo.getDano() * 2;
                        OutputHelper.printGradual(inimigo.getNome() + " soltou um grito assustador e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "PULO":
                        dano = inimigo.getDano() * 3;
                        jogador.setTurnosPegajoso(1);
                        OutputHelper.printGradual(inimigo.getNome() + " pulou em você e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "MORDIDA":
                        dano = inimigo.getDano() * 2;
                        OutputHelper.printGradual(inimigo.getNome() + " mordeu você e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "FLECHADA":
                        dano = inimigo.getDano() * 2;
                        OutputHelper.printGradual(inimigo.getNome() + " acertou uma flechada e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "VENENO":
                        dano = inimigo.getDano() * 2;
                        jogador.setTurnosEnvenenado(3);
                        OutputHelper.printGradual(inimigo.getNome() + " envenenou você e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "DESIDRATACAO":
                        dano = inimigo.getDano() * 2;
                        OutputHelper.printGradual(inimigo.getNome() + " causou desidratação e deu " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "TRIDENTE":
                        dano = inimigo.getDano() * 3;
                        OutputHelper.printGradual(inimigo.getNome() + " lançou um tridente e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "SOMBRIO":
                        dano = inimigo.getDano() * 3;
                        OutputHelper.printGradual(inimigo.getNome() + " usou ataque sombrio e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "EXPLOSAO":
                        dano = inimigo.getDano() * 4;
                        OutputHelper.printGradual(inimigo.getNome() + " explodiu e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "POCAO":
                        dano = inimigo.getDano() * 3;
                        OutputHelper.printGradual(inimigo.getNome() + " lançou uma poção e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "BOLA_DE_FOGO":
                        dano = inimigo.getDano() * 3;
                        jogador.setTurnosQueimado(2);
                        OutputHelper.printGradual(inimigo.getNome() + " lançou uma bola de fogo e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "MACHADADA":
                        dano = inimigo.getDano() * 3;
                        OutputHelper.printGradual(inimigo.getNome() + " deu uma machadada e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "MAGIA":
                        dano = inimigo.getDano() * 3;
                        OutputHelper.printGradual(inimigo.getNome() + " usou magia e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "LENTIDAO":
                        dano = inimigo.getDano() * 2;
                        jogador.setTurnosLentidao(1);
                        OutputHelper.printGradual(inimigo.getNome() + " usou lentidão e causou " + dano + " de dano!!\n", "vermelho");
                        break;

                    case "BAFORADA_DO_DRAGAO":
                        dano = inimigo.getDano() * 3;
                        OutputHelper.printGradual(inimigo.getNome() + " soltou uma baforada de dragão e causou " + dano + " de dano!!\n", "vermelho");
                        break;
                    default:
                        dano = inimigo.getDano() * 2;
                        OutputHelper.printGradual(
                                inimigo.getNome() + " usou um ataque especial!\n",
                                "vermelho"
                        );

                }
//                int dano = inimigo.getDano() * 3;

//                OutputHelper.printGradual(
//                        inimigo.getNome() +
//                                " usou um ATAQUE ESPECIAL!\n","vermelho"
//                );

                if (jogador.isDefendendo()) {
                    dano = dano / 2;
                    System.out.println("\nDefesa ativada! Dano do Ataque Especial reduzido em 50%.");
                    Log.Registrar(jogador.getNome() + " Usou defesa e o dano foi reduzido em 50%");
                }

                jogador.receberDano(dano);


                Log.Registrar(
                        inimigo.getNome() +
                                " usou ataque especial em " +
                                jogador.getNome() +
                                " causando " +
                                dano +
                                " de dano."
                );

                inimigo.setPreparandoAtaqueEspecial(false);
                inimigo.setContadorAtaques(0);

                continue;
            }


            System.out.println("\n" + inimigo.getNome() + " atacou " + jogador.getNome() + "!");

            int dano = inimigo.getDano();
            if (jogador.isDefendendo()) {
                dano = dano / 2;
                System.out.println("\nDefesa ativada! Dano reduzido em 50%.");
                Log.Registrar(jogador.getNome() + " Usou desefa e o dano foi reduzido em 50%");
            }

            jogador.receberDano(dano);

            inimigo.setContadorAtaques(
                    inimigo.getContadorAtaques() + 1
            );

            if (inimigo.getContadorAtaques()
                    >= inimigo.getAtaquesParaEspecial()) {

                Log.Registrar(inimigo.getNome() + " esta preparando um ataque Especial");
                avisos += "⚠️⚠️" + inimigo.getNome()
                        + " está preparando um ataque especial!\n";

                inimigo.setPreparandoAtaqueEspecial(true);
            }


            Log.Registrar(
                    inimigo.getNome() +
                            " atacou " +
                            jogador.getNome() +
                            " causando " +
                            dano +
                            " de dano."
            );

        }
        System.out.println(
                jogador.getNome() +
                        " ficou com " +
                        jogador.getPontosDeVida() +
                        " HP."
        );

        if (!avisos.isEmpty()) {
            OutputHelper.printGradual(avisos, "vermelho");
        }
        jogador.setDefendendo(false);
    }

    public static Inimigo buscarInimigo(String nomeInimigo, List<Inimigo> listaInimigos) {
        for (Inimigo i :  listaInimigos) {
            if (i.getNome().equalsIgnoreCase(nomeInimigo)) {
                return i;
            }
        }
        return null;
    }

    public static void createInimigo(Inimigo inimigo) {
        try (FileWriter fw = new FileWriter(pathInimigos, true)) {

            fw.write("\n" + inimigo.getNome() + "," +
                    inimigo.getPontosDeVida() + "," +
                    inimigo.getDano() + "," +
                    inimigo.getAtaquesParaEspecial() + "\n"
            );
            System.out.println("Inimigo" + inimigo.getNome() + "criado com sucesso");

        } catch (IOException e) {
            System.out.println("Erro ao criar o inimigo");
            throw new RuntimeException(e);
        }
    }

    public static List<Inimigo> listarInimigos() {
        List<Inimigo> inimigos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathInimigos))) {

            String linha;

            while ((linha = br.readLine()) != null) {
                inimigos.add(converterStringParaInimigo(linha));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nenhum inimigo cadastrado ainda.");
        } catch (IOException e) {
            System.out.println("Erro ao ler inimigos: " + e.getMessage());
        }

        return inimigos;
    }

    // Converte uma linha de texto para inimigo no formato: "nome, hp, dano"
    public static Inimigo converterStringParaInimigo(String linha) {
        String[] partes = linha.split(",");
        if (partes.length == 8) {
            int id = Integer.parseInt(partes[0]);
            String nome = partes[1];
            int hp = Integer.parseInt(partes[2]);
            int dano = Integer.parseInt(partes[3]);
            int ataquesParaEspecial = Integer.parseInt(partes[4]);
           int moedasMin = Integer.parseInt(partes[5]);
           int moedasMax = Integer.parseInt(partes[6]);
           String TipoAtaqueEspecial = partes[7];
            Inimigo inimigo = new Inimigo(id, nome, hp, dano);

            inimigo.setAtaquesParaEspecial(ataquesParaEspecial);
            inimigo.setMoedasMin(moedasMin);
            inimigo.setMoedasMax(moedasMax);
            inimigo.setTipoAtaqueEspecial(TipoAtaqueEspecial);

            return inimigo;

        } else return null;
    }

    public static boolean inimigoDuplicado(List<Inimigo> inimigosCadastrados, String nome) {
        for (Inimigo i : inimigosCadastrados) {
            if (i.getNome().equalsIgnoreCase(nome))
                return true;
        }
        return false;
    }
public static int SortearMoedas(Inimigo inimigo) {
        int moedasMin = inimigo.getMoedasMin();
        int moedasMax = inimigo.getMoedasMax();

        return (int)(Math.random() * (moedasMax - moedasMin + 1)) + moedasMin;
    }

}
