package inventory;

public class CatalogMonster {

    
    private int count;
    private final String NAME;

    public CatalogMonster(int count, String name) {
        this.count = count;
        this.NAME = name;
    }

    public boolean isEmpty() {
        return count > 0;
    }

    public Monster bayOne(int idMonster) {
        this.count = this.count - 1;
        return Monster.create(idMonster);
    }
}
