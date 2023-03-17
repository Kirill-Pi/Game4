public abstract class Person {
    private String name;
    private int life;
    private int power;
    private int skill;
    private int experience;
    private int gold;
    private int level;
    boolean isAlive = true;


    public Person(String name, int life, int power, int skill, int experience, int gold, int level) {
        this.name = name;
        this.life = life;
        this.power = power;
        this.skill = skill;
        this.experience = experience;
        this.gold = gold;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getLife() {
        return life;
    }

    public int getSkill() {
        return skill;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }

    public int strike() {
        int temp;
        if (skill * 3 > Math.random() * 100) temp = power;
        else temp = 0;
        if (Math.random() > 0.75) temp *= 2;
        return temp;
    }

    public void damage(int strike) {
        life -= strike;
        if (life < 0) isAlive = false;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLife(int life) {
        this.life = life;
    }

}

