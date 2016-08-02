package inventory.error;


public class ErrorBay extends Exception{
    
    public ErrorBay(ErrorMessage error) {
        super(error.getMessage());
    }
    
}
