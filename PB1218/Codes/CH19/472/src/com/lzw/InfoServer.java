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
     * 處理Socket連接的線程
     * 
     * @author 李鍾尉
     */
    private static final class SocketThread extends Thread {
        private static final String TEXT_FILE_PATH = "/com/textFile/";
        private final Socket socket;
        
        private SocketThread(Socket socket) {
            this.socket = socket;
        }
        
        public void run() {
            try {
                // 建立Socket輸入流掃瞄器
                final Scanner scanner = new Scanner(socket.getInputStream());
                // 建立存放文字檔案的檔案夾對像
                File dir = new File(getClass().getResource(TEXT_FILE_PATH)
                        .toURI());
                String[] files = dir.list();// 獲得檔案列表陣列
                ObjectOutputStream dout = new ObjectOutputStream(socket
                        .getOutputStream());// 建立對像輸出流
                dout.writeObject(files);// 把檔案列表陣列輸出到socket
                while (scanner.hasNext()) {// 檢查socket輸入流的掃瞄器資料
                    String line = scanner.nextLine();// 讀取一行文字
                    InputStream is = getClass().getResourceAsStream(
                            TEXT_FILE_PATH + line);// 載入文字檔案輸入流
                    ZipOutputStream zout = new ZipOutputStream(socket
                            .getOutputStream());// 建立socket的ZIP輸出流
                    byte[] data = new byte[1024];// 建立資料緩衝
                    int readNum;
                    // 為ZIP輸出流增加一個壓縮項目
                    zout.putNextEntry(new ZipEntry("one"));
                    while (is != null && (readNum = is.read(data)) > 0) {
                        zout.write(data, 0, readNum);// 向ZIP流寫資料
                    }
                    zout.closeEntry();// 關閉壓縮項目
                    is.close();// 關閉檔案輸入流
                }
                scanner.close();// 關閉輸入流掃瞄器
                socket.close();// 關閉socket
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
        ServerSocket ss = new ServerSocket(1598);// 建立socket服務器對像
        System.out.println("服務器已經啟動。。。。");// 輸出提示資訊
        while (!ss.isClosed()) {
            final Socket socket = ss.accept();
            new SocketThread(socket).start();
        }
    }
}
