package Model;

import java.io.Serializable;

public abstract class Entidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    protected int pontosDeVida;
    protected int vidaMax;
    boolean estaVivo = true;
    protected int dano;

    public Entidade(String nome, int pontosDeVidaMax, int dano) {
        this.nome = nome;
        this.vidaMax = pontosDeVidaMax;
        pontosDeVida = vidaMax;
        this.dano = dano;
    }

    public void receberDano(int dano){
        pontosDeVida -= dano;
        if (pontosDeVida < 1) {
            estaVivo = false;
            pontosDeVida = 0;
        }
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public boolean EstaVivo() {
        return estaVivo;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Pontos de Vida: " + pontosDeVida);
        System.out.println("Dano: " + dano);
        System.out.println(estaVivo ? "Estado: Vivo" : "Estado: Morto");
    }

    public int getVidaMax() {
        return vidaMax;
    }
}
