import codigoArvore.AVL.ArvoreAVL;
import codigoArvore.classes.Departamento;


public class Main {
    public static void main(String[] args) {
        /*
        * Árvore totalmente balanceada com todos os funcionamentos
        * */

        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir(1, new Departamento("CEO"));
        arvore.inserir(2, new Departamento("RH"));
        arvore.inserir(3, new Departamento("TI"));
        arvore.inserir(4, new Departamento("VENDAS"));
        arvore.inserir(5, new Departamento("FINANCEIRO"));
        arvore.inserir(6, new Departamento("CONTABIL"));
        arvore.inserir(7, new Departamento("GERENCIA"));
        arvore.inserir(8, new Departamento("DESENVOLVIMENTO"));
        arvore.inserir(9, new Departamento("IMPLANTACAO"));
        arvore.inserir(10, new Departamento("GESTAO"));


        arvore.imprimeArvoreComoEstrutura();

    }
}