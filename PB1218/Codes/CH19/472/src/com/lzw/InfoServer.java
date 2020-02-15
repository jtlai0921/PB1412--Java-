package com.lzw;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class InfoServer {
    
    /**
     * �B�zSocket�s�����u�{
     * 
     * @author ����L
     */
    private static final class SocketThread extends Thread {
        private static final String TEXT_FILE_PATH = "/com/textFile/";
        private final Socket socket;
        
        private SocketThread(Socket socket) {
            this.socket = socket;
        }
        
        public void run() {
            try {
                // �إ�Socket��J�y���˾�
                final Scanner scanner = new Scanner(socket.getInputStream());
                // �إߦs���r�ɮת��ɮק��ﹳ
                File dir = new File(getClass().getResource(TEXT_FILE_PATH)
                        .toURI());
                String[] files = dir.list();// ��o�ɮצC��}�C
                ObjectOutputStream dout = new ObjectOutputStream(socket
                        .getOutputStream());// �إ߹ﹳ��X�y
                dout.writeObject(files);// ���ɮצC��}�C��X��socket
                while (scanner.hasNext()) {// �ˬdsocket��J�y�����˾����
                    String line = scanner.nextLine();// Ū���@���r
                    InputStream is = getClass().getResourceAsStream(
                            TEXT_FILE_PATH + line);// ���J��r�ɮ׿�J�y
                    ZipOutputStream zout = new ZipOutputStream(socket
                            .getOutputStream());// �إ�socket��ZIP��X�y
                    byte[] data = new byte[1024];// �إ߸�ƽw��
                    int readNum;
                    // ��ZIP��X�y�W�[�@�����Y����
                    zout.putNextEntry(new ZipEntry("one"));
                    while (is != null && (readNum = is.read(data)) > 0) {
                        zout.write(data, 0, readNum);// �VZIP�y�g���
                    }
                    zout.closeEntry();// �������Y����
                    is.close();// �����ɮ׿�J�y
                }
                scanner.close();// ������J�y���˾�
                socket.close();// ����socket
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1598);// �إ�socket�A�Ⱦ��ﹳ
        System.out.println("�A�Ⱦ��w�g�ҰʡC�C�C�C");// ��X���ܸ�T
        while (!ss.isClosed()) {
            final Socket socket = ss.accept();
            new SocketThread(socket).start();
        }
    }
}
