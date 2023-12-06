package codigoArvore;

import codigoArvore.AVL.ArvoreAVL;
import codigoArvore.AVL.NoAVL;
import codigoArvore.classes.Departamento;
import codigoArvore.classes.Funcionario;
import codigoArvore.classes.Gerente;
import codigoArvore.lista.Celula;
import codigoArvore.lista.ListaCelula;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "** MENU **" +
                "\n1. Inserir Departamento" +
                "\n2. Buscar Departamento" +
                "\n3. Excluir Departamento" +
                "\n4. Inserir novo Funcionário" +
                "\n5. Excluir funcionário" +
                "\n6. Atualizar Gerente" +
                "\n7. Mostrar empresa" +
                "\n8. Sair" +
                "\nDigite o comando: ";
        int comando;

        ArvoreAVL arvoreAVL = new ArvoreAVL(); // 1
        arvoreAVL.inserir(0, new Departamento("CEO"));
        int idControle = 1;

        System.out.print(menu);
        comando = sc.nextInt();

        while (comando != 8) {
            switch (comando) {

                default -> {
                    System.out.println("\nComando não entendido!");
                    break;
                } case 1 -> {
                    System.out.print("\nDigite o nome do Departamento: ");
                    String nomeDepartamento = sc.next();

                    System.out.print("\nDigite o nome do Gerente: ");
                    String nomeGerente = sc.next();

                    System.out.print("\nDigite o nome do primeiro Funcionário: ");
                    String nomeFuncionario = sc.next();
                    System.out.print("\nDigite o cargo do primeiro Funcionário: ");
                    String cargoFuncionario = sc.next();

                    ListaCelula funcionarios = new ListaCelula();
                    funcionarios.insereCelula(new Celula(new Funcionario(nomeFuncionario, cargoFuncionario)));
                    Gerente gerente = new Gerente(nomeGerente);
                    gerente.setFuncionario(funcionarios);

                    arvoreAVL.inserir(idControle, new Departamento(nomeDepartamento, gerente));
                    idControle++;

                    System.out.print("\nInserido com sucesso!");

                    break;
                } case 2 -> {
                    System.out.print("\nDigite o id do Departamento a ser buscado: ");
                    int depBuscado = sc.nextInt();

                    NoAVL noAVLEncontrado = arvoreAVL.buscarId(depBuscado);
                    if (noAVLEncontrado != null) {
                        System.out.print("\nDepartamento encontrado! \n" + (noAVLEncontrado.getDepartamento())
                                .toString());
                    } else {
                        System.out.println("\nDepartamento não encontrado!");
                    }

                    break;
                } case 3 -> {
                    System.out.print("\nDigite o id do Departamento à ser removido: ");
                    int depBuscado = sc.nextInt();

                    int retorno = arvoreAVL.remover(depBuscado);
                    if (retorno == 1) {
                        System.out.print("\nDepartamento excluído com sucesso!");
                    } else if (retorno == -1) {
                        System.out.print("\nNão é possível excluir o CEO!");
                    } else if (retorno == 0) {
                        System.out.print("\nNão existem Departamentos!");
                    } else {
                        System.out.print("\nDepartamento não encontrado!");
                    }

                    break;
                } case 4 -> {
                    System.out.print("\nDigite o id do Departamento: ");
                    int depBuscado = sc.nextInt();

                    NoAVL noAVLEncontrado = arvoreAVL.buscarId(depBuscado);
                    if (noAVLEncontrado != null) {

                        System.out.print("\nDigite a quantidade de funcionários: ");
                        int qtdFun = sc.nextInt();

                        int cont = 0;
                        ListaCelula funcionarios = ((noAVLEncontrado.getDepartamento()).getGerente()).getFuncionario();

                        while (cont < qtdFun) {
                            System.out.print("\nDigite o nome do funcionário: ");
                            String nomeFun = sc.next();
                            System.out.print("\nDigite o cargo do funcionário: ");
                            String cargoFun = sc.next();

                            funcionarios.insereCelula(new Celula(new Funcionario(nomeFun, cargoFun)));
                            cont++;
                        }

                        ((noAVLEncontrado.getDepartamento()).getGerente()).setFuncionario(funcionarios);
                    } else {
                        System.out.print("\nDepartamento não encontrado!");
                    }

                    break;
                } case 5 -> {
                    System.out.print("\nDigite o id do Departamento a ser buscado: ");
                    int depBuscado = sc.nextInt();

                    ListaCelula funcionarios = null;
                            NoAVL noAVLEncontrado = arvoreAVL.buscarId(depBuscado);
                    boolean retorno = false;

                    if (noAVLEncontrado != null) {
                        System.out.print("\nDepartamento encontrado! \n" + (noAVLEncontrado.getDepartamento())
                                .toString());
                        funcionarios = ((noAVLEncontrado.getDepartamento()).getGerente())
                                .getFuncionario();

                        System.out.print("\nDigite o nome do funcionário à ser excluído: ");
                        String nomefuncionario = sc.next();

                        retorno = funcionarios.removePorNome(nomefuncionario);
                    }

                    if (retorno) {
                        ((noAVLEncontrado.getDepartamento()).getGerente()).setFuncionario(funcionarios);
                        System.out.println("\nFuncionário excluído com sucesso!");
                    } else {
                        System.out.println("\nFuncionário não encontrado!");
                    }

                    break;
                } case 6 -> {
                    System.out.print("\nDigite o id do Departamento: ");
                    int depBuscado = sc.nextInt();

                    NoAVL noAVLEncontrado = arvoreAVL.buscarId(depBuscado);
                    if (noAVLEncontrado != null) {
                        System.out.print("\nDigite o novo nome do Gerente: ");
                        String nomeGerente = sc.next();

                        ((noAVLEncontrado.getDepartamento()).getGerente()).setNome(nomeGerente);
                        System.out.print("\nGerente atualizado com sucesso! " +
                                ((noAVLEncontrado.getDepartamento()).getGerente()));
                    } else {
                        System.out.print("\nGerente não encontrado!");
                    }

                    break;
                } case 7 -> {
                    System.out.println();
                    arvoreAVL.imprimeArvoreComoEstrutura();
                    break;
                }

            }

            System.out.print("\n\n" + menu);
            comando = sc.nextInt();
        }

        System.out.println("\n\n**SISTEMA FINALIZADO**");

    }


}
