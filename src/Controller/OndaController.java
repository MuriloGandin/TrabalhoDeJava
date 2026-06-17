package Controller;

import Model.Inimigo;
import Model.Onda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OndaController {

    private static final String PATH = "data/onda.txt";

    public static Onda[] carregarOndas(List<Inimigo> inimigosDisponiveis) {

        List<Onda> ondas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.isBlank()) {
                    continue;
                }
                String[] partes = linha.split(",");
                List<Inimigo> inimigosOnda = new ArrayList<>();

                // Começa em 1 porque partes[0] é o número da onda
                for (int i = 1; i < partes.length; i++) {
                    int indiceInimigo = Integer.parseInt(partes[i]);
                    if (indiceInimigo >= 1 &&
                            indiceInimigo <= inimigosDisponiveis.size()) {
                        inimigosOnda.add(inimigosDisponiveis.get(indiceInimigo - 1));
                    }
                }
                Onda onda = new Onda(inimigosOnda.toArray(new Inimigo[0]));
                ondas.add(onda);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar ondas: " + e.getMessage());
        }
        return ondas.toArray(new Onda[0]);
    }
}