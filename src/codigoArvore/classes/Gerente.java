package codigoArvore.classes;

import codigoArvore.lista.ListaCelula;

public class Gerente {

    private int id = 0;
    private String nome;
    private ListaCelula funcionario;

    public Gerente() {}

    public Gerente(String nome) {
        this.id = this.id + 1;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ListaCelula getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ListaCelula funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gerente gerente = (Gerente) o;

        return id == gerente.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", funcionario=" + funcionario +
                '}';
    }
}
