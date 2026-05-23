package Model;

public class Personagem extends Entidade {

    private int pocoes;
    private boolean defendendo;

    public Personagem(int pontosDeVida, boolean estaVivo) {
        super(pontosDeVida, estaVivo);
    }

    @Override
    public void atacar(Entidade alvo) {
        System.out.println(alvo.receberDano(2));
    }



    private final String nomeGolpeSimples  = "Espadada Rápida";

    public int getPocoes() {
        return pocoes;
    }

    public void setPocoes(int pocoes) {
        this.pocoes = pocoes;
    }

    public boolean isDefendendo() {
        return defendendo;
    }

    public void setDefendendo(boolean defendendo) {
        this.defendendo = defendendo;
    }


}
