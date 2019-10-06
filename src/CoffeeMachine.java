import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeans = scanner.nextInt();
        System.out.print("Write how many cups of coffee you will need: ");
        int cupsOfCoffee = scanner.nextInt();
        if(water >= 200 && milk >= 50 && coffeeBeans >= 15) {
            if(cupsOfCoffee >= 0 ){
                int cupsOfCoffeeAvailable = Math.min(water / 200, milk / 50);
                cupsOfCoffeeAvailable = Math.min(cupsOfCoffeeAvailable , coffeeBeans / 15);
                if (cupsOfCoffeeAvailable < cupsOfCoffee) {
                    System.out.println("No, I can make only " + cupsOfCoffeeAvailable + " cup(s) of coffee");
                } else if(cupsOfCoffeeAvailable == 1){
                    System.out.println("Yes, I can make that amount of coffee");
                } else {
                    water = water - 200*cupsOfCoffee;
                    milk = milk - 50*cupsOfCoffee;
                    coffeeBeans = coffeeBeans - 15*cupsOfCoffee;
                    if(water >= 200 && milk >= 50 && coffeeBeans >= 15) {
                        cupsOfCoffeeAvailable = Math.min(water / 200, milk / 50);
                        cupsOfCoffeeAvailable = Math.min(cupsOfCoffeeAvailable , coffeeBeans / 15);
                        System.out.println("Yes, I can make that amount of coffee (and even " + cupsOfCoffeeAvailable + " more than that)");
                    }
                }
            }
        } else {
            if(cupsOfCoffee >= 1) {
                System.out.println("No, I can make only 0 cup(s) of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        }
    }
}
