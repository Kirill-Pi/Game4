import java.util.Scanner;

public class Trade {

    private Person buyer;
    private Trader seller;

    public Trade(Person buyer, Trader seller) {
        this.buyer = buyer;
        this.seller = seller;
    }

    public void go() {
        boolean isContinue = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доктор " + seller.getName() + " предлагает жизнь в обмен на золото");
        System.out.println("Готовьте наличные. Обмен по курсу один к одному");
        System.out.println("Никто не любит ваше золото больше нас!");
        System.out.println("У вас " + buyer.getGold() + " золота");
        System.out.println("Введите количество золота, которое вы готовы потратить:");
        String input = scanner.nextLine();
        while (isContinue) {
            try {
                int tempSum = Integer.parseInt(input);
                if (tempSum > 0 && tempSum <= buyer.getGold()) {
                    buyer.setGold(buyer.getGold() - tempSum);
                    buyer.setLife(buyer.getLife() + tempSum);
                    seller.setGold(seller.getGold() + tempSum);
                    seller.setRemedy (seller.getRemedy() - tempSum);
                    System.out.println("У вас " + buyer.getGold() + " золота");
                    System.out.println("У вас " + buyer.getLife() + " единиц жизни");
                    isContinue = false;
                } else {
                    System.out.println("Неправильный ввод. Попробуйте еще раз:");
                    input = scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод. Попробуйте еще раз:");
                input = scanner.nextLine();
            }
        }
    }
}
