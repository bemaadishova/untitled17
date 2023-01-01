package Players;

public class Warrior extends Hero{
    private int heroesAttack;

    public int getHeroesAttack() {
        return heroesAttack;
    }

    public void setHeroesAttack(int heroesAttack) {
        this.heroesAttack = heroesAttack;
    }

    public Warrior(int health, int damage, String name) {
        super(health, damage,SuperAbility.CRITICAL_DAMAGE,name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}


