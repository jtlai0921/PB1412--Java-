package com.lzw.ip;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CText extends JTextField {
    public CText() {
        setBorder(null);// 取消邊框
        setHorizontalAlignment(SwingConstants.CENTER);// 文字居中
        setFont(getFont().deriveFont(16f));// 色繪製預設16號字體
        addKeyListener(new KeyAdapter() {// 增加按鍵事件監聽器
            @Override
            public void keyTyped(KeyEvent e) {
                if (("0123456789" + (char) 8).indexOf(e.getKeyChar()) < 0) {
                    e.consume();// 屏蔽非數字與回復鍵的輸入
                    return;
                }
                if (e.getKeyChar() == (char) 8) {
                    return;// 屏蔽回復鍵
                }
                String text = getText() + e.getKeyChar();// 獲得最新輸入
                if (!text.isEmpty()) {// 如果輸入非空
                    int value = Integer.parseInt(text);// 把輸入解析為整數
                    if (value > 225) {// 如果整數大於225
                        e.consume();// 取消本次輸入
                        return;
                    }
                }
                // 如果輸入文字過長或輸入的是dot字符
                if (getText().length() > 2 || e.getKeyChar() == '.') {
                    e.consume();// 取消本次輸入
                    transferFocus();// 把輸入焦點傳遞給下一個控制項
                    return;
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // 屏蔽貼上快速鍵
                if (e.getKeyCode() == KeyEvent.VK_V && e.isControlDown()) {
                    e.consume();
                }
            }
        });
    }
    
    /**
     * 獲得輸入整數值的方法
     * 
     * @return
     */
    public int getInt() {
        String text = getText();// 獲得輸入文字
        if (text.isEmpty())// 屏蔽空輸入
            return 0;
        int value = Integer.parseInt(text);// 解析輸入為整數
        return value;
    }
    
    @Override
    public String toString() {
        return getInt() + "";
    }
    
}
