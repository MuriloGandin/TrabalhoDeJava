package View;

public class OutputHelper {

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void printGradual(String texto) {
        for (char c : texto.toCharArray()) {
            try {
                System.out.print(c);
                Thread.sleep(8);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void printGradual(String texto, int velocidade) {
        for (char c : texto.toCharArray()) {
            try {
                System.out.print(c);
                Thread.sleep(velocidade);

            } catch (Exception e) {
                return;
            }
        }
    }

     public static void printGradual(String texto, String cor) {
        for (char c : texto.toCharArray()) {
            if (c != ' ') {
                try {
                    printColorido(Character.toString(c), cor);
                    Thread.sleep(10);

                }  catch (InterruptedException e) {
                    return;
                }
            } else printColorido(Character.toString(c), cor);

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
        else if (cor.equalsIgnoreCase("azul"))
            codigoCor = "\u001B[34m";
        else if (cor.equalsIgnoreCase("ciano"))
            codigoCor = "\u001B[36m";
        else
            throw new RuntimeException("Cor inválida para string (apenas vermelho, verde ou amarelo)");

        System.out.print(codigoCor + texto + "\u001B[0m");
    }

    public static void printlnColorido(String texto, String cor) {
        String codigoCor;

        if (cor.equalsIgnoreCase("vermelho"))
            codigoCor = "\u001B[31m";
        else if (cor.equalsIgnoreCase("verde"))
            codigoCor = "\u001B[32m";
        else if (cor.equalsIgnoreCase("amarelo"))
            codigoCor = "\u001B[33m";
        else if (cor.equalsIgnoreCase("azul"))
            codigoCor = "\u001B[34m";
        else if (cor.equalsIgnoreCase("ciano"))
            codigoCor = "\u001B[36m";
        else
            throw new RuntimeException("Cor inválida para string (apenas vermelho, verde ou amarelo)");

        System.out.println(codigoCor + texto + "\u001B[0m");
    }

    public static String colorirTexto(String texto, String cor) {
        String codigoCor;

        if (cor.equalsIgnoreCase("vermelho"))
            codigoCor = "\u001B[31m";
        else if (cor.equalsIgnoreCase("verde"))
            codigoCor = "\u001B[32m";
        else if (cor.equalsIgnoreCase("amarelo"))
            codigoCor = "\u001B[33m";
        else if (cor.equalsIgnoreCase("azul"))
            codigoCor = "\u001B[34m";
        else if (cor.equalsIgnoreCase("ciano"))
            codigoCor = "\u001B[36m";

        else
            throw new RuntimeException("Cor inválida para string (apenas vermelho, verde ou amarelo)");

        return codigoCor + texto + "\u001B[0m";
    }

    public static void printGradualD(String texto, String cor, int velocidade) {
        for (char c : texto.toCharArray()) {
            if (c != ' ') {
                try {
                    printColorido(Character.toString(c), cor);
                    Thread.sleep(velocidade);

                } catch (InterruptedException e) {
                    return;
                }
            } else {
                printColorido(Character.toString(c), cor);
            }
        }
    }
}
