package codigoArvore;

/*
 * ADM -> DEPARTAMENTOS -> GERENTES -> FUNCIONARIOS
 * */

public class Arvore {

    private No root;

    public Arvore() {}

    public Arvore(No root) {
        this.root = root;
    }

    public No getRoot() {
        return root;
    }

    public void setRoot(No root) {
        this.root = root;
    }

    int height(No node) {
            if (node == null) {
                return 0;
            }
            return node.getPeso();
        }

        int max(int a, int b) {
            return (a > b) ? a : b;
        }

        No rightRotate(No y) {
            No x = y.getNoEsquerdo();
            No T2 = x.getNoDireito();

            x.setNoDireito(y);
            y.setNoEsquerdo(T2);

            y.setPeso(max(height(y.getNoEsquerdo()), height(y.getNoDireito())) + 1);
            x.setPeso(max(height(x.getNoEsquerdo()), height(x.getNoDireito())) + 1);

            return x;
        }

        No leftRotate(No x) {
            No y = x.getNoDireito();
            No T2 = y.getNoEsquerdo();

            y.setNoEsquerdo(x);
            x.setNoDireito(T2);

            x.setPeso(max(height(x.getNoEsquerdo()), height(x.getNoDireito())) + 1);
            y.setPeso(max(height(y.getNoEsquerdo()), height(y.getNoDireito())) + 1);

            return y;
        }

        int getBalance(No node) {
            if (node == null) {
                return 0;
            }
            return height(node.getNoEsquerdo()) - height(node.getNoDireito());
        }

        public No insert(No node, No key) {
            if (node == null) {
                return new No(key);
            }

            if (key.getId() < node.getId()) {
                node.setNoEsquerdo(insert(node.getNoEsquerdo(), key));
            } else if (key.getId() > node.getId()) {
                node.setNoDireito(insert(node.getNoDireito(), key));
            } else {
                // Duplicatas não são permitidas (você pode ajustar isso conforme necessário)
                return node;
            }

            node.setPeso(1 + max(height(node.getNoEsquerdo()), height(node.getNoDireito())));

            int balance = getBalance(node);

            // Rotação à direita
            if (balance > 1 && key.getId() < node.getNoEsquerdo().getId()) {
                return rightRotate(node);
            }

            // Rotação à esquerda
            if (balance < -1 && key.getId() > node.getNoDireito().getId()) {
                return leftRotate(node);
            }

            // Rotação dupla à direita (esquerda-direita)
            if (balance > 1 && key.getId() > node.getNoEsquerdo().getId()) {
                node.setNoEsquerdo(leftRotate(node.getNoEsquerdo()));
                return rightRotate(node);
            }

            // Rotação dupla à esquerda (direita-esquerda)
            if (balance < -1 && key.getId() < node.getNoDireito().getId()) {
                node.setNoDireito(rightRotate(node.getNoDireito()));
                return leftRotate(node);
            }

            return node;
        }

        No minValueNode(No node) {
            No current = node;

            while (current.getNoEsquerdo() != null) {
                current = current.getNoEsquerdo();
            }

            return current;
        }

        No delete(No root, int key) {
            if (root == null) {
                return root;
            }

            if (key < root.getId()) {
                root.setNoEsquerdo(delete(root.getNoEsquerdo(), key));
            } else if (key > root.getId()) {
                root.setNoDireito(delete(root.getNoDireito(), key));
            } else {
                // Nó com apenas um filho ou sem filho
                if ((root.getNoEsquerdo() == null) || (root.getNoDireito() == null)) {
                    No temp = null;
                    if (temp == root.getNoEsquerdo()) {
                        temp = root.getNoDireito();
                    } else {
                        temp = root.getNoEsquerdo();
                    }

                    // Nenhum filho
                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else {
                        root = temp; // Copiar o conteúdo do nó não nulo
                    }
                } else {
                    // Nó com dois filhos: obter o sucessor in-order (menor na subárvore direita)
                    No temp = minValueNode(root.getNoDireito());

                    // Copiar o valor do sucessor in-order para este nó
                    root.setId(temp.getId());

                    // Deletar o sucessor in-order
                    root.setNoDireito(delete(root.getNoDireito(), temp.getId()));
                }
            }

            // Se a árvore tinha apenas um nó, então retornar
            if (root == null) {
                return root;
            }

            // Atualizar a altura do nó atual
            root.setPeso(max(height(root.getNoEsquerdo()), height(root.getNoDireito())) + 1);

            // Verificar o balanceamento do nó
            int balance = getBalance(root);

            // Rotação à direita
            if (balance > 1 && getBalance(root.getNoEsquerdo()) >= 0) {
                return rightRotate(root);
            }

            // Rotação à esquerda
            if (balance < -1 && getBalance(root.getNoDireito()) <= 0) {
                return leftRotate(root);
            }

            // Rotação dupla à direita (esquerda-direita)
            if (balance > 1 && getBalance(root.getNoEsquerdo()) < 0) {
                root.setNoEsquerdo(leftRotate(root.getNoEsquerdo()));
                return rightRotate(root);
            }

            // Rotação dupla à esquerda (direita-esquerda)
            if (balance < -1 && getBalance(root.getNoDireito()) > 0) {
                root.setNoDireito(rightRotate(root.getNoDireito()));
                return leftRotate(root);
            }

            return root;
        }

        void deleteNode(int key) {
            root = delete(root, key);
        }

        No search(No root, int key) {
            if (root == null || root.getId() == key) {
                return root;
            }

            if (key < root.getId()) {
                return search(root.getNoEsquerdo(), key);
            }

            return search(root.getNoDireito(), key);
        }

        public void searchById(int key) {
            No result = search(root, key);
            if (result != null) {
                System.out.println("Nó com ID " + key + " encontrado na árvore.");
            } else {
                System.out.println("Nó com ID " + key + " não encontrado na árvore.");
            }
        }

}

