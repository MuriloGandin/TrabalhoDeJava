package Model;

import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum tipo {
        CONSUMIVEL_CURA,
        CONSUMIVEL_FORCA,
        EQUIPAVEL_ARMA,
        EQUIPAVEL_ARMADURA
    }

    private int id;
    private String nome;
    private tipo tipo;
    private int valorEfeito;
    private int preco;
    private boolean estaEquipado = false;

    public Item(int id, String nome, tipo tipo, int valorEfeito, int preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valorEfeito = valorEfeito;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValorEfeito() {
        return valorEfeito;
    }

    public void setValorEfeito(int valorEfeito) {
        this.valorEfeito = valorEfeito;
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

    public boolean estaEquipado() {
        return estaEquipado;
    }

    public void setEquipado(boolean estaEquipado) {
        this.estaEquipado = estaEquipado;
    }
}
