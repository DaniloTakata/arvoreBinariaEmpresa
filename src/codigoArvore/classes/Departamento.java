package codigoArvore.classes;

import java.util.Objects;

public class Departamento {

    String nome;

    Gerente gerente;

    public Departamento(String nome) {
        this.nome = nome;
    }

    public Departamento(String nome, Gerente gerente) {
        this.nome = nome;
        this.gerente = gerente;
    }

    public Departamento() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departamento that = (Departamento) o;

        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", gerente=" + gerente +
                "}";
    }
}