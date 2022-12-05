import java.util.Scanner;

class Pet{
    private boolean alive;
    private int clean;
    private int cleanMax;
    private int energy;
    private int energyMax;
    private int hungry;
    private int hungryMax;
    private int age;
    private int diamonds;

    Pet(int cleanMax, int energyMax, int hungryMax){
        this.alive = true;
        this.clean = cleanMax;
        this.cleanMax = cleanMax;
        this.energy = energyMax;
        this.energyMax = energyMax;
        this.hungry = hungryMax;
        this.hungryMax = hungryMax;
        this.age = age;
        this.diamonds = diamonds;
    }

    public boolean testAlive(){
        if(this.clean <= 0 || this.energy <= 0 || this.hungry <= 0){
            this.alive = false;
            System.out.println("Seu tamagotchi está morto.");
            return false;
        } else {
            return true;
        }
    }

    public int getClean(){
        return this.clean;
    }

    private void setClean(int value){
        if(value + this.clean > this.cleanMax){
            this.clean = this.cleanMax;
            return;
        }
        this.clean += value;
    }

    public int getEnergy(){
        return this.energy;
    }

    private void setEnergy(int value){
        if(value + this.energy >= this.energyMax ){
            this.energy = this.energyMax;
            return;
        }
        this.energy += value;
    }

    public int getHungry(){
        return this.hungry;
    }

    private void setHungry(int value){
        if(value + this.hungry >= this.energy){
            this.hungry = this.hungryMax;
            return;
        }
        this.hungry += value;
    }

    public int getCleanMax(){
        return this.cleanMax;
    }

    public int getEnergyMax(){
        return this.energyMax;
    }

    public int getHungryMax(){
        return this.hungryMax;
    }

    public int getDiamonds(){
        return this.diamonds;
    }

    private void setDiamonds(int value){
            this.diamonds += value;
    }

    public int getAge(){
        return this.age;
    }

    private void setAge(int value){
        age += value;
    }

    public void eat(){
        if(testAlive()){
            setClean(-2);
            setEnergy(-1);
            setHungry(4);
            setDiamonds(0);
            setAge(1);
            System.out.println("Seu tamagotchi foi alimentado.");       
            return;
        }
    }

    public void play(){
        if(testAlive()){
            setClean(-3);
            setEnergy(-2);
            setHungry(-1);
            setDiamonds(1);
            setAge(1);    
            System.out.println("Seu tamagotchi se divertiu muito brincando.");         
            return;
        }
    }

    public void shower(){
        if(testAlive()){
            setClean(this.cleanMax);
            setEnergy(-3);
            setHungry(-1);
            setDiamonds(0);
            setAge(2);
            System.out.println("Seu tamagotchi foi banhado.");
            return;
        }      
    }

    public boolean sleepy(){
        if((this.energyMax - this.energy) >=5)
            return true;
        else{
            return false;
        }
    }
    
    public void sleep(){
        if(testAlive()){
            if(sleepy()){
                setEnergy(this.energyMax);
                setHungry(-1);
                setAge(this.energyMax - this.energy);
                System.out.println("Seu tamagotchi descansou."); 
            }else{
                System.out.println("Seu tamagotchi não está com sono.");
            }
        }
    }

    public String toString() {
        return "Energia: " + this.energy + " | Limpeza: " + this.clean + " | Fome: " +
        this.hungry + " | Diamantes: " + this.diamonds + " | Idade: " + this.age;
    }
}

public class Tamagotchi {
    public static void main(String[] args) throws Exception {
        System.out.println("Insira os valores de limpeza, energia e fome.");
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] ui = line.split(" ");

        Pet pug = new Pet(Integer.parseInt(ui[0]), Integer.parseInt(ui[1]), Integer.parseInt(ui[2])); 

        System.out.println("Digite 'eat' para alimentar seu pet\n" +
            "Digite 'play' para divertir seu pet\n" +
            "Digite 'shower' para limpar seu pet\n" + 
            "Digite 'sleep' para o seu pet descansar\n" +
            "Digite 'show' para ver as informações do seu pet\n" +
            "Digite 'end' para sair");

        while(true){

            String comando = input.nextLine();
            
            if(pug.testAlive()){
                if(comando.equals("eat")){
                    pug.eat();
                }else if(comando.equals("play")){
                    pug.play();
                }else if(comando.equals("shower")){
                    pug.shower();
                }else if(comando.equals("sleep")){
                    pug.sleep();
                }else if(comando.equals("show")){
                    System.out.println(pug);
                } else if(comando.equals("end")){
                    break;
                }else{
                    System.out.println("Comando inválido.");
                }
            }
        }

        input.close();
    }
}
