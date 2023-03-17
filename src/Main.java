import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isContinue = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя героя:");
        String name = scanner.nextLine();

        Trader trader = new Trader("Шарль Атан", 5, 1, 50, 1, 0, 1, 1000);
        Person monster;
        String input;
        Person hero = new Hero(name, 20, 4, 60, 1, 5, 1);
        System.out.println("герой " + hero.getName() + " создан.");
        while (isContinue) {
            System.out.println("Куда вы хотите пойти?");
            System.out.println("1. К торговцу");
            System.out.println("2. В тёмный лес");
            System.out.println("3. На выход");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("навстречу идет известный целитель " + trader.getName());
                    Trade trade = new Trade(hero, trader);
                    trade.go();
                    break;
                case "2":
                    boolean battleContinue = true;
                    do{
                        if (Math.random() > 0.5) {
                            monster = new Skeleton("Кристофер", 10, 1, 85, 1, 2, 1);
                            System.out.println("появляется скелет " + monster.getName());
                        } else {
                            monster = new Goblin("Людвиг", 15, 6, 40, 1, 2, 1);
                            System.out.println("появляется гоблин " + monster.getName());
                        }
                        Battle battle = new Battle(hero, monster);
                        Thread thread = new Thread(battle);
                        thread.start();
                        String answer = scanner.nextLine();
                        while (!answer.equals("да") && !answer.equals("нет")){
                            System.out.println("Неверный ввод. Попробуйте еще раз.");
                            answer = scanner.nextLine();
                        }
                        if (answer.equals("нет")) battleContinue = false;

                    }while (battleContinue);
                    break;
                case "3":
                    isContinue = false;
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }
    }

}
