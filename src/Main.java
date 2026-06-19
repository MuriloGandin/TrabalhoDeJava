import Controller.Log;
import View.Sistema;

public class Main {
    public static void main(String[] args) {
        Log.Registrar("Sistema iniciando.");
        Sistema.executar();
    }
}