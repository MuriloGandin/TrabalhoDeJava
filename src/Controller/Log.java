package Controller;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {


private static final String ARQUIVO = "data/log.txt";

public static void Registrar(String mensagem){
    try{
        FileWriter writer = new FileWriter(ARQUIVO, true);

        String datahora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        writer.write("[" + datahora + "] " + mensagem + "\n");
        writer.close();

    }
    catch (Exception e){
        System.out.println("Erro ao gravar log: " + e.getMessage());

    }
}
}
