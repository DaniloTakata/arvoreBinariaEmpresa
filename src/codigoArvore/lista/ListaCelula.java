package codigoArvore.lista;

import codigoArvore.classes.Funcionario;

public class ListaCelula {

    private Celula funcionarioPrimeiro;
    private int indice;

    public ListaCelula() {
        this.funcionarioPrimeiro = null;
        this.indice = 0;
    }

    public Celula getFuncionarioPrimeiro() {
        return funcionarioPrimeiro;
    }

    public void setFuncionarioPrimeiro(Celula funcionarioPrimeiro) {
        this.funcionarioPrimeiro = funcionarioPrimeiro;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void inserePrimeiro(Celula novaCelula) {
        this.funcionarioPrimeiro = novaCelula;
    }

    public void insereCelula(Celula novaCelula) {
        if (this.indice == 0) {
            this.inserePrimeiro(novaCelula);
        } else {
            Celula celulaAtual = this.funcionarioPrimeiro;

            for (int i = 0; i < this.indice; i++) {

                if (celulaAtual.getCelulaProximo() == null) {
                    celulaAtual.setCelulaProximo(novaCelula);
                } else {
                    celulaAtual = celulaAtual.getCelulaProximo();
                }

            }
        }
        this.indice++;
    }

    public void removeUltimo() {
        if (this.indice == 0) {
            throw new RuntimeException("Não existem funcionários!");
        } else if (this.indice == 1) {
            this.funcionarioPrimeiro = null;
            this.indice--;
        } else {
            Celula celulaAtual = this.funcionarioPrimeiro;

            for (int i = 0; i < this.indice; i++) {

                if (celulaAtual.getCelulaProximo() == null) {
                    celulaAtual.setCelulaProximo(null);
                } else {
                    celulaAtual = celulaAtual.getCelulaProximo();
                }

            }
            this.indice--;
        }
    }

    public void removePosicao(int indiceRemocao) {

        if (indice == 1) {
            this.funcionarioPrimeiro = null;
            this.indice--;
        } else if (this.indice == 0) {
            throw new RuntimeException("Não existem funcionários!");
        } else if (indiceRemocao == (this.indice - 1)) {
            this.removeUltimo();
        } else {
            Celula celulaAtual = this.funcionarioPrimeiro;
            Celula celulaAnterior = new Celula();

            for (int i = 0; i <= indiceRemocao; i++) {

                if (i != indiceRemocao && i != (indiceRemocao - 1)) {
                    celulaAtual = celulaAtual.getCelulaProximo();
                } else if (i == (indiceRemocao - 1)) {
                    celulaAnterior = celulaAtual;
                } else {
                    celulaAnterior.setCelulaProximo(celulaAtual.getCelulaProximo());
                }
            }
            this.indice--;
        }

    }

    public int removePorNome(String nomeBuscado) {

        Celula celulaAtual = this.funcionarioPrimeiro;
        for (int i = 0; i < this.indice; i++) {

            if ((celulaAtual.getFuncionarioCelula().getNome()).equals(nomeBuscado)) {
                return i;
            }

        }
        return -999;
    }

    public Funcionario buscaNome(String nomeBuscado) {
        Celula celulaAtual = this.funcionarioPrimeiro;

        for (int i = 0; i < this.indice; i++) {
            Funcionario funcionarioAtual = celulaAtual.getFuncionarioCelula();

            if (funcionarioAtual.getNome().equals(nomeBuscado)) {
                return funcionarioAtual;
            }

            celulaAtual = celulaAtual.getCelulaProximo();
        }

        return null;
    }

    public String printarLista() {

        Celula celulaAtual = this.funcionarioPrimeiro;

        String retorno = "[";
        for (int i = 0; i < this.indice; i++) {
            Funcionario funcionarioAtual = celulaAtual.getFuncionarioCelula();

            if (i == (this.indice - 1)) {
                retorno += funcionarioAtual.toString();
            } else {
                retorno += funcionarioAtual.toString() + ", ";
            }

            celulaAtual = celulaAtual.getCelulaProximo();
        }
        retorno += "]";

        return retorno;
    }

    public int qtdFuncionario() {
        return this.indice;
    }

}
