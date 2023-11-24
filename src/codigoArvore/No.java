package codigoArvore;

import codigoArvore.classes.Departamento;
import codigoArvore.classes.Gerente;


public class No {

    Departamento departamento;
    No left, right;
    int height;

    public No(Departamento departamento) {
        this.departamento = departamento;
        this.height = 1;
    }

    public No() {}

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public No getLeft() {
        return left;
    }

    public void setLeft(No left) {
        this.left = left;
    }

    public No getRight() {
        return right;
    }

    public void setRight(No right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "No{" +
                "departamento=" + departamento +
                ", left=" + left +
                ", right=" + right +
                ", height=" + height +
                '}';
    }
}
