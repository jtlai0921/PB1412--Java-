package com.mingrisoft.thread;

import java.util.Random;

import javax.swing.JTextArea;

public class Philosopher implements Runnable {
    
    private int id;
    private ChopstickArray chopstickArray;
    private boolean state;
    private JTextArea thinkingTextArea;
    private JTextArea eatingTextArea;
    private JTextArea waitingTextArea;
    
    public Philosopher(int id, ChopstickArray chopstickArray, JTextArea thinkingTextArea, JTextArea eatingTextArea, JTextArea waitingTextArea) {
        this.id = id;
        this.chopstickArray = chopstickArray;
        this.thinkingTextArea = thinkingTextArea;
        this.eatingTextArea = eatingTextArea;
        this.waitingTextArea = waitingTextArea;
    }
    
    public synchronized void thinking() {
        if (state) {
            chopstickArray.get(id).setAvailable(true);
            chopstickArray.getLast(id).setAvailable(true);
            String text = thinkingTextArea.getText();
            thinkingTextArea.setText(text + this + " 在思考\n");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state = false;
    }
    
public synchronized void eating() {
    if (!state) {// state是一個布爾值，true表示哲學家剛才的狀態是吃飯，false表示思考
        if (chopstickArray.get(id).isAvailable()) {// 如果哲學家右手邊的筷子可用
            if (chopstickArray.getLast(id).isAvailable()) {// 如果哲學家左手邊的筷子可用
                chopstickArray.get(id).setAvailable(false);// 設定右手筷子不可用
                chopstickArray.getLast(id).setAvailable(false);// 設定左手筷子不可用
                String text = eatingTextArea.getText();
                eatingTextArea.setText(text + this + " 在吃飯\n");// 顯示哲學家在吃飯
                try {
                    Thread.sleep(100);// 吃飯時間設定成0.1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {// 如果哲學家左手邊的筷子不可用，就在對應的文字域中顯示等待資訊
                String text = waitingTextArea.getText();
                waitingTextArea.setText(text + this + " 在等待 " + chopstickArray.getLast(id) + "\n");
                try {
                    wait(new Random().nextInt(100));// 等待小於0.1秒時間後檢查筷子是否可用
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {// 如果哲學家右手邊的筷子不可用，就在對應的文字域中顯示等待資訊
            String text = waitingTextArea.getText();
            waitingTextArea.setText(text + this + " 在等待 " + chopstickArray.get(id) + "\n");
            try {
                wait(new Random().nextInt(100));// 等待小於0.1秒時間後檢查筷子是否可用
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    state = true;// 設定state的值為true表示哲學家的狀態是吃飯
}
    
    @Override
    public void run() {
        
        for (int i = 0; i < 10; i++) {
            thinking();
            eating();
        }
    }
    
    @Override
    public String toString() {
        return " 哲學家 " + id;
    }
    
}
