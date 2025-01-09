package Elementos;

public class Contato {
    private String nome;
    private String numero;
    private String Adress;
    private String relacao;

    public Contato(String nome, String numero, String Adress, String relacao){
        this.nome = nome;
        this.numero = numero;
        this.Adress = Adress;
        this.relacao = relacao;
    }

    public String getNome(){
        return nome;
    }

    public String getAdress(){
        return Adress;
    }

    public String getNumero(){
        return numero;
    }

    public String getRelacao(){
        return relacao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAdress(String Adress){
        this.Adress = Adress;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public void setRelacao(String relacao){
        this.relacao = relacao;
    }


    @Override
    public String toString(){
        return "Nome: " + nome + " | Telefone: " + numero + " | Endereco: " + Adress + " | Relacao: " + relacao;
    }

}
