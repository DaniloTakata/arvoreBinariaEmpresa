import codigoArvore.AVL.ArvoreAVL;
import codigoArvore.AVL.NoAVL;
import codigoArvore.classes.Departamento;
import codigoArvore.classes.Gerente;


public class Main {
    public static void main(String[] args) {
        /*
        * . Método que procura o nó com o nome do Departamento;
        * .
        * */


        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir(1, new Departamento("CEO", new Gerente("Danilo")));
        arvore.imprimeArvoreComoEstrutura();
        System.out.println("\n\n------------------------------\n");

        arvore.inserir(2, new Departamento("RH", new Gerente("Julinha do picole")));
        arvore.inserir(3, new Departamento("TI", new Gerente("Vinicius")));

        NoAVL noEncontrado = arvore.buscarPorNome("TI");
        if (noEncontrado != null) {

            noEncontrado.setDepartamento(new Departamento("TI", new Gerente("Geovanna")));

        } else {
            System.out.println("\nDepartamento não encontrado!");
        }

        arvore.imprimeArvoreComoEstrutura();

    }
}