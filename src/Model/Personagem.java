package Model;

import java.util.ArrayList;
import java.util.List;

public class Personagem extends Entidade {

    private boolean defendendo;
    private List<Item> inventario = new ArrayList<>();
    private int diamantes = 10;
    private Item equipamento = null;
    private Item armadura = null;


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

    @Override
    public void receberDano(int dano) {
        int defesa;
        if (armadura != null) {
            defesa = armadura.getValorEfeito();
        } else  {
            defesa = 0;
        }

        dano -= defesa;
        pontosDeVida -= dano;
        if (pontosDeVida < 1) {
            estaVivo = false;
            pontosDeVida = 0;
        }

    }

    @Override
    public int getDano() {
        int danoAdicional;
        if (equipamento != null) {
            danoAdicional = equipamento.getValorEfeito();
        } else {
            danoAdicional = 0;
        }
        return this.dano + danoAdicional;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
    }

    public void removerItem(Item item) {
        inventario.remove(item);
    }

    public boolean isDefendendo() {
        return defendendo;
    }

    public void setDefendendo(boolean defendendo) {
        this.defendendo = defendendo;
    }

    public int getDiamantes() {
        return diamantes;
    }

    public void setDiamantes(int diamantes) {
        this.diamantes = diamantes;
    }

    public void AdicionarDiamantes(int quantidade) {
        this.diamantes += quantidade;
    }

    public void equiparItem(Item item) {
        equipamento = item;
        item.setEquipado(true);
    }

    public void equiparArmadura(Item item) {
        armadura = item;
        item.setEquipado(true);
    }


}
