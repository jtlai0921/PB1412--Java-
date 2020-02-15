import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PicPreviewFileSelectDialog extends JFrame {
    
    private JPanel contentPane;
    private PaintPanel paint;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PicPreviewFileSelectDialog frame = new PicPreviewFileSelectDialog();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public PicPreviewFileSelectDialog() {
        setTitle("支持圖片預覽的文件選擇對話框");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 557, 411);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JFileChooser fileChooser = new JFileChooser();// 建立檔案選擇器
        contentPane.add(fileChooser, BorderLayout.CENTER);// 增加到窗體
        paint = new PaintPanel();// 建立圖片預覽面板
        paint.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
                null));// 設定面板的邊框
        paint.setPreferredSize(new Dimension(150, 300));// 設定預覽面板的大小
        fileChooser.setAccessory(paint);// 把面板設定為檔案選擇器控制項
        // 增加選擇器的屬性事件監聽器
        fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent arg0) {
                do_this_propertyChange(arg0);
            }
        });
        // 設定檔案選擇器的過濾器
        fileChooser.setFileFilter(new FileNameExtensionFilter("圖片檔案", "jpg",
                "png", "gif"));
    }
    
    protected void do_this_propertyChange(PropertyChangeEvent e) {
        // 處理改變選定檔案的屬性事件處理
        if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY == e.getPropertyName()) {
            File picfile = (File) e.getNewValue();// 獲得選定的檔案
            if (picfile != null && picfile.isFile()) {
                try {
                    // 從檔案載入圖片
                    Image image = getToolkit()
                            .getImage(picfile.toURI().toURL());
                    paint.setImage(image);// 設定預覽面板的圖片
                    paint.repaint();// 更新預覽面板的界面
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
