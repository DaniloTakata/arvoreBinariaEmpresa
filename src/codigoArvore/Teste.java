package codigoArvore;

import codigoArvore.AVL.ArvoreAVL;
import codigoArvore.classes.Departamento;

public class Teste {
    public static void main (String [] args) {

        ArvoreAVL arvoreAVL = new ArvoreAVL();

        arvoreAVL.inserir(1, new Departamento("N1"));
        arvoreAVL.inserir(2, new Departamento("N2"));
        arvoreAVL.inserir(3, new Departamento("N3"));
        arvoreAVL.inserir(4, new Departamento("N4"));
        arvoreAVL.inserir(5, new Departamento("N5"));

        System.out.println(arvoreAVL.buscar(5));
        System.out.println(arvoreAVL.buscarId(5).toString());

        arvoreAVL.imprimeArvoreComoEstrutura();

    }

}
