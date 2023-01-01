package Players;

public class Medic extends Hero{
    private  int healPoints;

    public Medic(int health, int damage, String name, int healPoints) {
        super(health, damage, SuperAbility.HEAL, name);
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0 && heroes[i].getName() !=this.getName()){
                heroes[i].setHealth(heroes[i].getHealth()+ this.healPoints);
                System.out.println("Доктор помог "+heroes[i].getName()+" { "+ this.healPoints+" }");
                break;
            }
        }

    }
}
