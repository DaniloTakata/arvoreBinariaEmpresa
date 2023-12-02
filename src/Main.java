import codigoArvore.AVL.ArvoreAVL;
import codigoArvore.classes.Departamento;


public class Main {
    public static void main(String[] args) {
        /*
        * . Método que procura o nó com o nome do Departamento;
        * .
        * */


        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir(1, new Departamento("CEO"));
        arvore.imprimeArvoreComoEstrutura();
        System.out.println("\n\n------------------------------\n");

        arvore.inserir(2, new Departamento("RH"));
        arvore.inserir(3, new Departamento("SUB RH"));
        arvore.inserir(4, new Departamento("VENDAS"));
        arvore.inserir(5, new Departamento("GESTÃO"));
        arvore.inserir(6, new Departamento("ORIPEDES"));
        arvore.inserir(7, new Departamento("MISTER"));
        arvore.imprimeArvoreComoEstrutura();



    }
}