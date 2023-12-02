package codigoArvore.AVL;

import codigoArvore.classes.Departamento;

public class ArvoreAVL {

    private NoAVL raiz;

    public boolean inserir(int chave, Departamento departamento) {
        if (this.raiz == null) {
            this.raiz = new NoAVL(chave, null, departamento);
            return true;
        }

        NoAVL atual = this.raiz;
        while (true) {
            if (atual.getChave() == chave)
                return false;

            NoAVL pai = atual;

            boolean vaiParaEsquerda = atual.getChave() > chave;
            atual = vaiParaEsquerda ? atual.getEsquerda() : atual.getDireita();

            if (atual == null) {
                if (vaiParaEsquerda) {
                    pai.setEsquerda(new NoAVL(chave, pai, departamento));
                } else {
                    pai.setDireita(new NoAVL(chave, pai, departamento));
                }
                rebalancear(pai);
                break;
            }
        }
        return true;
    }

    private void removerRecursivo(NoAVL no) {
        if (no.getEsquerda() == null && no.getDireita() == null) {
            if (no.getPai() == null) {
                this.raiz = null;
            } else {
                NoAVL pai = no.getPai();
                if (pai.getEsquerda() == no) {
                    pai.setEsquerda(null);
                } else {
                    pai.setDireita(null);
                }
                rebalancear(pai);
            }
            return;
        }

        if (no.getEsquerda() != null) {
            NoAVL filho = no.getEsquerda();
            while (filho.getDireita() != null) filho = filho.getDireita();
            no.setChave(filho.getChave());
            removerRecursivo(filho);
        } else {
            NoAVL filho = no.getDireita();
            while (filho.getEsquerda() != null) filho = filho.getEsquerda();
            no.setChave(filho.getChave());
            removerRecursivo(filho);
        }
    }

    public void remover(int chave) {
        if (this.raiz == null)
            return;

        NoAVL filho = this.raiz;
        while (filho != null) {
            NoAVL no = filho;
            filho = chave >= no.getChave() ? no.getDireita() : no.getEsquerda();
            if (chave == no.getChave()) {
                removerRecursivo(no);
                return;
            }
        }
    }

    public boolean buscar(int chave) {
        if (this.raiz == null)
            return false;

        NoAVL filho = this.raiz;
        while (filho != null) {
            NoAVL no = filho;
            filho = chave >= no.getChave() ? no.getDireita() : no.getEsquerda();
            if (chave == no.getChave()) {
                return true;
            }
        }
        return false;
    }

    private void rebalancear(NoAVL no) {
        setBalanceamento(no);

        if (no.getBalanceamento() == -2) {
            if (altura(no.getEsquerda().getEsquerda()) >= altura(no.getEsquerda().getDireita()))
                no = rotacionaDireita(no);
            else
                no = rotacionaEsquerdaDepoisDireita(no);

        } else if (no.getBalanceamento() == 2) {
            if (altura(no.getDireita().getDireita()) >= altura(no.getDireita().getEsquerda()))
                no = rotacionaEsquerda(no);
            else
                no = rotacionaDireitaDepoisEsquerda(no);
        }

        if (no.getPai() != null) {
            rebalancear(no.getPai());
        } else {
            this.raiz = no;
        }
    }

    private NoAVL rotacionaEsquerda(NoAVL noDesbalanceado) {

        NoAVL direita = noDesbalanceado.getDireita();
        direita.setPai(noDesbalanceado.getPai());

        noDesbalanceado.setDireita(direita.getEsquerda());

        if (noDesbalanceado.getDireita() != null)
            noDesbalanceado.getDireita().setPai(noDesbalanceado);

        direita.setEsquerda(noDesbalanceado);
        noDesbalanceado.setPai(direita);

        if (direita.getPai() != null) {
            if (direita.getPai().getDireita() == noDesbalanceado) {
                direita.getPai().setDireita(direita);
            } else {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(noDesbalanceado, direita);

        if (noDesbalanceado == this.raiz) {
            Departamento conteudoRaiz = noDesbalanceado.getDepartamento();
            int chaveNoRaiz = noDesbalanceado.getChave();

            Departamento conteudoNo = direita.getDepartamento();
            int chaveNoDireita = direita.getChave();

            noDesbalanceado.setDepartamento(conteudoNo);
            noDesbalanceado.setChave(chaveNoRaiz);

            direita.setDepartamento(conteudoRaiz);
            direita.setChave(chaveNoDireita);
        }

        return direita;
    }

    private NoAVL rotacionaDireita(NoAVL noDesbalanceado) {

        NoAVL esquerda = noDesbalanceado.getEsquerda();
        esquerda.setPai(noDesbalanceado.getPai());

        noDesbalanceado.setEsquerda(esquerda.getDireita());

        if (noDesbalanceado.getEsquerda() != null)
            noDesbalanceado.getEsquerda().setPai(noDesbalanceado);

        esquerda.setDireita(noDesbalanceado);
        noDesbalanceado.setPai(esquerda);

        if (esquerda.getPai() != null) {
            if (esquerda.getPai().getDireita() == noDesbalanceado) {
                esquerda.getPai().setDireita(esquerda);
            } else {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(noDesbalanceado, esquerda);

        if (noDesbalanceado == this.raiz) {
            Departamento conteudoRaiz = noDesbalanceado.getDepartamento();
            int chaveNoRaiz = noDesbalanceado.getChave();

            Departamento conteudoNo = esquerda.getDepartamento();
            int chaveNoEsquerda = esquerda.getChave();

            noDesbalanceado.setDepartamento(conteudoNo);
            noDesbalanceado.setChave(chaveNoRaiz);

            esquerda.setDepartamento(conteudoRaiz);
            esquerda.setChave(chaveNoEsquerda);
        }

        return esquerda;
    }

    private NoAVL rotacionaEsquerdaDepoisDireita(NoAVL no) {
        no.setEsquerda(rotacionaEsquerda(no.getEsquerda()));
        return rotacionaDireita(no);
    }

    private NoAVL rotacionaDireitaDepoisEsquerda(NoAVL no) {
        no.setDireita(rotacionaDireita(no.getDireita()));
        return rotacionaEsquerda(no);
    }

    private int altura(NoAVL no) {
        if (no == null) return -1;
        return no.getAltura();
    }

    private void setBalanceamento(NoAVL... nos) {
        for (NoAVL no : nos) {
            calculaAltura(no);
            no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
        }
    }

    public void imprimeArvoreInOrder() {
        imprimeArvoreInOrderRecursivo(this.raiz);
    }

    private void imprimeArvoreInOrderRecursivo(NoAVL no) {
        if (no != null) {
            imprimeArvoreInOrderRecursivo(no.getEsquerda());
            System.out.println("Chave: " + no.getChave() + " | " + "Balanceamento: " + no.getBalanceamento());
            imprimeArvoreInOrderRecursivo(no.getDireita());
        }
    }

    private void calculaAltura(NoAVL no) {
        if (no != null) {
            no.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));
        }
    }

    private void imprimeArvoreComoEstruturaRecursivo(NoAVL no, int nivel, String prefixo) {
        if (no != null) {
            System.out.println(prefixo + "|__ " + no.getChave() + ", " + (no.getDepartamento() != null ? no.getDepartamento().getNome() : "Departamento nulo"));

            if (no.getDireita() != null || no.getEsquerda() != null) {
                imprimeArvoreComoEstruturaRecursivo(no.getDireita(), nivel + 1, prefixo + "|   ");
                imprimeArvoreComoEstruturaRecursivo(no.getEsquerda(), nivel + 1, prefixo + "    ");
            }
        }
    }

    public void imprimeArvoreComoEstrutura() {
        if (this.raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            imprimeArvoreComoEstruturaRecursivo(this.raiz, 0, "");
        }
    }

}