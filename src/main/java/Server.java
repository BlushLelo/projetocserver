import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    ServerSocket servidor;

    public Server(ServerSocket servidor) throws IOException {
        this.servidor = servidor;
    }

    public ServerSocket getServidor() {
        return servidor;
    }

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }
}
