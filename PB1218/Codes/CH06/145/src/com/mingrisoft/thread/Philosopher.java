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
            thinkingTextArea.setText(text + this + " �b���\n");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state = false;
    }
    
public synchronized void eating() {
    if (!state) {// state�O�@�ӥ����ȡAtrue��ܭ��Ǯa��~�����A�O�Y���Afalse��ܫ��
        if (chopstickArray.get(id).isAvailable()) {// �p�G���Ǯa�k���䪺�_�l�i��
            if (chopstickArray.getLast(id).isAvailable()) {// �p�G���Ǯa�����䪺�_�l�i��
                chopstickArray.get(id).setAvailable(false);// �]�w�k��_�l���i��
                chopstickArray.getLast(id).setAvailable(false);// �]�w����_�l���i��
                String text = eatingTextArea.getText();
                eatingTextArea.setText(text + this + " �b�Y��\n");// ��ܭ��Ǯa�b�Y��
                try {
                    Thread.sleep(100);// �Y���ɶ��]�w��0.1��
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {// �p�G���Ǯa�����䪺�_�l���i�ΡA�N�b��������r�줤��ܵ��ݸ�T
                String text = waitingTextArea.getText();
                waitingTextArea.setText(text + this + " �b���� " + chopstickArray.getLast(id) + "\n");
                try {
                    wait(new Random().nextInt(100));// ���ݤp��0.1��ɶ����ˬd�_�l�O�_�i��
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {// �p�G���Ǯa�k���䪺�_�l���i�ΡA�N�b��������r�줤��ܵ��ݸ�T
            String text = waitingTextArea.getText();
            waitingTextArea.setText(text + this + " �b���� " + chopstickArray.get(id) + "\n");
            try {
                wait(new Random().nextInt(100));// ���ݤp��0.1��ɶ����ˬd�_�l�O�_�i��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    state = true;// �]�wstate���Ȭ�true��ܭ��Ǯa�����A�O�Y��
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
        return " ���Ǯa " + id;
    }
    
}
