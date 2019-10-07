import java.util.Scanner;

public class CoffeeMachine {

    private static void printDetails(int waterAmount, int milkAmount, int coffeeBeans, int disposableCups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(waterAmount + " of water");
        System.out.println(milkAmount + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private static void buy(int waterAmount, int milkAmount, int coffeeBeans, int disposableCups, int money) {
        Scanner buySc = new Scanner(System.in);
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int option = buySc.nextInt();
        if(option == 1){
            waterAmount -= 250;
            coffeeBeans -= 16;
            money += 4;
        } else if (option == 2) {
            waterAmount -= 350;
            milkAmount -= 75;
            coffeeBeans -= 20;
            money += 7;
        } else if (option == 3) {
            waterAmount -= 200;
            milkAmount -= 100;
            coffeeBeans -= 12;
            money += 6;
        }
        printDetails(waterAmount, milkAmount, coffeeBeans, disposableCups - 1, money);
    }

    private static void fill(int waterAmount, int milkAmount, int coffeeBeans, int disposableCups, int money) {
        Scanner fillSc = new Scanner(System.in);
        System.out.print("Write how many ml of water do you want to add: ");
        int addedWater = fillSc.nextInt();
        waterAmount += addedWater;
        System.out.print("Write how many ml of milk do you want to add: ");
        int addedMilk = fillSc.nextInt();
        milkAmount += addedMilk;
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        int addedCoffeeBeans = fillSc.nextInt();
        coffeeBeans += addedCoffeeBeans;
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        int addedCups = fillSc.nextInt();
        disposableCups += addedCups;
        printDetails(waterAmount, milkAmount, coffeeBeans, disposableCups, money);
    }

    private static void take(int waterAmount, int milkAmount, int coffeeBeans, int disposableCups, int money) {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
        printDetails(waterAmount, milkAmount, coffeeBeans, disposableCups, money);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int waterAmount = 1200;
        int milkAmount = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;
        printDetails(waterAmount, milkAmount, coffeeBeans, disposableCups, money);
        System.out.println();
        System.out.print("Write action (buy, fill, take): ");
        String action = scanner.nextLine();
        if(action.equals("buy")) {
            buy(waterAmount, milkAmount, coffeeBeans, disposableCups, money);
        } else if(action.equals("take")){
            take(waterAmount, milkAmount, coffeeBeans, disposableCups, money);
        } else if(action.equals("fill")){
            fill(waterAmount, milkAmount, coffeeBeans, disposableCups, money);
        } else{
            System.out.println("Error");
        }

    }
}
