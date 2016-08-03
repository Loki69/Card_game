package protocol;

import java.io.IOException;

public interface DecoratorIO {
    public String read() throws IOException;
    public void write(String message) throws IOException;
    public void close();
}
