package Model;

public class Personagem extends Entidade {

    private int pocoes;
    private boolean defendendo;

    public Personagem(String nome, int pontosDeVida, int dano) {
        super(nome, pontosDeVida, dano);
    }

    @Override
    public void atacar(Entidade alvo) {
        System.out.println("Atacando o alvo " + alvo.getNome());
        alvo.receberDano(this.getDano());
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
