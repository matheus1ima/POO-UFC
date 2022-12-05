import java.util.Scanner;

public class Car {

    int pass;
    int passMax;
    int gas;
    int gasMax;
    int km;

    Car(int pass, int passMax, int gas, int gasMax, int maxPass){
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0;
        this.gasMax = 100;
        this.km = 0;
    }

    void enter(){
        if(pass < passMax){
            pass++;
            System.out.println("Um passageiro entrou no carro.");
        } else {
            System.out.println("O carro está lotado.");
        }
    }

    void leave() {
        if(pass > 0){
            pass -= 1;
            System.out.println("Um passageiro deixou o carro.");
        } else {
            System.out.println("O carro está vazio.");
        }
    }

    void drive(int value){
        if((pass > 0) && (gas >= value)){
            gas = gas - value;
            km += value;
            System.out.println(value + " quilômetros percorridos com sucesso.");
        } else if((pass > 0) && (gas < value) && (gas > 0)){
            value = gas;
            gas -= gas;
            km += gas;
            System.out.println("Apenas " + value + " foram quilômetros percorridos.");
        } else if(gas == 0){
            System.out.println("O carro está sem gasolina.");
        } else if(pass == 0){
            System.out.println("O carro está vazio.");
        }
    }

    void fuel(int value){
        if(gas < gasMax){
            if(gas + value > gasMax){
                value = gasMax - gas;
                gas = gasMax;
                System.out.println("Apenas " + value + " litros foram abastecidos.");
            } else if(gas + value <= gasMax){
                gas += value;
                System.out.println(value + " litros foram abastecidos com sucesso.");
            }
        } else {
            System.out.println("O tanque está completamente abastecido.");
        }
        
    }

    public String toString() {
		return "pass: " + pass + "| gas: " + gas + "| km: " + km;  
	}

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Car car = new Car(0, 2, 0, 100, 0);

        System.out.println("Digite 'enter' para embarcar um passageiro no carro\n" +
        "Digite 'leave' para tirar um passageiro do carro\n" +
        "Digite 'drive' para dirigir por X km's. (Digite o valor após dar um espaço)\n" + 
        "Digite 'fuel' para abastecer X litros de gasolina. (Digite o valor após dar um espaço)\n" +
        "Digite 'show' para ver as informações do carro\n" +
        "Digite 'end' para sair");

        while(true){
            String line = input.nextLine();
			String ui[] = line.split(" ");

			if(line.equals("enter")) {
				car.enter();
			} else if(line.equals("leave")){
                car.leave();
            } else if(ui[0].equals("drive")){
                car.drive(Integer.parseInt(ui[1]));
            } else if(ui[0].equals("fuel")){
                car.fuel(Integer.parseInt(ui[1]));
            } else if(line.equals("show")){
                System.out.println(car);
            } else if(line.equals("end")){
                break;
            } else {
                System.out.println("Comando Invalido.");
            }
        }
        
        input.close();
    }
}
