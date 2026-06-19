package Controller;

import Model.Inimigo;
import Model.Personagem;
import View.InimigoView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                        break;

                    case "PULO":
                        dano = inimigo.getDano() * 3;
                        jogador.setTurnosPegajoso(1);
                        break;

                    case "MORDIDA":
                        dano = inimigo.getDano() * 2;
                        break;

                    case "FLECHADA":
                        dano = inimigo.getDano() * 2;
                        break;

                    case "VENENO":
                        dano = inimigo.getDano() * 2;
                        jogador.setTurnosEnvenenado(3);
                        break;

                    case "DESIDRATACAO":
                        dano = inimigo.getDano() * 2;
                        break;

                    case "TRIDENTE":
                        dano = inimigo.getDano() * 3;
                        break;

                    case "SOMBRIO":
                        dano = inimigo.getDano() * 3;
                        break;

                    case "EXPLOSAO":
                        dano = inimigo.getDano() * 4;
                        break;

                    case "POCAO":
                        dano = inimigo.getDano() * 3;
                        break;

                    case "BOLA_DE_FOGO":
                        dano = inimigo.getDano() * 3;
                        jogador.setTurnosQueimado(2);
                        break;

                    case "MACHADADA":
                        dano = inimigo.getDano() * 3;
                        break;

                    case "MAGIA":
                        dano = inimigo.getDano() * 3;
                        break;

                    case "LENTIDAO":
                        dano = inimigo.getDano() * 2;
                        jogador.setTurnosLentidao(1);
                        break;

                    case "BAFORADA_DO_DRAGAO":
                        dano = inimigo.getDano() * 3;
                        break;
                    default:
                        dano = inimigo.getDano() * 2;
                       break;

                }

                if (jogador.isDefendendo()) {
                    dano = dano / 2;
                   InimigoView.feedbackDefesaEspecial(jogador);
                }

                InimigoView.feedbackAtaqueEspecial(inimigo,dano);
                jogador.receberDano(dano);

                inimigo.setPreparandoAtaqueEspecial(false);
                inimigo.setContadorAtaques(0);

                continue;
            }

            int dano = inimigo.getDano();
            if (jogador.isDefendendo()) {
                dano = dano / 2;
               InimigoView.feedbackDefesaNormal(jogador);
            }

            jogador.receberDano(dano);
            InimigoView.feedbackAtaqueNormal(inimigo,jogador,dano);


            inimigo.setContadorAtaques(
                    inimigo.getContadorAtaques() + 1
            );

            if (inimigo.getContadorAtaques()
                    >= inimigo.getAtaquesParaEspecial()) {
                avisos += InimigoView.mensagemPreparandoEspecial(inimigo);
                inimigo.setPreparandoAtaqueEspecial(true);
            }

        }
        InimigoView.mostrarHpJogador(jogador);
        InimigoView.mostrarAvisos(avisos);
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
