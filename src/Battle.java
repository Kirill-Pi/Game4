public class Battle implements Runnable{

    private Person fighter1;
    private Person fighter2;

    public Battle(Person fighter1, Person fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }


    @Override
    public void run() {

        System.out.println("На нашей поляне начинается смертельная схватка");
        System.out.println("Участники:");
        System.out.println(fighter1.getName() + " и " + fighter2.getName());
        this.go();
        System.out.println("Желаете продолжать (да/нет) ?");



    }

    public void go (){

        do {
            fighter2.damage(fighter1.strike());
            System.out.println(fighter1.getName() + " наносит удар");
            System.out.println("у него " + fighter1.getLife() + " жизни и " + fighter1.getGold() + " золота");
            if (!fighter2.isAlive) {

                break;
            }
            fighter1.damage(fighter2.strike());
            System.out.println(fighter2.getName() + " наносит удар");
            System.out.println("у него " + fighter2.getLife() + " жизни и " + fighter2.getGold() + " золота");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (fighter1.isAlive);
        if (fighter1.getLife() > 0) {

            fighter1.setExperience(fighter1.getExperience() + 1);
            fighter1.setGold(fighter1.getGold() + fighter2.getGold());
            System.out.println("Герой " + fighter1.getName() + " победил");
            System.out.println("у него " + fighter1.getLife() + " жизни и " + fighter1.getGold() + " золота");


        } else {
            System.out.println("Герой проиграл");
            System.exit(1);
        }
    }
}

