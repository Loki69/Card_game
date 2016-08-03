package inventory;

import java.util.List;

public class Hero {

    private int hp;
    private List<Monster> army;
    private List<Monster> to_attack;

    public void addToArmy(Monster monster) {
        army.add(monster);
    }
    public void swapePositiononAttack(int curuntPosition,int newPosition){
        Monster buffer = to_attack.get(newPosition);
        to_attack.set(newPosition, to_attack.get(curuntPosition));
        to_attack.set(curuntPosition, buffer);
    }
}
