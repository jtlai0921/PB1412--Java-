package com.mingrisoft.jtextpane;

import java.awt.Color;
import java.util.Stack;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class ParenthesisMatcher extends JTextPane {
    
    private static final long serialVersionUID = -5040590165582343011L;
    private AttributeSet mismatch;
    private AttributeSet match;
    
    public ParenthesisMatcher() {
        StyleContext context = StyleContext.getDefaultStyleContext();
        mismatch = context.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);
        match = context.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
    }
    
    public void validate() {
        StyledDocument document = getStyledDocument();
        String text = null;
        try {
            text = document.getText(0, document.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push("" + c + i);
                document.setCharacterAttributes(i, 1, match, false);
            }
            if (c == ')' || c == ']' || c == '}') {
                String peek = stack.empty() ? "." : (String) stack.peek();
                if (match(peek.charAt(0), c)) {
                    stack.pop();
                    document.setCharacterAttributes(i, 1, match, false);
                } else {
                    document.setCharacterAttributes(i, 1, mismatch, false);
                }
            }
        }
        
        while (!stack.empty()) {
            String pop = (String) stack.pop();
            int offset = Integer.parseInt(pop.substring(1));
            document.setCharacterAttributes(offset, 1, mismatch, false);
        }
    }
    
    @Override
    public void replaceSelection(String content) {
        getInputAttributes().removeAttribute(StyleConstants.Foreground);
        super.replaceSelection(content);
    }
    
    private boolean match(char left, char right) {
        if ((left == '(') && (right == ')')) {
            return true;
        }
        if ((left == '[') && (right == ']')) {
            return true;
        }
        if ((left == '{') && (right == '}')) {
            return true;
        }
        return false;
    }
}
