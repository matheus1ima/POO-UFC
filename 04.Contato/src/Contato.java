import java.util.ArrayList;
import java.util.Scanner;

class Fone{
    String number;
    String label;

    Fone(String number, String label){
        this.number = number;
        this.label = label;
    }

    boolean validate(String value){
        String aN = "0123456789()"; //aN = allowedNumbers

        for(int i = 0; i < value.length(); i++){
            char c = value.charAt(i);

            if(aN.indexOf(c) != -1){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return this.label + " : " + this.number;
    }
}

public class Contato {
    String name;
    ArrayList<Fone> fones;

    Contato(String name){
        this.name = name;
        this.fones = new ArrayList<>();
    }

    public void addFone(String number, String label){
        Fone fone = new Fone(number, label);
        if(!fone.validate(number)){
            System.out.println("Falha na Operação.");
            return;
        }
        fones.add(fone);
        System.out.println("Numero adicionado com sucesso.");
        return;
    }

    public void rmFone(int index){
        if(index > fones.size()){
            System.out.println("Falha na Operação: Insira um índice válido.");
            return;
        }
        fones.remove(index);
        System.out.println("Numero removido com sucesso.");
        return;
    }

    public String toString(){
		String outPut = "- " + name;

        for(int i = 0; i < fones.size(); i++){
            outPut += " [" + i + ":" + fones.get(i) +"]";
        }
        return outPut;
	}

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do contato: ");
        String line = input.nextLine();
        Contato telefone = new Contato(line);
        
        System.out.println("Insira 'addFone' para adicionar um número. (Insira o número e a descrição logo após, separando-os por espaços.\n" +
        "Insira 'rmFone' para remover um número. (Insira o índice do numero após, separando-os por espaços.\n" +
        "Insira 'show' para ver dados sobre o contato.\n" +
        "Insira 'end' para sair.");

        while(true){
            String command = input.nextLine();
            String[] words = command.split(" ");

            if(words[0].equals("addFone")){
                telefone.addFone(words[1], words[2]);
            }else if(words[0].equals("rmFone")) {
                telefone.rmFone(Integer.parseInt(words[1]));
            }else if(command.equals("show")){
                System.out.println(telefone);
            }else if(command.equals("end")){
                break;
            }else{
                System.out.println("Comando Inválido");
            }
        }
        input.close();
    }
}