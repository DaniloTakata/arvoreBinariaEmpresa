import codigoArvore.Arvore;

import codigoArvore.classes.Departamento;

public class Main {
    public static void main(String[] args) {
        /*
        * Todos os testes realizado foram implementados de uma maneira mais fixa e direta;
        * Intuito apenas de verificar o funcionamento das funções;
        * */

        Arvore avlTree = new Arvore();

        avlTree.insert(1, "RH");
        avlTree.insert(2, "TI");
        avlTree.insert(3, "Vendas");

        int idBuscar = 2;
        Departamento encontrado = avlTree.search(idBuscar);
        if (encontrado != null) {
            System.out.println("Departamento encontrado: " + encontrado.getNome());
        } else {
            System.out.println("Departamento não encontrado.");
        }

        int idAtualizar = 2;
        String novoNome = "Tecnologia da Informação";
        avlTree.update(idAtualizar, novoNome);

        int idExcluir = 1;
        avlTree.delete(idExcluir);

        System.out.println("Árvore AVL:");
        avlTree.printTree();

    }
}