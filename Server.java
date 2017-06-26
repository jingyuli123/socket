
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lijingyu on 2017/6/23.
 */
public class Server {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        OutputStream output = null;
        PrintWriter pw = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("׼�����ӣ�");
            socket = serverSocket.accept();
            in = socket.getInputStream();
            isr= new InputStreamReader(in);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("���Ƿ������ˣ��ͻ���˵��" + info);
            }
            socket.shutdownInput();

            output = socket.getOutputStream();
            pw = new PrintWriter(output);
            pw.write("��ã����Ƿ������ˣ�");
            pw.flush();
			socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
				System.out.println("pw = " + pw);
				System.out.println("output = " + output);
				System.out.println("br = " + br);
				System.out.println("isr = " + isr);
				System.out.println("in = " + in);
				System.out.println("socket = " + socket);
				System.out.println("serverSocket = " + socket);
				System.out.println("<------------------------>");
				
                if (pw != null) {
                    pw.close();
					// pw = null;
                }
                if (output != null) {
                    output.close();
					// output = null;
                }
                if (br != null) {
                    br.close();
					// br = null;
                }
                if (isr != null) {
                    isr.close();
					// isr = null;
                }
                if (in != null) {
                    in.close();
					// in = null;
                }
				if (socket != null) {
                    socket.close();
					// socket = null;
                }
                if (serverSocket != null) {
                    serverSocket.close();
					// serverSocket = null;
                }
				
                System.out.println("pw = " + pw);
				System.out.println("output = " + output);
				System.out.println("br = " + br);
				System.out.println("isr = " + isr);
				System.out.println("in = " + in);
				System.out.println("socket = " + socket);
				System.out.println("serverSocket = " + socket);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
