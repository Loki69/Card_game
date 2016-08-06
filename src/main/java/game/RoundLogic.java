package game;

public interface RoundLogic {
    public boolean round();
    public void giveMoney();
    public void healMonster();
    public void summon();
    public void preparToFight();
    public void Fight();
    public void searchDead();
    public boolean findeWiner();
}
