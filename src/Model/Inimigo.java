package Model;

public class Inimigo extends Entidade {

    public Inimigo(String nome, int pontosDeVida, int dano) {
        super(nome, pontosDeVida, dano);
    }

    @Override
    public void atacar(Entidade alvo){
        alvo.receberDano(10);
    }

    @Override
    public void recuperarVida(int quantidade) {
        this.setPontosDeVida(getPontosDeVida() + quantidade);
    }

}
