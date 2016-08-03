package inventory.error;

public enum ErrorMessage{


    COUNT("You can't buy because that there is no available"),
    MONEY("You can't buy because not enough money");

    private final String message;

    public String getMessage() {
        return message;
    }
    ErrorMessage(String message) {
        this.message = message;
    }
    
}
