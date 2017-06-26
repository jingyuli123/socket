
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lijingyu on 2017/6/23.
 */
public class Server1 {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
		Socket socket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("准备连接！");
			
            while (true) {
			    socket = serverSocket.accept();
			    Server1Thread serverThread = new Server1Thread(socket);
			    serverThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
			try{
				if (serverSocket != null) 
					serverSocket.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
    }

}
