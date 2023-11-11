package codigoArvore.classes;

public class Departamento {

    private int id = 0;
    private String nome;

    public Departamento() {}

    public Departamento(String nome) {
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
}
