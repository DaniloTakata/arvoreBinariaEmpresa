import codigoArvore.AVL.ArvoreAVL;
import codigoArvore.classes.Departamento;

public class Main {
    public static void main(String[] args) {

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


        System.out.println();
        System.out.print("Balanceamento (in-order): ");
        System.out.println();
        arvore.imprimeArvoreInOrder();

        System.out.println();
        System.out.println("Buscando valor 1...");
        System.out.println(arvore.buscar(1));
        System.out.println();

        System.out.println();
        System.out.println("Buscando valor 7...");
        System.out.println(arvore.buscar(7));
        System.out.println();

        System.out.println();
        System.out.println("Buscando valor 15...");
        System.out.println(arvore.buscar(15));
        System.out.println();

        System.out.println();
        System.out.println("Removendo valor 10...");

        arvore.remover(10);

        System.out.println();
        System.out.print("Balanceamento (in-order): ");
        System.out.println();
        arvore.imprimeArvoreInOrder();

        System.out.println();
        System.out.println("Removendo valor 2...");

        arvore.remover(2);

        System.out.println();
        System.out.print("Balanceamento (in-order): ");
        System.out.println();
        arvore.imprimeArvoreInOrder();

        System.out.println();
        System.out.println("Inserindo valor 12...");
        arvore.inserir(12, new Departamento());

        System.out.println();
        System.out.print("Balanceamento (in-order): ");
        System.out.println();
        arvore.imprimeArvoreInOrder();

        System.out.println();
        System.out.println("Inserindo valor 50...");
        arvore.inserir(50, new Departamento());

        System.out.println();
        System.out.print("Balanceamento (in-order): ");
        System.out.println();
        arvore.imprimeArvoreInOrder();

        System.out.println();
        System.out.println("Tentando remover valor 40 (inexistente)...");
        arvore.remover(40);
        System.out.println("Nada acontece.");

        System.out.println();
        System.out.print("Balanceamento (in-order): ");
        System.out.println();
        arvore.imprimeArvoreInOrder();

        System.out.println();
        System.out.print("Printagem da estrutura");
        arvore.imprimeArvoreComoEstrutura(); // erro nessa funcao, nullpointer

    }
}