import java.util.Scanner;

public class CoffeeMachine {

    private static void printDetails(int waterAmount, int milkAmount, int coffeeBeans, int disposableCups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(waterAmount + " of water");
        System.out.println(milkAmount + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    private static void outOfResources(String type, int waterAmount, int coffeeBeans, int milkAmount, int disposableCups) {
        if(disposableCups == 0){
            return;
        }
        if(type.equals("1")){
            if(waterAmount < 250) {
                System.out.println("Sorry, not enough water!");
                return;
            }
            if(coffeeBeans < 16) {
                System.out.println("Sorry, not enough coffee beans!");
                return;
            }
        } else if(type.equals("2")){
            if(waterAmount < 350) {
                System.out.println("Sorry, not enough water!");
                return;
            }
            if(coffeeBeans < 20) {
                System.out.println("Sorry, not enough coffee beans!");
                return;
            }
            if(milkAmount < 75) {
                System.out.println("Sorry, not enough milk!");
                return;
            }
        } else {
            if(waterAmount < 200) {
                System.out.println("Sorry, not enough water!");
                return;
            }
            if(coffeeBeans < 12) {
                System.out.println("Sorry, not enough coffee beans!");
                return;
            }
            if(milkAmount < 100) {
                System.out.println("Sorry, not enough milk!");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int waterAmount = 400;
        int milkAmount = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;
        String action;
        while(true) {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
            if(action.equals("exit")){
                break;
            } else {
                switch(action){
                    case "buy":
                        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                        String option = scanner.nextLine();
                        if(option.equals("1")){
                            if(waterAmount >= 250 && coffeeBeans >= 16) {
                                System.out.println("I have enough resources, making you a coffee!");
                                System.out.println();
                                waterAmount -= 250;
                                coffeeBeans -= 16;
                                money += 4;
                                disposableCups -= 1;
                            } else {
                                outOfResources(option, waterAmount , coffeeBeans , milkAmount, disposableCups);
                                System.out.println();
                            }
                        } else if (option.equals("2")) {
                            if(waterAmount >= 350 && coffeeBeans >= 20 && milkAmount >= 75) {
                                System.out.println("I have enough resources, making you a coffee!");
                                System.out.println();
                                waterAmount -= 350;
                                milkAmount -= 75;
                                coffeeBeans -= 20;
                                money += 7;
                                disposableCups -= 1;
                            } else {
                                outOfResources(option, waterAmount, coffeeBeans, milkAmount, disposableCups);
                                System.out.println();
                            }
                        } else if (option.equals("3")) {
                            if(waterAmount >= 200 && coffeeBeans >= 12 && milkAmount >= 100) {
                                System.out.println("I have enough resources, making you a coffee!");
                                System.out.println();
                                waterAmount -= 200;
                                milkAmount -= 100;
                                coffeeBeans -= 12;
                                money += 6;
                                disposableCups -= 1;
                            } else {
                                outOfResources(option, waterAmount , coffeeBeans , milkAmount, disposableCups);
                                System.out.println();
                            }
                        } else if (option.equals("back")){
                            break;
                        }
                        break;
                    case "take":
                        System.out.println();
                        System.out.println("I gave you $" + money);
                        money = 0;
                        System.out.println();
                        break;
                    case "fill":
                        System.out.println();
                        System.out.print("Write how many ml of water do you want to add: ");
                        int addedWater = scanner.nextInt();
                        waterAmount += addedWater;
                        System.out.print("Write how many ml of milk do you want to add: ");
                        int addedMilk = scanner.nextInt();
                        milkAmount += addedMilk;
                        System.out.print("Write how many grams of coffee beans do you want to add: ");
                        int addedCoffeeBeans = scanner.nextInt();
                        coffeeBeans += addedCoffeeBeans;
                        System.out.print("Write how many disposable cups of coffee do you want to add: ");
                        int addedCups = scanner.nextInt();
                        disposableCups += addedCups;
                        System.out.println();
                        break;
                    case "remaining":
                        printDetails(waterAmount, milkAmount, coffeeBeans, disposableCups, money);
                        System.out.println();
                        break;
                    default:
                        break;
                }
            }
        }

    }
}
