package codigoArvore.classes;

public class Funcionario {

    private int id = 0;
    private String nome;
    private String cargo;

    public Funcionario() {}

    public Funcionario(String nome, String cargo) {
        this.id = this.id + 1;
        this.nome = nome;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
