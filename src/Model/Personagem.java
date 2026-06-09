package Model;

public class Personagem extends Entidade {

    private int pocoes;
    private boolean defendendo;
    private int nivel = 1;

    public Personagem(String nome, int pontosDeVida, int dano) {
        super(nome, pontosDeVida, dano);
    }

    @Override
    public void atacar(Entidade alvo) {
        alvo.receberDano(this.getDano());
    }

    @Override
    public void recuperarVida(int quantidade) {
        int novoHp = getPontosDeVida() + quantidade;
        setPontosDeVida(novoHp);
    }

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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel > 0) {
            this.nivel = nivel;
        }
    }


}
