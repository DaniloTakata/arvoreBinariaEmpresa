package codigoArvore;

import codigoArvore.classes.Departamento;

public class Arvore {

    private No root;

    public No getRoot() {
        return root;
    }

    public void setRoot(No root) {
        this.root = root;
    }

    // Métodos CRUD baseados no ID

    // Método para inserir um nó com base no ID
    public void insert(int id, String nome) {
        root = insert(root, new Departamento(id, nome));
    }

    private No insert(No No, Departamento departamento) {
        if (No == null) {
            return new No(departamento);
        }

        if (departamento.getId() < No.departamento.getId()) {
            No.left = insert(No.left, departamento);
        } else if (departamento.getId() > No.departamento.getId()) {
            No.right = insert(No.right, departamento);
        } else {
            // ID já existe, pode ser tratado conforme necessário
            return No;
        }

        // Atualizar altura do nó pai
        No.height = 1 + Math.max(height(No.left), height(No.right));

        // Verificar o fator de balanceamento e realizar rotações, se necessário
        int balance = getBalance(No);

        // Casos de rotação
        if (balance > 1) {
            if (departamento.getId() < No.left.departamento.getId()) {
                return rotateRight(No);
            } else {
                No.left = rotateLeft(No.left);
                return rotateRight(No);
            }
        }
        if (balance < -1) {
            if (departamento.getId() > No.right.departamento.getId()) {
                return rotateLeft(No);
            } else {
                No.right = rotateRight(No.right);
                return rotateLeft(No);
            }
        }

        return No;
    }

    // Método para buscar um nó com base no ID
    public Departamento search(int id) {
        No foundNo = search(root, id);
        return (foundNo != null) ? foundNo.departamento : null;
    }

    private No search(No No, int id) {
        if (No == null || No.departamento.getId() == id) {
            return No;
        }

        if (id < No.departamento.getId()) {
            return search(No.left, id);
        }

        return search(No.right, id);
    }

    // Método para atualizar um nó com base no ID
    public void update(int id, String novoNome) {
        root = update(root, id, novoNome);
    }

    private No update(No No, int id, String novoNome) {
        // Implementação da lógica de atualização na árvore AVL baseada no ID
        if (No == null) {
            return null;
        }

        if (id < No.departamento.getId()) {
            No.left = update(No.left, id, novoNome);
        } else if (id > No.departamento.getId()) {
            No.right = update(No.right, id, novoNome);
        } else {
            // ID encontrado, atualizar o nome
            No.departamento.setNome(novoNome);
        }

        // Atualizar altura do nó pai
        No.height = 1 + Math.max(height(No.left), height(No.right));

        // Verificar o fator de balanceamento e realizar rotações, se necessário
        int balance = getBalance(No);

        // Casos de rotação
        if (balance > 1) {
            if (id < No.left.departamento.getId()) {
                return rotateRight(No);
            } else {
                No.left = rotateLeft(No.left);
                return rotateRight(No);
            }
        }
        if (balance < -1) {
            if (id > No.right.departamento.getId()) {
                return rotateLeft(No);
            } else {
                No.right = rotateRight(No.right);
                return rotateLeft(No);
            }
        }

        return No;
    }

    // Método para excluir um nó com base no ID
    public void delete(int id) {
        root = delete(root, id);
    }

    private No delete(No No, int id) {
        // Implementação da lógica de exclusão na árvore AVL baseada no ID
        if (No == null) {
            return null;
        }

        if (id < No.departamento.getId()) {
            No.left = delete(No.left, id);
        } else if (id > No.departamento.getId()) {
            No.right = delete(No.right, id);
        } else {
            // Nó encontrado, realizar a exclusão

            // Caso 1: Nó com um ou nenhum filho
            if (No.left == null || No.right == null) {
                No temp = (No.left != null) ? No.left : No.right;

                // Caso 1a: Nenhum filho
                if (temp == null) {
                    temp = No;
                    No = null;
                } else { // Caso 1b: Um filho
                    No = temp;
                }
            } else { // Caso 2: Nó com dois filhos
                No temp = findMin(No.right);
                No.departamento = temp.departamento;
                No.right = delete(No.right, temp.departamento.getId());
            }
        }

        // Se o nó foi excluído, retornar null
        if (No == null) {
            return null;
        }

        // Atualizar altura do nó pai
        No.height = 1 + Math.max(height(No.left), height(No.right));

        // Verificar o fator de balanceamento e realizar rotações, se necessário
        int balance = getBalance(No);

        // Casos de rotação
        if (balance > 1) {
            if (getBalance(No.left) >= 0) {
                return rotateRight(No);
            } else {
                No.left = rotateLeft(No.left);
                return rotateRight(No);
            }
        }
        if (balance < -1) {
            if (getBalance(No.right) <= 0) {
                return rotateLeft(No);
            } else {
                No.right = rotateRight(No.right);
                return rotateLeft(No);
            }
        }

        return No;
    }

    // Métodos de auxílio

    // Altura de um nó (considera nulo como altura 0)
    private int height(No No) {
        return (No == null) ? 0 : No.height;
    }

    // Fator de balanceamento de um nó
    private int getBalance(No No) {
        return (No == null) ? 0 : height(No.left) - height(No.right);
    }

    // Rotações

    // Rotação à direita
    private No rotateRight(No y) {
        No x = y.left;
        No T2 = x.right;

        x.right = y;
        y.left = T2;

        // Atualizar alturas
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    // Rotação à esquerda
    private No rotateLeft(No x) {
        No y = x.right;
        No T2 = y.left;

        y.left = x;
        x.right = T2;

        // Atualizar alturas
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    // Encontrar o nó mínimo em uma subárvore
    private No findMin(No No) {
        while (No.left != null) {
            No = No.left;
        }
        return No;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(No node) {
        if (node != null) {
            printTree(node.left);
            System.out.println("ID: " + node.departamento.getId() + ", Nome: " + node.departamento.getNome());
            printTree(node.right);
        }
    }

    // Percurso pré-ordem: Raiz -> Esquerda -> Direita
    public void percorrerPreOrdem(No no) {
        if (no != null) {
            System.out.print(no.getDepartamento().getNome()+ " ");
            percorrerPreOrdem(no.left);
            percorrerPreOrdem(no.right);
        }
    }

    // Percurso em ordem: Esquerda -> Raiz -> Direita
    public void percorrerEmOrdem(No no) {
        if (no != null) {
            percorrerEmOrdem(no.left);
            System.out.print(no.getDepartamento().getNome() + " ");
            percorrerEmOrdem(no.right);
        }
    }

    // Percurso pós-ordem: Esquerda -> Direita -> Raiz
    public void percorrerPosOrdem(No no) {
        if (no != null) {
            percorrerPosOrdem(no.left);
            percorrerPosOrdem(no.right);
            System.out.print(no.getDepartamento().getNome() + " ");
        }
    }

}

