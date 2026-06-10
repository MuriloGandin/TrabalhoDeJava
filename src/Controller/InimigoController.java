package Controller;

import Model.Inimigo;
import Model.Personagem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InimigoController {

    final static String pathInimigos = "data/inimigos.txt";

    public static void executarTurnoInimigos(List<Inimigo> inimigos, Personagem jogador) {

        for (Inimigo inimigo : inimigos) {
            System.out.println("\n" + inimigo.getNome() + " atacou " + jogador.getNome() + "!");

            int dano = inimigo.getDano();
            if (jogador.isDefendendo()) {
                dano = dano / 2;
                System.out.println("Defesa ativada! Dano reduzido pela metade.");
            }

            jogador.receberDano(dano);
            Log.Registrar(
                    inimigo.getNome() +
                            " atacou " +
                            jogador.getNome() +
                            " causando " +
                            dano +
                            " de dano."
            );

        }
        System.out.println(jogador.getNome() + " ficou com " + jogador.getPontosDeVida() + " HP.");
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
                    inimigo.getDano() + "\n"
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
        if (partes.length == 3) {
            String nome = partes[0];
            int hp     = Integer.parseInt(partes[1]);
            int dano   = Integer.parseInt(partes[2]);
            return new Inimigo(nome, hp, dano);
        } else return null;
    }

    public static boolean inimigoDuplicado(List<Inimigo> inimigosCadastrados, String nome) {
        for (Inimigo i : inimigosCadastrados) {
            if (i.getNome().equalsIgnoreCase(nome))
                return true;
        }
        return false;
    }

}
