import codigoArvore.Arvore;
import codigoArvore.No;

public class Main {
    public static void main(String[] args) {

        Arvore arvore = new Arvore();

        arvore.setRoot(arvore.insert(arvore.getRoot(), new No(10)));
        arvore.setRoot(arvore.insert(arvore.getRoot(), new No(20)));

        // Buscar por IDs específicos
        arvore.searchById(7);
        arvore.searchById(20);

    }
}