package codigoArvore;

import codigoArvore.classes.Gerente;


public class No {

    private int id = 0;
    private int peso = 0;
    private No noPai;
    private No noEsquerdo;
    private No noDireito;
    private String nomeDep;
    private Gerente gerente;

    public No() {}

    public No(int id) {
        this.id = id;
        this.peso++;
    }

    public No(int id, int peso, No noPai, No noEsquerdo, No noDireito, String nomeDep, Gerente gerente) {
        this.id = id;
        this.peso++;
        this.noPai = noPai;
        this.noEsquerdo = noEsquerdo;
        this.noDireito = noDireito;
        this.nomeDep = nomeDep;
        this.gerente = gerente;
        this.id++;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public No getNoPai() {
        return noPai;
    }

    public void setNoPai(No noPai) {
        this.noPai = noPai;
    }

    public No getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(No noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public No getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(No noDireito) {
        this.noDireito = noDireito;
    }

    public String getNomeDep() {
        return nomeDep;
    }

    public void setNomeDep(String nomeDep) {
        this.nomeDep = nomeDep;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "No{" +
                "noPai=" + noPai +
                ", noEsquerdo=" + noEsquerdo +
                ", noDireito=" + noDireito +
                ", nomeDep='" + nomeDep + '\'' +
                ", gerente=" + gerente +
                '}';
    }
}
