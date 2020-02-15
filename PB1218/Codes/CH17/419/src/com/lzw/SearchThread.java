package com.lzw;

import java.io.File;
import java.io.FileFilter;

import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

public class SearchThread extends Thread {
    class TempFileFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            if (pathname.getName().endsWith(".tmp") || pathname.isDirectory())
                return true;
            return false;
        }
    }
    
    private File driver;
    private DefaultTableModel tableModel;
    private boolean searching = true;
    
    public boolean isSearching() {
        return searching;
    }
    
    public void setSearching(boolean searching) {
        this.searching = searching;
    }
    
    private TempFileFilter tempFileFilter = new TempFileFilter();
    private JProgressBar progressBar;
    
    public SearchThread(File driver, DefaultTableModel tableModel,
            JProgressBar progressBar) {
        this.driver = driver;
        this.tableModel = tableModel;
        progressBar.setStringPainted(true);
        this.progressBar = progressBar;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    public void run() {
        if (driver != null)
            listTempFiles(driver);
    }
    
    /**
     * ���k�ˬd�Ϻ��ɮק�����k
     * 
     * @param driver
     */
    private void listTempFiles(File driver) {
        // ��o���w�ϺЩ��ɮק����l�C��
        File[] files = driver.listFiles(tempFileFilter);
        if (files == null)
            return;
        progressBar.setIndeterminate(true);// �]�w�i�ױ��H���T�w�覡����
        for (File file : files) {// �ˬd�ɮװ}�C
            progressBar.setString(file.toString());// �i�ױ���ܷj���ɮק�
            if (file.isFile() && searching) {// �B�z�ɮ�
                tableModel.addRow(new Object[] { file.getName(), file,
                        file.length(), "���B�z" });// �W�[�ɮ׸�T���汱�
            } else if (file.isDirectory() && searching) {// �B�z�ɮק�
                listTempFiles(file);// ���k��k�ˬd�ɮק�
            }
        }
        progressBar.setIndeterminate(false);// ����i�ױ�
        progressBar.setString("�j������");// ���ܷj������
    }
}
