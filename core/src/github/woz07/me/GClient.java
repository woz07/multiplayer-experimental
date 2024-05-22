package github.woz07.me;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

public class GClient {
    private Client client;
    public GClient() throws IOException {
        client = new Client();
        
        Kryo kryo = client.getKryo();
        kryo.register(Request.class);
        kryo.register(Response.class);
        
        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Response) {
                    Response response = (Response) object;
                    
                }
            }
        });
        
        new Thread(client).start();
        
        client.connect(5000, "SOME_IP_ADDRESS", 54555, 54777);
    }
    
    /**
     * Method to send request to server
     * @param request The request
     */
    public void send(Request request) {
        client.sendTCP(request);
    }
}
