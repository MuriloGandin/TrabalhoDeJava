package Model;

import java.util.ArrayList;
import java.util.List;

public class Personagem extends Entidade {

    private boolean defendendo;
    private List<Item> inventario = new ArrayList<>();
    private int diamantes = 5;
    private Item equipamento = null;
    private Item armadura = null;
    public int danoExtraTemporario = 0;
    private int turnosEnvenenado;
    private int turnosQueimado;
    private int turnosLentidao;
    private int turnosPegajoso;

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }

    public int getTurnosPegajoso() {
        return turnosPegajoso;
    }

    public void setTurnosPegajoso(int turnosPegajoso) {
        this.turnosPegajoso = turnosPegajoso;
    }

    public int getTurnosLentidao() {
        return turnosLentidao;
    }

    public void setTurnosLentidao(int turnosLentidao) {
        this.turnosLentidao = turnosLentidao;
    }

    public int getTurnosQueimado() {
        return turnosQueimado;
    }

    public void setTurnosQueimado(int turnosQueimado) {
        this.turnosQueimado = turnosQueimado;
    }

    public int getTurnosEnvenenado() {
        return turnosEnvenenado;
    }

    public void setTurnosEnvenenado(int turnosEnvenenado) {
        this.turnosEnvenenado = turnosEnvenenado;
    }

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
        if (novoHp >= vidaMax)
            novoHp = vidaMax;
        setPontosDeVida(novoHp);
    }

    @Override
    public void receberDano(int dano) {
        int defesa = 0;

        if (armadura != null) {
            defesa = armadura.getValorEfeito();
        }

        int danoFinal = Math.max(1, dano - defesa);

        pontosDeVida -= danoFinal;

        if (pontosDeVida <= 0) {
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
        return this.dano + danoAdicional + danoExtraTemporario;
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

    public void setEquipamento(Item equipamento) {
        this.equipamento = equipamento;
    }

    public void setArmadura(Item armadura) {
        this.armadura = armadura;
    }

    public void equiparArmadura(Item item) {
        armadura = item;
        item.setEquipado(true);
    }

    public void desequiparItem(Item item) {
        this.equipamento = null;
        item.setEquipado(false);
    }

    public void desequiparArmadura(Item item) {
        this.armadura = null;
        item.setEquipado(false);
    }

    public Item getEquipamento() {
        return equipamento;
    }

    public Item getArmadura() {
        return armadura;
    }



}
