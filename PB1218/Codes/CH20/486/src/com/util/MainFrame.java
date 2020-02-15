package com.util;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import javax.swing.filechooser.FileFilter;
import com.sun.pdfview.FullScreenWindow;
import com.sun.pdfview.OutlineNode;

import com.sun.pdfview.PDFFile;

import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;

public class MainFrame extends JFrame 
         {
    
    /**
     * @param args
     */
    // 放置主內容的面板
    JPanel jpmain = new JPanel();
    // 放置讀取PDF文件內容的面板
    PagePanel jp;
    // 全螢幕顯示面板
    FullScreenWindow fullScreen;
    
    JScrollPane documentScroller = new JScrollPane();
    // PDFRender包中獲得PDF文件的PDFFile類別
    PDFFile pdffile;
    // 使用者填寫頁碼的文字框
    JTextField pageField;
    
    int curpage = -1;
    // 用於獲得大綱的OutlineNode對像
    OutlineNode outline = null;
    JButton smallButton;
    JButton fullScreenButton;
    PageFormat pformat = PrinterJob.getPrinterJob().defaultPage();
    String docName;
    
    private Timer activityMonitor;
    private SimulateActivity activity;
    PagePanel fspp;

    
    private Point loc = null;
    private Point tmp = null;
    private boolean isDragged = false;
    
    public MainFrame() {
        setTitle("顯示PDF檔案");
        setSize(new Dimension(721, 666));
        getContentPane().setLayout(null);
        getContentPane().add(CreateMenuBar());
        /*
         * 建立中間的內容面板
         */
        jp = new PagePanel();

        jp.addMouseMotionListener(new JPMouseMotionAction());
        contentPanel = new JScrollPane();
        contentPanel.setBounds(0, 26, 705, 607);
        getContentPane().add(contentPanel);
        contentPanel.setColumnHeaderView(jpmain);
        jpmain.setLayout(new GridLayout(0, 1));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - getWidth()) / 2;
        int y = (screen.height - getHeight()) / 2;
        setLocation(x, y);
    }
    
    public static void main(String[] args) {
        // TODO 自動產生方法存根
        new MainFrame().setVisible(true);
    }
    //定義選單方法
    public JMenuBar CreateMenuBar() {
        
        final JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 705, 25);
        final JMenu newItemMenuItem1 = new JMenu();
        newItemMenuItem1.setText("檔案(F)");
        
        menuBar.add(newItemMenuItem1);
        final JMenuItem openfile = new JMenuItem();
        openfile.setText("開啟");
        newItemMenuItem1.add(openfile);
        openfile.setToolTipText("Open PDF file");
        openfile
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // TODO 自動產生方法存根
                        doOpen();   //開啟選單按鈕呼叫doOpen()方法
                    }
                });
        return menuBar;
    }

    
    
    //為檔案選擇器增加過濾器
    private File prevDirChoice;    
    FileFilter pdfFilter = new FileFilter() {
        
        public boolean accept(File f) {
            return f.isDirectory() || f.getName().endsWith(".pdf");
        }
        
        public String getDescription() {
            return "Choose a PDF file";
        }
    };    
    private JScrollPane contentPanel;       
    public void doOpen() {
        try {
            if (jp != null) {
                doClose();
            }
            JFileChooser fc = new JFileChooser();   //建立JFileChooser實例
            fc.setCurrentDirectory(prevDirChoice);  //設定目前路徑
            fc.setFileFilter(pdfFilter);            //增加檔案過濾器
            fc.setMultiSelectionEnabled(false);    
            int returnVal = fc.showOpenDialog(this);    //開啟檔案選擇器
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    prevDirChoice = fc.getSelectedFile();   //獲得使用者選擇的路徑
                    RandomAccessFile raf = new RandomAccessFile(prevDirChoice
                            .getAbsolutePath(), "r");   //實例化可隨機存取的檔案對像
                    FileChannel channel = raf.getChannel(); //實例化FileChannel對像
                    ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,
                            0, channel.size()); 
                    try {
                        pdffile = new PDFFile(buf);     //實例化一個PDFFile實例
                    } catch (IOException ioe) {
                        return;
                    }
                    docName = prevDirChoice.getName();
                    setTitle(docName);
                    activityMonitor = new Timer(500, new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            int current = activity.getCurrent();
                            contentPanel.getVerticalScrollBar().setValue(
                                    current);
                            if (current == activity.getTarget()) {
                                activityMonitor.stop();
                                
                            }
                        }
                    });
                    
//由於將PDF文件顯示出來會耗費記憶體，所以本實例將前10頁文件顯示在主窗體上，如果將for循環的終止值修改為pdffile.getNumPages()，則表示顯示所有PDF文件中的所有頁面
                    for (int i = 1; i < 10; i++) {
                        contentPanel.setViewportView(jpmain); // 將主面板放置在捲動面板上
                        activity = new SimulateActivity(contentPanel
                                .getVerticalScrollBar().getMaximum());
                        new Thread(activity).start();
                        activityMonitor.start();
                        PDFPage page = pdffile.getPage(i); // 獲得每頁PDF文件
                        PagePanel jp2 = new PagePanel(); // 實例化PagePanel對像
                        jpmain.add(jp2); // 將面板對像增加到主面板中
                        validate(); // 更新窗體
                        jp2.showPage(page); // 顯示該頁PDF文件
                    }

                    try {
                        outline = pdffile.getOutline();
                    } catch (IOException ioe) {
                    }
                    if (outline != null) {
                        if (outline.getChildCount() > 0) {
                            JTree jt = new JTree(outline);
                            jt.setRootVisible(false);                          
                            JScrollPane jsp = new JScrollPane(jt);                            
                        }                        
                    }
                } catch (Exception ioe) {
                    ioe.printStackTrace();
                }
                validate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void gotoPage(int pagenum) {
        if (pagenum < 0) {
            pagenum = 0;
        } else if (pagenum >= pdffile.getNumPages()) {
            pagenum = pdffile.getNumPages() - 1;
        }
        
    }
    

    
    public void doClose() {
        if (jp != null) {
            jpmain.removeAll();
        }
        pdffile = null;
    }
    
    public void doPageSetup() {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        pformat = pjob.pageDialog(pformat);
    }

  
    private final class JPMouseMotionAction extends
            java.awt.event.MouseMotionAdapter {
        public void mouseDragged(java.awt.event.MouseEvent e) {
            if (isDragged) {// 在拖放事件中不斷記下和改變位置
                loc = new Point(jp.getLocation().x + e.getX() - tmp.x, jp
                        .getLocation().y
                        + e.getY() - tmp.y);
                jp.setLocation(loc);
            }
        }
    }  
    
    class SimulateActivity implements Runnable {
        private volatile int current;        
        private int target;        
        public SimulateActivity(int t) {
            // TODO 自動產生建構函數存根
            current = 0;
            target = t;
        }        
        public int getTarget() {
            return target;
        }        
        public int getCurrent() {
            return current;
        }        
        public void run() {
            try {
                while (current < target) {
                    Thread.sleep(100);
                    current++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }  
 
}
