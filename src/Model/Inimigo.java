package Model;

public class Inimigo extends Entidade {

    public Inimigo(String nome, int pontosDeVida, int dano) {
        super(nome, pontosDeVida, dano);
    }

    public void atacar(Entidade alvo){
        alvo.receberDano(10);
    }

}
