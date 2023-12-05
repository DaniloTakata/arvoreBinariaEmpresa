package codigoArvore.classes;

import codigoArvore.lista.ListaCelula;

public class Gerente {

    private static int base_id = 0;

    private int id;
    private String nome;
    private ListaCelula funcionario;

    public Gerente() {}

    public Gerente(String nome) {
        this.id = base_id++;
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
                ", funcionario=" + funcionario.printarLista() +
                '}';
    }
}
