package client;

import protocol.DecoratorIO;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Connect implements DecoratorIO {
/**
 * To do
 * придумать протокол взаимодействия с сервиров
 * Примичание:
 * 1) По факту у игрок может совершать только одно действие
 * это выбор карты, в зависимости он фазы выброным картам
 * будет присвоен соответствуйший статус
 * 2)Я думаю стоит на стороне клиента сделать
 * выбор карт для боя это упростить протокол связи до одного класса
 * 
 */
    
    private static volatile Connect instance;
    private final SocketChannel client;

    private Connect(String ip, int port) throws IOException {
        InetSocketAddress hostAddress = new InetSocketAddress(ip, port);
        client = SocketChannel.open(hostAddress);
        client.configureBlocking(false);
    }

    public static Connect init(String ip, int port) throws IOException {
        if (instance != null) {
            instance.close();
        }
        instance = new Connect(ip, port);
        return instance;
    }

    @Override
    public String read() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        buffer.clear();
        int read = 0;
        StringBuilder sb = new StringBuilder();
        while ((read = client.read(buffer)) > 0) {
            sb.append(byteBuffToString(buffer));
        }
        return sb.toString();
    }

    private String byteBuffToString(ByteBuffer buffer) {
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        buffer.clear();
        return new String(bytes);
    }

    @Override
    public void write(String message) throws IOException {
        System.out.println(client.write(ByteBuffer.wrap(message.getBytes())));
    }

    @Override
    public void close() {
        try {
            client.close();
            instance = null;
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
