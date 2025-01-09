import Elementos.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Agenda agendaTelefonica = new Agenda();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcao;

        while(true){
            System.out.println("\n======Agenda Telefônica======\n");
            System.out.println("1- Inserir Contato");
            System.out.println("2- Remover Contato");
            System.out.println("3- Alterar Contato");
            System.out.println("4- Listar Contatos");
            System.out.println("5- Buscar Contato");
            System.out.println("6- Salvar Contatos");
            System.out.println("7- Recuperar Contatos");
            System.out.println("8- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if(opcao == 8){
                System.out.print("\nTodos os dados não salvos serão perdidos, tem certeza que deseja sair?\n1-Sair\n2-Voltar\n");
                int op = scanner.nextInt();
                scanner.nextLine();
                if(op == 1) {
                    System.out.print("Fechando Agenda...\n\n");
                    break;
                }
                else{
                    continue;
                }
            }

            switch(opcao){
                case 1:
                    System.out.print("Digite o nome: ");
                    String nomeInsere = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite o endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite a relação: ");
                    String relacao = scanner.nextLine();
                    agendaTelefonica.insert(new Contato(nomeInsere, telefone, endereco, relacao));
                    break;

                case 2:
                    System.out.print("Digite o nome do contato que deseja remover: ");
                    String nomeRemove = scanner.nextLine();
                    agendaTelefonica.remove(nomeRemove);
                    break;

                case 3:
                    System.out.print("Digite o nome do contato que deseja alterar: ");
                    String nomeAltera = scanner.nextLine();
                    int opcao2;
                    System.out.print("O que deseja alterar?\n1-Telefone\n2-Endereco\n3-relacao\n");
                    System.out.print("Opcao escolhida: ");
                    opcao2= scanner.nextInt();
                    scanner.nextLine();
                        if(opcao2 == 1){
                            System.out.print("Digite o novo numero: ");
                            String novoNumber = scanner.nextLine();
                            agendaTelefonica.changeNumber(nomeAltera, novoNumber);
                        }
                        if(opcao2 == 2){
                            System.out.print("Digite o novo Endereco: ");
                            String novoAdress = scanner.nextLine();
                            agendaTelefonica.changeAdress(nomeAltera, novoAdress);
                        }
                        if(opcao2 == 3){
                            System.out.print("Digite a nova relacao: ");
                            String novaRelacao = scanner.nextLine();
                            agendaTelefonica.changeRelation(nomeAltera, novaRelacao);
                        }
                    break;

                case 4:
                    agendaTelefonica.exibirLista();
                    break;

                case 5:
                    System.out.print("Digite o nome do contato que deseja buscar: ");
                    String nomeContato = scanner.nextLine();
                    if(agendaTelefonica.buscaContato(nomeContato)!=null){
                        System.out.println(agendaTelefonica.buscaContato(nomeContato));
                    }else{
                        System.out.println("Contato nao encontrado!!\n");
                    }
                    break;

                case 6:
                    System.out.print("Digite o nome do arquivo que deseja salvar: ");
                    String nomeArq = scanner.nextLine();
                    FileWriter arq = new FileWriter(nomeArq);
                    agendaTelefonica.salvarEmArquivo(arq);
                    arq.close();
                    break;

                case 7:
                    System.out.print("Digite o nome do arquivo a carregar as informações: ");
                    String nomeArq2 = scanner.nextLine();
                    FileReader arq2 = new FileReader(nomeArq2);
                    agendaTelefonica.recuperarDeArquivo(arq2);
                    arq2.close();
                    break;

                    
                default:
                    System.out.println("\nOpção invalida!!\n");

            }

        }
    }
}
