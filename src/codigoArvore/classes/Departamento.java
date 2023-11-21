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
}
