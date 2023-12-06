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
                "\n5. Printar lista" +
                "\n6. Sair" +
                "\nOpção: ";
        int comando;

        System.out.print(menu);
        comando = scan.nextInt();

        while (comando != 6) {

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
                    System.out.println("Inserido com sucesso!!!\n" + celulas.buscaNome(nome));

                    break;
                } case 2 -> {
                    System.out.print("\nDigite o nome do Funcionário buscado: ");
                    String nomeFuncionarioBuscado = scan.next();

                    Funcionario funcionarioEncontrado = celulas.buscaNome(nomeFuncionarioBuscado);

                    if (funcionarioEncontrado != null) {
                        System.out.println("\nFuncionário encontrado!!! " + funcionarioEncontrado.toString());
                    } else {
                        System.out.println("\nFuncionário não encontrado!!!");
                    }

                    break;
                } case 3 -> {
                    System.out.print("\nDigite o nome do Funcionário buscado: ");
                    String nomeFuncionarioBuscado = scan.next();

                    Funcionario funcionarioEncontrado = celulas.buscaNome(nomeFuncionarioBuscado);

                    if (funcionarioEncontrado != null) {
                        System.out.println("\nFuncionário encontrado!!! " + funcionarioEncontrado.toString());

                        System.out.print("\nDigite o novo nome do funcionário: ");
                        String novoNome = scan.next();
                        System.out.print("\nDigite o novo cargo do funcionário: ");
                        String novoCargo = scan.next();

                        funcionarioEncontrado.setNome(novoNome);
                        funcionarioEncontrado.setCargo(novoCargo);

                    } else {
                        System.out.println("\nFuncionário não encontrado!!!");
                    }

                    break;
                } case 4 -> {
                    System.out.print("\nDigite a posição a ser removida: ");
                    String nomeBuscado = scan.next();

                    System.out.println(celulas.removePorNome(nomeBuscado));

                    break;
                } case 5 -> {
                    System.out.println(celulas.printarLista());

                    break;
                }
            }
            System.out.print("\n\n" + menu);
            comando = scan.nextInt();
        }

        scan.close();
        System.out.println("\nSISTEMA FINALIZADO!!!");
    }

}
