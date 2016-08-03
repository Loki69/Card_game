package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

public class ServerTest {

    public ServerTest() {
    }

    @Test
    public void testInit() {
        try {
            new Thread(Server.init(1054)).start();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testMultiConnect() {
        try {
            Thread.sleep(5000);
            new Thread(new SimpleClient("arad", 1054)).start();
            multiConnect();
        } catch (InterruptedException | IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void multiConnect() throws IOException {
        for (int j = 0; j < 10; j++) {
            InetSocketAddress hostAddress = new InetSocketAddress(1054);
            SocketChannel client = SocketChannel.open(hostAddress);
            String[] messages = new String[]{"MY:ara", "WTF?", "Bye."};
            for (int i = 0; i < messages.length; i++) {
                readWhatSayServer(client);
                writeSomothingServer(client, messages[i]);
            }
            client.close();
        }
    }

    private void readWhatSayServer(SocketChannel client) throws IOException {
        ByteBuffer readBuffer = ByteBuffer.allocate(1000);
        int length = client.read(readBuffer);
        readBuffer.flip();
        byte[] buff = new byte[1024];
        readBuffer.get(buff, 0, length);
        System.out.println("holo" + new String(buff));
    }

    private void writeSomothingServer(SocketChannel client, String messages) throws IOException {
        byte[] message = new String("Client: " + messages).getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(message);
        client.write(buffer);
        buffer.clear();
    }

    @Test
    public void testConnect() {
        System.out.println("her");
        try {
            Thread.sleep(8000);
            new Thread(new SimpleClient("arad", 1064)).start();
            Thread.sleep(8000);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
