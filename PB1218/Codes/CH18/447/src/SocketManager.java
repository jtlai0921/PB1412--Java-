import java.io.*;
import java.net.*;
import java.util.*;

public class SocketManager extends ArrayList {
    synchronized void add(Socket socket) { // 增加連接套接字方法
        super.add(socket);
    }
    
    synchronized void delete(Socket socket) { // 刪除套接字方法
        super.remove(socket);
    }
    
    synchronized void sendClientConut() { // 輸出目前聊天人數
        String info = "在線人數為：" + size();
        try {
            File file = new File("c://count.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true))); // 建立BufferedWriter對像
            String dates = String.format("%tF %<tT", new Date()); // 對日期進行格式化
            out.write(dates + ":在線人數為" + size()); // 向檔案中寫內容
            out.newLine(); // 新增一行
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(info);
        writeAll(info);
    }
    
    synchronized void writeAll(String str) { // 使用套接字輸出流，輸出資訊
        PrintWriter writer = null;
        Socket socket;
        for (int i = 0; i < size(); i++) { // 循環檢查套接字集合
            socket = (Socket) get(i); // 獲得指定套接字
            try {
                writer = new PrintWriter(socket.getOutputStream(), true); // 建立輸出流
                if (writer != null)
                    writer.println(str); // 透過輸出流寫入資訊
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
