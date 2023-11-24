package codigoArvore.classes;

public class Departamento {

    int id;
    String nome;

    Gerente gerente;

    public Departamento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Departamento(int id, String nome, Gerente gerente) {
        this.id = id;
        this.nome = nome;
        this.gerente = gerente;
    }

    public Departamento() {}

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

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", gerente=" + gerente.getNome() +
                '}';
    }
}
