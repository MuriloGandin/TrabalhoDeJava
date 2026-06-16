package Controller;

import Model.Personagem;

import java.io.*;

public class SaveController {

    private static final String PATH_SAVE = "data/save.dat";

    // Salva personagem + onda atual
    public static void salvar(Personagem jogador, int ondaAtual) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_SAVE))) {
            oos.writeObject(jogador);
            oos.writeInt(ondaAtual);
            System.out.println("Jogo salvo com sucesso!");
            Log.Registrar("Jogo salvo. Onda: " + ondaAtual + " | Jogador: " + jogador.getNome());
        } catch (IOException e) {
            System.out.println("Erro ao salvar jogo: " + e.getMessage());
        }
    }

    // Carrega o save, retorna null se não existir
    public static Object[] carregar() {
        File arquivo = new File(PATH_SAVE);
        if (!arquivo.exists()) return null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_SAVE))) {
            Personagem jogador = (Personagem) ois.readObject();
            int ondaAtual = ois.readInt();
            Log.Registrar("Jogo carregado. Onda: " + ondaAtual + " | Jogador: " + jogador.getNome());
            return new Object[]{jogador, ondaAtual};
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar save: " + e.getMessage());
            return null;
        }
    }

    public static boolean existeSave() {
        return new File(PATH_SAVE).exists();
    }

    public static void deletarSave() {
        File arquivo = new File(PATH_SAVE);
        if (arquivo.exists()) {
            arquivo.delete();
            Log.Registrar("Save deletado.");
        }
    }
}
