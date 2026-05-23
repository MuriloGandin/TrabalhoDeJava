package Model;

public abstract class Entidade {

    private String nome;
    private int pontosDeVida;
    boolean estaVivo;
    private int dano;

    public Entidade(int pontosDeVida, boolean estaVivo) {
        this.pontosDeVida = pontosDeVida;
        this.estaVivo = estaVivo;
    }

    public void receberDano(int dano){
        pontosDeVida -= dano;
        if (pontosDeVida < 1){
            estaVivo = false;
        }
    }

    abstract public void atacar(Entidade alvo);

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
        System.out.println("Está Vivo: " + estaVivo);
    }
}
