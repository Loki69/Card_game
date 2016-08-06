package inventory;

public class Monster {

    private final int attack;
    private final int protection;
    private final int price;
    private final int id;
    private final String name;
    private int hp;
    private Status status;

    private Monster(int id, int attack, int protection, int price,String name) {
        this.id = id;
        this.attack = attack;
        this.protection = protection;
        this.price = price;
        this.hp = protection;
        this.status = Status.SUMMONS;
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public Status getStatus() {
        return status;
    }

    public void changeStatus(Status status) {
        this.status = status;
    }

    public void heal() {
        this.hp = protection;
    }

    public static Monster create(int idMonster) {
        switch (idMonster) {
            case 1:
                return new Monster(1,1,1,1,"King");
            case 2:
                return new Monster(1,1,1,1,"Queen");
            case 3:
                return new Monster(1,1,1,1,"Rook");
            case 4:
                return new Monster(1,1,1,1,"King");
            case 5:
                return new Monster(1,1,1,1,"Bishop");
            case 6:
                return new Monster(1,1,1,1,"Pawn");
            default:
                return new Monster(1,1,1,1,"Empty");
        }
    }

}
