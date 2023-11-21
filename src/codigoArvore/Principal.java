package codigoArvore;

import codigoArvore.classes.Departamento;
import codigoArvore.classes.Funcionario;
import codigoArvore.classes.Gerente;
import codigoArvore.lista.Celula;
import codigoArvore.lista.ListaCelula;

import java.util.Scanner;

public class Principal {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "** MENU **" +
                "\n1. Inserir Departamento" +
                "\n2. Inserir Gerente" +
                "\n3. Inserir Funcionário" +
                "\n4. Buscar Departamento" +
                "\n5. Buscar Gerente" +
                "\n6. Buscar Funcionário" +
                "\n7. Excluir Departamento" +
                "\n8. Excluir Gerente" +
                "\n9. Excluir Funcionário" +
                "\n10. Sair" +
                "\nDigite o comando: ";
        int comando;

        System.out.print(menu);
        comando = sc.nextInt();

        Arvore arvore = new Arvore();

        while (comando != 10) {

            switch (comando) {
                default -> {
                    System.out.println("\nComando não encontrado!");
                    break;
                } case 1 -> {
                    System.out.print("\nDigite o id do departamento: ");
                    int id = sc.nextInt();
                    System.out.print("\nDigite o nome do departamento: ");
                    String nome = sc.next();

                    arvore.insert(id, nome);

                    System.out.print("\nAdicionar gerente(S/N)? ");
                    String addGerente = sc.next();

                    Gerente gerente = null;
                    if ((addGerente).equalsIgnoreCase("S")) {
                        System.out.print("\nDigite o nome do gerente: ");
                        String nomeGerente = sc.next();

                        System.out.print("\nAdicionar funcionario(S/N)? ");
                        String addFuncionario = sc.next();

                        ListaCelula listaCelula = null;
                        if ((addFuncionario).equalsIgnoreCase("S")) {
                            System.out.print("\nDigite a quantidade de funcionários: ");
                            int qtdFunc = sc.nextInt();
                            int i = 0;

                            listaCelula = new ListaCelula();
                            while (i < qtdFunc) {
                                System.out.print("\nDigite o nome do funcionário: ");
                                String nomeFun = sc.next();
                                System.out.print("\nDigite o cargo do funcionário: ");
                                String cargoFun = sc.next();

                                listaCelula.insereCelula(new Celula(new Funcionario(nomeFun, cargoFun), new Celula()));

                                i++;
                            }
                        }

                        gerente = new Gerente(nomeGerente);
                        gerente.setFuncionario(listaCelula);
                    }
                    Departamento novoDep = arvore.search(id);
                    novoDep.setGerente(gerente);

                    System.out.println("\nDepartamento inserido com sucesso!");
                    break;
                } case 2 -> {
                    System.out.print("\nDigite o id do Departamento: ");
                    int idBuscado = sc.nextInt();

                    Departamento departamentoEncontrado = arvore.search(idBuscado);

                    if (departamentoEncontrado.getGerente() == null) {

                        System.out.print("\nDigite o nome do gerente: ");
                        String nomeGerente = sc.next();

                        departamentoEncontrado.setGerente(new Gerente(nomeGerente));
                    } else {
                        System.out.println("\nJá existe gerente!");
                    }

                    break;
                } case 3 -> {
                    
                }


            }


            System.out.print(menu);
            comando = sc.nextInt();
        }

    }

}
