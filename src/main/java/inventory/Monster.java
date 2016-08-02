package inventory;

public enum Monster {
    Empty(0, 0, 0, 0),
    King(1, 1, 1, 1),
    Queen(2, 1, 1, 1),
    Rook(3, 1, 1, 1),
    Bishop(4, 1, 1, 1),
    Knight(5, 1, 1, 1),
    Pawn(6, 1, 1, 1);

    private final int attack;
    private final int protection;
    private final int price;
    private final int id;
    private int hp;
    private Status status;

    Monster(int id, int attack, int protection, int price) {
        this.id = id;
        this.attack = attack;
        this.protection = protection;
        this.price = price;
        this.hp = protection;
        this.status = Status.SUMMONS;
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
            case 0:
                return Monster.Empty;
            case 1:
                return Monster.King;
            case 2:
                return Monster.Queen;
            case 3:
                return Monster.Rook;
            case 4:
                return Monster.King;
            case 5:
                return Monster.Bishop;
            case 6:
                return Monster.Pawn;
            default:
                return Monster.Empty;
        }
    }

}
