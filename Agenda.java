package Elementos;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;


public class Agenda {
    private ArrayList<Contato> agenda;

    public Agenda() {
        this.agenda = new ArrayList<>();
    }

    public Contato buscaContato(String nome) {
        for (Contato contato : agenda) {
            if (nome.equals(contato.getNome())) {
                return contato;
            }
        }
        return null;
    }


    private boolean existeNome(String nome) {
        for (Contato contato : agenda) {
            if (nome.equals(contato.getNome())) {
                return true;
            }
        }
        return false;
    }

    public void insert(Contato c) {
        if (existeNome(c.getNome())) {
            changeAll(c.getNome(), c);
        } else {
            agenda.add(c);
        }
    }

    public void remove(String nome) {
        for (Contato contato : agenda) {
            if (nome.equals(contato.getNome())) {
                agenda.remove(contato);
                break;
            }
        }
    }


    private void changeAll(String nome, Contato novo) {
        int i = 0;
        for (Contato temp : agenda) {
            if (Objects.equals(temp.getNome(), nome)) {
                agenda.set(i, novo);
                break;
            }
            i++;
        }
    }

    public void changeAdress(String nome, String novo) {
        int i = 0;
        for (Contato temp : agenda) {
            if (nome.equals(temp.getNome())) {
                temp.setAdress(novo);
                break;
            }
            i++;
        }
    }

    public void changeNumber(String nome, String novo) {
        int i = 0;
        for (Contato temp : agenda) {
            if (nome.equals(temp.getNome())) {
                temp.setNumero(novo);
                break;
            }
            i++;
        }
    }

    public void changeRelation(String nome, String novo) {
        int i = 0;
        for (Contato temp : agenda) {
            if (nome.equals(temp.getNome())) {
                temp.setRelacao(novo);
                break;
            }
            i++;
        }
    }


    public void salvarEmArquivo(FileWriter arq) {

        try {
            File file = new File(arq.toString());
            if(!file.exists()){
                file.createNewFile();
            }
                for (Contato c : agenda) {
                    arq.write(c.toString() + "\n");
                }
            arq.close();
            } catch(IOException e){
                System.out.println("Ocorreu um erro ao salvar os contatos.");
                e.printStackTrace();
            }
        }



    public void recuperarDeArquivo(FileReader arquivo) {
        try (BufferedReader br = new BufferedReader(arquivo)) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");
                dados[0] = dados[0].replace("Nome: ","").trim();
                dados[1] = dados[1].replace("Telefone: ","").trim();
                dados[2] = dados[2].replace("Endereco: ","").trim();
                dados[3] = dados[3].replace("Relacao: ","").trim();
                Contato contato = new Contato(dados[0], dados[1], dados[2], dados[3]);
                agenda.add(contato);
            }

        } catch (IOException e) {
            System.out.println("Erro ao recuperar contatos.");
            e.printStackTrace();
        }

    }

    public void exibirLista() {
        if (agenda.isEmpty()) {
            System.out.println("\nA lista está vazia!!!\n");
        } else {
            for (Contato c : agenda) {
                System.out.println(c.toString() + "\n");
            }
        }
    }
}