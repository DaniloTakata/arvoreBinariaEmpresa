package codigoArvore.lista;

import codigoArvore.classes.Funcionario;

public class Celula {

    private Funcionario funcionarioCelula;
    private Celula celulaProximo;

    public Celula() {}

    public Celula(Funcionario funcionarioCelula, Celula celulaProximo) {
        this.funcionarioCelula = funcionarioCelula;
        this.celulaProximo = celulaProximo;
    }

    public Funcionario getFuncionarioCelula() {
        return funcionarioCelula;
    }

    public void setFuncionarioCelula(Funcionario funcionarioCelula) {
        this.funcionarioCelula = funcionarioCelula;
    }

    public Celula getCelulaProximo() {
        return celulaProximo;
    }

    public void setCelulaProximo(Celula celulaProximo) {
        this.celulaProximo = celulaProximo;
    }

    @Override
    public String toString() {
        return "Celula{" +
                "funcionarioCelula=" + funcionarioCelula +
                ", celulaProximo=" + celulaProximo +
                '}';
    }
}
