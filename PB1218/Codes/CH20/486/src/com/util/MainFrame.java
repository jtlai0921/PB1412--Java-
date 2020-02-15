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
    // ��m�D���e�����O
    JPanel jpmain = new JPanel();
    // ��mŪ��PDF��󤺮e�����O
    PagePanel jp;
    // ���ù���ܭ��O
    FullScreenWindow fullScreen;
    
    JScrollPane documentScroller = new JScrollPane();
    // PDFRender�]����oPDF���PDFFile���O
    PDFFile pdffile;
    // �ϥΪ̶�g���X����r��
    JTextField pageField;
    
    int curpage = -1;
    // �Ω���o�j����OutlineNode�ﹳ
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
        setTitle("���PDF�ɮ�");
        setSize(new Dimension(721, 666));
        getContentPane().setLayout(null);
        getContentPane().add(CreateMenuBar());
        /*
         * �إߤ��������e���O
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
        // TODO �۰ʲ��ͤ�k�s��
        new MainFrame().setVisible(true);
    }
    //�w�q����k
    public JMenuBar CreateMenuBar() {
        
        final JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 705, 25);
        final JMenu newItemMenuItem1 = new JMenu();
        newItemMenuItem1.setText("�ɮ�(F)");
        
        menuBar.add(newItemMenuItem1);
        final JMenuItem openfile = new JMenuItem();
        openfile.setText("�}��");
        newItemMenuItem1.add(openfile);
        openfile.setToolTipText("Open PDF file");
        openfile
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // TODO �۰ʲ��ͤ�k�s��
                        doOpen();   //�}�ҿ����s�I�sdoOpen()��k
                    }
                });
        return menuBar;
    }

    
    
    //���ɮ׿�ܾ��W�[�L�o��
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
            JFileChooser fc = new JFileChooser();   //�إ�JFileChooser���
            fc.setCurrentDirectory(prevDirChoice);  //�]�w�ثe���|
            fc.setFileFilter(pdfFilter);            //�W�[�ɮ׹L�o��
            fc.setMultiSelectionEnabled(false);    
            int returnVal = fc.showOpenDialog(this);    //�}���ɮ׿�ܾ�
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    prevDirChoice = fc.getSelectedFile();   //��o�ϥΪ̿�ܪ����|
                    RandomAccessFile raf = new RandomAccessFile(prevDirChoice
                            .getAbsolutePath(), "r");   //��Ҥƥi�H���s�����ɮ׹ﹳ
                    FileChannel channel = raf.getChannel(); //��Ҥ�FileChannel�ﹳ
                    ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,
                            0, channel.size()); 
                    try {
                        pdffile = new PDFFile(buf);     //��ҤƤ@��PDFFile���
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
                    
//�ѩ�NPDF�����ܥX�ӷ|�ӶO�O����A�ҥH����ұN�e10�������ܦb�D����W�A�p�G�Nfor�`�����פ�ȭקאּpdffile.getNumPages()�A�h�����ܩҦ�PDF��󤤪��Ҧ�����
                    for (int i = 1; i < 10; i++) {
                        contentPanel.setViewportView(jpmain); // �N�D���O��m�b���ʭ��O�W
                        activity = new SimulateActivity(contentPanel
                                .getVerticalScrollBar().getMaximum());
                        new Thread(activity).start();
                        activityMonitor.start();
                        PDFPage page = pdffile.getPage(i); // ��o�C��PDF���
                        PagePanel jp2 = new PagePanel(); // ��Ҥ�PagePanel�ﹳ
                        jpmain.add(jp2); // �N���O�ﹳ�W�[��D���O��
                        validate(); // ��s����
                        jp2.showPage(page); // ��ܸӭ�PDF���
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
            if (isDragged) {// �b���ƥ󤤤��_�O�U�M���ܦ�m
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
            // TODO �۰ʲ��ͫغc��Ʀs��
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