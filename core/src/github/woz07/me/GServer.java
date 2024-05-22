package github.woz07.me;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

/**
 * GServer.java
 * The server class that handles information relay between all clients.
 */
public class GServer {
    private Server server;
    public GServer() throws IOException {
        server = new Server();
    
        Kryo kryo = server.getKryo();
        kryo.register(Request.class);
        kryo.register(Response.class);
        
        server.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Request) {
                    Request request = (Request) object;
                
                    // I could get the client and server to both send their x + y coordinates per key press
    
                    Response response = new Response();
                    response.text = "Some response";
                    connection.sendTCP(response);
                }
            }
        });
    
        
        server.start();
        server.bind(54555, 54777);
    }
}
