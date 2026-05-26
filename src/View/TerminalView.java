package View;

public class TerminalView {

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void printGradual(String texto) throws InterruptedException {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            Thread.sleep(3);

        }
    }

    public static void printGradual(String texto, String cor) throws InterruptedException {
        for (char c : texto.toCharArray()) {
            printColorido(Character.toString(c), cor);
            Thread.sleep(3);
        }
    }


    public static void printColorido(String texto, String cor) {
        String codigoCor;

        if (cor.equalsIgnoreCase("vermelho"))
            codigoCor = "\u001B[31m";
        else if (cor.equalsIgnoreCase("verde"))
            codigoCor = "\u001B[32m";
        else if (cor.equalsIgnoreCase("amarelo"))
            codigoCor = "\u001B[33m";
        else
            throw new RuntimeException("Cor inválida para string (apenas vermelho, verde ou amarelo)");

        System.out.print(codigoCor + texto + "\u001B[0m");
    }

    public static String colorirTexto(String texto, String cor) {
        String codigoCor;

        if (cor.equalsIgnoreCase("vermelho"))
            codigoCor = "\u001B[31m";
        else if (cor.equalsIgnoreCase("verde"))
            codigoCor = "\u001B[32m";
        else if (cor.equalsIgnoreCase("amarelo"))
            codigoCor = "\u001B[33m";
        else
            throw new RuntimeException("Cor inválida para string (apenas vermelho, verde ou amarelo)");

        return codigoCor + texto + "\u001B[0m";
    }
}
