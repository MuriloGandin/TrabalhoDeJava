package Model;

public class Item {

    public enum tipo {
        CONSUMIVEL, EQUIPAVEL
    }

    private tipo tipo;
    private String descricao;

    public Item(String descricao,  tipo tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public tipo getTipo() {
        return tipo;
    }

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
