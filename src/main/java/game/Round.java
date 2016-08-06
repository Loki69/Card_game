package game;

public class Round implements RoundLogic {

    @Override
    public boolean round() {
        giveMoney();
        healMonster();
        summon();
        preparToFight();
        preparToFight();
        fight();
        searchDead();
        return findeWiner();
    }

    @Override
    public void giveMoney() {
    }

    @Override
    public void healMonster() {
    }

    @Override
    public void summon() {
    }

    @Override
    public void preparToFight() {
    }

    @Override
    public void fight() {
    }

    @Override
    public void searchDead() {
    }

    @Override
    public boolean findeWiner() {
        return false;
    }

}
