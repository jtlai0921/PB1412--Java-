import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerProcess {
    private SocketManager socketMan = new SocketManager(); // 建立SocketManager對像    
    void getServer() { // 建立套接字方法
        try {
            ServerSocket serverSocket = new ServerSocket(7777); // 實例化ServerSocket對像
            System.out.println("服務器套接字已建立");
            while (true) {
                Socket socket = serverSocket.accept(); // 等待連接
                new write_Thread(socket).start(); // 啟動線程
                socketMan.add(socket); // 呼叫增加套接字方法
                socketMan.sendClientConut(); // 將目前連接數輸出              
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    class write_Thread extends Thread { // 內部類別，在新線程中將使用者輸入內容輸出
        Socket socket = null; // 建立Socket對像
        private BufferedReader reader; // 建立BufferedReader對像
        private PrintWriter writer; // 建立PrintWriter對像        
        public write_Thread(Socket socket) { // 建構方法
            this.socket = socket;
        }        
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                String msg;
                while ((msg = reader.readLine()) != null) {
                    socketMan.writeAll(msg); // 將客戶端輸出資訊寫入流中
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }    
    public static void main(String[] args) { // 主方法
        ServerProcess server = new ServerProcess(); // 建立本類別對像
        server.getServer();
    }
}
