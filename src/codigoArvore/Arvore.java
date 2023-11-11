package codigoArvore;

/*
 * ADM -> DEPARTAMENTOS -> GERENTES -> FUNCIONARIOS
 * */

public class Arvore {

    private No noPrincipal;

    public Arvore() {
        this.noPrincipal = null;
    }

    public void insereNoPai(No noPai) {
        if (this.noPrincipal == null) {
            this.noPrincipal = noPai;
        } else {
            throw new RuntimeException("Já existe um nó principal!");
        }
    }


    public void inserir(No novoNo) {
        this.noPrincipal = inserirRec(this.noPrincipal, novoNo);
    }

    private No inserirRec(No no, No novoNo) {
        if (no == null) {
            return new No(novoNo);
        }

        if (no.getEsquerdo() == null) {
            no.setEsquerdo(inserirRec(no.getEsquerdo(), novoNo));
        } else if (no.getDireito() == null) {
            no.setDireito(inserirRec(no.getDireito(), novoNo));
        }

        return no;
    }

    private String buscar(String nomeNo) {
        No noEncontrado = buscarRec(this.noPrincipal, nomeNo);
        return "No encontrado: " + "\n  Nome: " + noEncontrado.getElemento() + "\n  Tipo: " + noEncontrado.getTipoElemento();
    }

    private No buscarRec(No no, String nome) {
        if (no == null) {
            throw new RuntimeException("Não encontrado!");
        }

        if (nome.equals(no.getElemento())) {
            return no;
        } else if (0 == 0) {
            return buscarRec(no.getEsquerdo(), nome);
        } else {
            return buscarRec(no.getDireito(), nome);
        }
    }

    public void deletar() {
        // Implementar na terceira entrega
    }

}
