import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerProcess {
    private SocketManager socketMan = new SocketManager(); // �إ�SocketManager�ﹳ    
    void getServer() { // �إ߮M���r��k
        try {
            ServerSocket serverSocket = new ServerSocket(7777); // ��Ҥ�ServerSocket�ﹳ
            System.out.println("�A�Ⱦ��M���r�w�إ�");
            while (true) {
                Socket socket = serverSocket.accept(); // ���ݳs��
                new write_Thread(socket).start(); // �Ұʽu�{
                socketMan.add(socket); // �I�s�W�[�M���r��k
                socketMan.sendClientConut(); // �N�ثe�s���ƿ�X              
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    class write_Thread extends Thread { // �������O�A�b�s�u�{���N�ϥΪ̿�J���e��X
        Socket socket = null; // �إ�Socket�ﹳ
        private BufferedReader reader; // �إ�BufferedReader�ﹳ
        private PrintWriter writer; // �إ�PrintWriter�ﹳ        
        public write_Thread(Socket socket) { // �غc��k
            this.socket = socket;
        }        
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                String msg;
                while ((msg = reader.readLine()) != null) {
                    socketMan.writeAll(msg); // �N�Ȥ�ݿ�X��T�g�J�y��
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }    
    public static void main(String[] args) { // �D��k
        ServerProcess server = new ServerProcess(); // �إߥ����O�ﹳ
        server.getServer();
    }
}
