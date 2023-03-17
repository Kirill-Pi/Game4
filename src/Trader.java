public class Trader extends Person{

    private int remedy;

    public Trader(String name, int life, int power, int skill, int experience, int gold, int level, int remedy) {
        super(name, life, power, skill, experience, gold, level);
        this.remedy = remedy;
    }

    public void setRemedy(int remedy) {
        this.remedy = remedy;
    }

    public int getRemedy() {
        return remedy;
    }
}

