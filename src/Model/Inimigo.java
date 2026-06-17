package Model;

public class Inimigo extends Entidade {
    private boolean preparandoAtaqueEspecial;
    private String TipoAtaqueEspecial;
    private int contadorTurnos;
    private int contadorAtaques;
    private int ataquesParaEspecial;



    private int moedasMin;
    private int moedasMax;
    private int multiplicadorEspecial;

    public int getMoedasMax() {
        return moedasMax;
    }

    public void setMoedasMax(int moedasMax) {
        this.moedasMax = moedasMax;
    }

    public int getMoedasMin() {
        return moedasMin;
    }

    public void setMoedasMin(int moedasMin) {
        this.moedasMin = moedasMin;
    }

    public int getAtaquesParaEspecial() {
        return ataquesParaEspecial;
    }

    public void setAtaquesParaEspecial(int ataquesParaEspecial) {
        this.ataquesParaEspecial = ataquesParaEspecial;
    }

    public int getContadorAtaques() {
        return contadorAtaques;
    }

    public void setContadorAtaques(int contadorAtaques) {
        this.contadorAtaques = contadorAtaques;
    }

    public int getMultiplicadorEspecial() {
        return multiplicadorEspecial;
    }

    public void setMultiplicadorEspecial(int multiplicadorEspecial) {
        this.multiplicadorEspecial = multiplicadorEspecial;
    }



    public boolean isPreparandoAtaqueEspecial() {
        return preparandoAtaqueEspecial;
    }

    public void setPreparandoAtaqueEspecial(boolean preparandoAtaqueEspecial) {
        this.preparandoAtaqueEspecial = preparandoAtaqueEspecial;
    }

    public int getContadorTurnos() {
        return contadorTurnos;
    }

    public void setContadorTurnos(int contadorTurnos) {
        this.contadorTurnos = contadorTurnos;
    }


    public Inimigo(String nome, int pontosDeVida, int dano) {
        super(nome, pontosDeVida, dano);
    }

    public String getTipoAtaqueEspecial() {
        return TipoAtaqueEspecial;
    }

    public void setTipoAtaqueEspecial(String tipoAtaqueEspecial) {
        TipoAtaqueEspecial = tipoAtaqueEspecial;
    }

    @Override
    public void atacar(Entidade alvo){
        alvo.receberDano(getDano());
    }

    @Override
    public void recuperarVida(int quantidade) {
        this.setPontosDeVida(getPontosDeVida() + quantidade);
    }

}
