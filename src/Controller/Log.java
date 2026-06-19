package Controller;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    // Caminho do arquivo onde o log será salvo
private static final String ARQUIVO = "data/log.txt";

public static void Registrar(String mensagem){
    try{
        FileWriter writer = new FileWriter(ARQUIVO, true);
        // Abre o arquivo de log para escrita; o true adiciona no final sem apagar os logs antigos
        String datahora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
// Escreve a data e a mensagem no arquivo, depois fecha o arquivo
        writer.write("[" + datahora + "] " + mensagem + "\n");
        writer.close();
        // mostra a data e mensagem e fecha o arquivo
    }
    catch (Exception e){
        System.out.println("Erro ao gravar log: " + e.getMessage());
        // se der erro cai aqui
    }
}
}
