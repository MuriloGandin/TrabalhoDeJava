package View;

public class OutputHelper {

    // Limpa as ultimas 50 linhas do terminal para uma exibição mais limpa
    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Exibe o texto recebido gradualmente para um efeito de "suavidade", com um intervalo de 3 milessegundos entre os prints
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

    // Funciona como a função anterior, mas permite que a velocidade de impressão do texto seja especificada (ms)
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

    // Funciona como o metodo anterior, mas pode receber as cores vermelho, verde ou amarelo para colorir o texto.
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

    // Exibe o texto informado no terminal com uma cor recebida (vermelho, azul, verde)
    // Exemplo: TerminalView.printColorido("Olá", "vermelho"); - Resultado: "Olá" pintado em vermelho no terminal

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

    // Retorna uma String Colorida para uso externo. Pode ser visualizada somente no terminal.
    // Exemplo: System.out.println(TerminalView.colorirTexto("Olá", "Vermelho")) - funcionará como o exemplo do metodo "printColorido"
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
    // Criei outro print para conseguir colocar cor e mudar a velocidade de exibição ao mesmo tempo, usei para a mensagem do dragao
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
