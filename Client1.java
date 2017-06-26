
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Lijingyu on 2017/6/23.
 */
public class Client1 {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream output = null;
        PrintWriter pw = null;

        InputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            output = socket.getOutputStream();
            pw = new PrintWriter(output);
            pw.write("你好，我是客户端！111");
            pw.flush();
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (output != null) {
                    output.close();
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
