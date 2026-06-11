package Model;

public class Item {

    public enum tipo {
        CONSUMIVEL_CURA,
        EQUIPAVEL_ARMA,
        EQUIPAVEL_ARMADURA
    }

    private int id;
    private String nome;
    private tipo tipo;
    private int valorEfeito;
    private int preco;

    public Item(int id, String nome, tipo tipo, int valorEfeito, int preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valorEfeito = valorEfeito;
        this.preco = preco;
    }

    public tipo getTipo() {
        return tipo;
    }

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
