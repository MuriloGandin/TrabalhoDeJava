package View;

public class OndaView {

    public static void exibirErroCarregarOndas(String mensagem) {
        OutputHelper.printGradual("Erro ao carregar ondas: " + mensagem + "\n", "vermelho");
    }
}