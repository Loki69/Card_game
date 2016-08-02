package inventory;

import inventory.error.ErrorBay;
import inventory.error.ErrorMessage;
import java.util.ArrayList;

import java.util.List;

public class DeckCards {

    private List<CatalogMonster> catalog;

    public DeckCards() {
        catalog = new ArrayList();
        catalog.add(new CatalogMonster(3, "Tratat"));
        catalog.add(new CatalogMonster(4, "Tratat"));
        catalog.add(new CatalogMonster(5, "Tratat"));
        catalog.add(new CatalogMonster(3, "Tratat"));
        catalog.add(new CatalogMonster(1, "Tratat"));
        catalog.add(new CatalogMonster(2, "Tratat"));
    }

    public boolean availableBay(int idMonster) {
        CatalogMonster select = catalog.get(idMonster);
        return !select.isEmpty();
    }

    public Monster bay(int idMonster) throws ErrorBay {
        if (availableBay(idMonster)) {
            return catalog.get(idMonster).bayOne(idMonster);
        }
        throw new ErrorBay(ErrorMessage.COUNT);
    }
    
    public String printContend(){
        return "";
    }
}
