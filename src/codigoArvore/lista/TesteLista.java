package codigoArvore.lista;

import codigoArvore.classes.Funcionario;

import java.util.Scanner;

public class TesteLista {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);


        ListaCelula celulas = new ListaCelula();

        String menu = "** MENU **" +
                "\n1. Inserir" +
                "\n2. Buscar" +
                "\n3. Atualizar" +
                "\n4. Remover" +
                "\n5. Sair" +
                "\nOpção: ";
        int comando;

        System.out.print(menu);
        comando = scan.nextInt();

        while (comando != 5) {

            switch (comando) {
                default -> {
                    System.out.println("Comando não encontrado!");
                    break;
                } case 1 -> {
                    System.out.print("\nDigite o nome do funcionário: ");
                    String nome = scan.next();
                    System.out.print("\nDigite o cargo do funcionário: ");
                    String cargo = scan.next();

                    celulas.insereCelula(new Celula(new Funcionario(nome, cargo)));
                    //System.out.println("Inserido com sucesso!!!\n" + );

                    break;
                } case 2 -> {

                    System.out.print("");

                }


            }

        }

    }


}
