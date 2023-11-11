package codigoArvore;

import java.util.Objects;

public class No {

    private Object elemento;
    private int tipoElemento; // TP: 1 = Departamento; 2 = Gerente; 3 = Funcionario
    private No pai;
    private No esquerdo;
    private No direito;

    public No() {}

    public No(Object elemento, int tipoElemento, No pai, No esquerdo, No direito) {
        this.elemento = elemento;
        this.tipoElemento = tipoElemento;
        this.pai = pai;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }

    public No(No novoNo) {
        this.elemento = novoNo.getElemento();
        this.tipoElemento = novoNo.getTipoElemento();
        this.pai = novoNo.getPai();
        this.esquerdo = novoNo.getEsquerdo();
        this.direito = novoNo.getDireito();
    }

    public No(Object elemento, int tipoElemento, No pai) {
        this(elemento, tipoElemento, pai, null, null);
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public int getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(int tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        No no = (No) o;

        if (tipoElemento != no.tipoElemento) return false;
        if (!Objects.equals(elemento, no.elemento)) return false;
        if (!Objects.equals(pai, no.pai)) return false;
        if (!Objects.equals(esquerdo, no.esquerdo)) return false;
        return Objects.equals(direito, no.direito);
    }

    @Override
    public int hashCode() {
        int result = elemento != null ? elemento.hashCode() : 0;
        result = 31 * result + tipoElemento;
        result = 31 * result + (pai != null ? pai.hashCode() : 0);
        result = 31 * result + (esquerdo != null ? esquerdo.hashCode() : 0);
        result = 31 * result + (direito != null ? direito.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ", tipoElemento=" + tipoElemento +
                ", pai=" + pai +
                ", esquerdo=" + esquerdo +
                ", direito=" + direito +
                '}';
    }
}
