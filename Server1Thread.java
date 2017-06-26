
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Lijingyu on 2017/6/23.
 */
public class Server1Thread extends Thread {

    Socket socket;

    public Server1Thread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("¿Í»§Ëµ£º" + info);
            }
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
				if (socket != null) {
					socket.close();
				}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
