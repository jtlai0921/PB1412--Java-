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
     * 遞歸檢查磁碟檔案夾的方法
     * 
     * @param driver
     */
    private void listTempFiles(File driver) {
        // 獲得指定磁碟或檔案夾的子列表
        File[] files = driver.listFiles(tempFileFilter);
        if (files == null)
            return;
        progressBar.setIndeterminate(true);// 設定進度條以不確定方式捲動
        for (File file : files) {// 檢查檔案陣列
            progressBar.setString(file.toString());// 進度條顯示搜索檔案夾
            if (file.isFile() && searching) {// 處理檔案
                tableModel.addRow(new Object[] { file.getName(), file,
                        file.length(), "未處理" });// 增加檔案資訊到表格控制項
            } else if (file.isDirectory() && searching) {// 處理檔案夾
                listTempFiles(file);// 遞歸方法檢查檔案夾
            }
        }
        progressBar.setIndeterminate(false);// 停止進度條
        progressBar.setString("搜索完成");// 提示搜索完成
    }
}
