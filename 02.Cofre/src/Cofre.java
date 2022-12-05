import java.util.Scanner;

enum Coin{
    M10(0.10, 1),
    M25(0.25, 2),
    M50(0.50, 3),
    M100(1, 4);
    
    
    double value;
    int volume;

    Coin(double value, int volume){
        this.value = value;
        this.volume = volume;
    }

    public String toString(){
        return "Valor: "+ value +"  Volume: "+ volume;
    }
}

class Item{
    String label;
    int volume;

    Item(String label, int volume){
        this.label = label;
        this.volume = volume;
    }
}

class Pig{
    boolean broken;
    String itens;
	double value;
	int volume;
	int volumeMax;

    Pig(int volumeMax){
		this.broken = false;
        this.volumeMax = volumeMax;
		this.itens="";
		this.value = 0;
		this.volume = 0;
    }

    boolean addCoin(Coin coin){
        if(!broken){
            value += coin.value;
			volume += coin.volume;
            System.out.println("Moeda adicionada com sucesso.");
			return true;
        } else if(volume >= volumeMax){
            System.out.println("O cofre encontra-se cheio.");
            return false;
        } else{
            System.out.println("O cofre encontra-se quebrado.");
            return false;
        }
    }

    boolean addItem(Item item){
        if((!broken) && (volume < volumeMax)){
            itens += item.label + ", ";
			volume += item.volume;
            System.out.println("Item adicionado com sucesso.");
            return true;
        } else if(volume >= volumeMax){
            System.out.println("O cofre encontra-se cheio.");
            return false;
        } else{
            System.out.println("O cofre encontra-se quebrado.");
            return false;
        }
    }

    boolean broke(){
        if(!broken){
            broken = true;
            return true;
        } else {
            return false;
        }
    }

    float getCoins(){
        if(!broken){
            System.out.println("Para pegar moedas, é necessário quebrar o cofre antes.");
        } else {
            System.out.println(value);
		    return (float) value;
        }
        return 0;
    }

    String getItens() {
		if(!broken) {
			System.out.println("Para pegar itens, é necessário quebrar o cofre antes.");
		} else {
            System.out.println(itens);
		    return itens;
        }
        
        return "";
	}

	public String toString() {
		return "Itens: "+ itens +"| Moedas: "+ value +" | Volume: "+ volume +" | Quebrado: "+ broken;
	}
}

public class Cofre {
    public static void main(String[] args) throws Exception {
        Pig pig = new Pig(100);
        Scanner input = new Scanner(System.in);
        
        System.out.println("Digite 'addCoin' para adicionar moeda. (Digite o valor(M10, M25, M50, M100) após dar um espaço)\n" +
        "Digite 'addItem' para tirar um item. (Digite o nome do item após dar um espaço)\n" +
        "Digite 'broke' para quebrar o cofre\n" + 
        "Digite 'getCoins' para pegar moedas\n" +
        "Digite 'getItens' para pegar itens\n" +
        "Digite 'show' para ver as informações do cofre\n" +
        "Digite 'end' para sair");

        while(true){
            String line = input.nextLine();
            String ui[] = line.split(" ");

            if(ui[0].equals("addCoin")){
                if(ui[1].equals("M10")){
                    pig.addCoin(Coin.M10);
                } else if(ui[1].equals("M25")){
                    pig.addCoin(Coin.M25);
                } else if(ui[1].equals("M50")){
                    pig.addCoin(Coin.M50);
                } else if(ui[1].equals("M100")){
                    pig.addCoin(Coin.M100); 
                }
            } else if(ui[0].equals("addItem")){
                pig.addItem(new Item(ui[1], Integer.parseInt(ui[2])));
            } else if(ui[0].equals("broke")){
                pig.broke(); 
            } else if(ui[0].equals("getCoins")){
                pig.getCoins();
            } else if(ui[0].equals("getItens")){
                pig.getItens();
            } else if(ui[0].equals("show")){
                System.out.println(pig);
            } else if(ui[0].equals("end")){
                break;
            } else {
                System.out.println("Comando invalido.");
            }
        }
        input.close();
    }
}
