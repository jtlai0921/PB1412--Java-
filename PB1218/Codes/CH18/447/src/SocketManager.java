import java.io.*;
import java.net.*;
import java.util.*;

public class SocketManager extends ArrayList {
    synchronized void add(Socket socket) { // �W�[�s���M���r��k
        super.add(socket);
    }
    
    synchronized void delete(Socket socket) { // �R���M���r��k
        super.remove(socket);
    }
    
    synchronized void sendClientConut() { // ��X�ثe��ѤH��
        String info = "�b�u�H�Ƭ��G" + size();
        try {
            File file = new File("c://count.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true))); // �إ�BufferedWriter�ﹳ
            String dates = String.format("%tF %<tT", new Date()); // �����i��榡��
            out.write(dates + ":�b�u�H�Ƭ�" + size()); // �V�ɮפ��g���e
            out.newLine(); // �s�W�@��
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(info);
        writeAll(info);
    }
    
    synchronized void writeAll(String str) { // �ϥήM���r��X�y�A��X��T
        PrintWriter writer = null;
        Socket socket;
        for (int i = 0; i < size(); i++) { // �`���ˬd�M���r���X
            socket = (Socket) get(i); // ��o���w�M���r
            try {
                writer = new PrintWriter(socket.getOutputStream(), true); // �إ߿�X�y
                if (writer != null)
                    writer.println(str); // �z�L��X�y�g�J��T
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
