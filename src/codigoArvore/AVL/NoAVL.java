package codigoArvore.AVL;

import codigoArvore.classes.Departamento;

public class NoAVL {

    private int chave;
    private int balanceamento;
    private int altura;
    private NoAVL esquerda;
    private NoAVL direita;
    private NoAVL pai;

    private Departamento departamento;

    public NoAVL() {}

    public NoAVL(int chave, NoAVL noPai) {
        this.chave = chave;
        this.pai = noPai;
    }

    public NoAVL(int chave, NoAVL noPai, Departamento departamento) {
        this.chave = chave;
        this.pai = noPai;
        this.departamento = departamento;
    }

    public NoAVL(int chave, int balanceamento, int altura, NoAVL esquerda, NoAVL direita, NoAVL pai, Departamento departamento) {
        this.chave = chave;
        this.balanceamento = balanceamento;
        this.altura = altura;
        this.esquerda = esquerda;
        this.direita = direita;
        this.pai = pai;
        this.departamento = departamento;
    }

    public NoAVL(int chave, int balanceamento, int altura, NoAVL esquerda, NoAVL direita, NoAVL pai) {
        this.chave = chave;
        this.balanceamento = balanceamento;
        this.altura = altura;
        this.esquerda = esquerda;
        this.direita = direita;
        this.pai = pai;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NoAVL getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoAVL esquerda) {
        this.esquerda = esquerda;
    }

    public NoAVL getDireita() {
        return direita;
    }

    public void setDireita(NoAVL direita) {
        this.direita = direita;
    }

    public NoAVL getPai() {
        return pai;
    }

    public void setPai(NoAVL pai) {
        this.pai = pai;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoAVL noAVL = (NoAVL) o;

        return chave == noAVL.chave;
    }

    @Override
    public int hashCode() {
        return chave;
    }

    @Override
    public String toString() {
        return "{" +
                "departamento=" + departamento +
                "}";
    }
}
