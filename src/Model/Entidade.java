package Model;

public class Entidade {

    private int pontosDeVida;
    boolean estaVivo;

    public Entidade(int pontosDeVida, boolean estaVivo) {
        this.pontosDeVida = pontosDeVida;
        this.estaVivo = estaVivo;
    }

    public void receberDano(int dano){
        pontosDeVida -= dano;
        if (pontosDeVida < 1){
            System.out.println("Inimigo Derrotado");
        }
    }
}
