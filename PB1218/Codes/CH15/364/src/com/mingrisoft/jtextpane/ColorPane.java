package com.mingrisoft.jtextpane;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class ColorPane extends JTextPane {
    private static final long serialVersionUID = 7039422656649417533L;
    
    public void append(Color color, String key) {
        StyleContext context = StyleContext.getDefaultStyleContext();
        AttributeSet style = context.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        int length = getText().length();
        setCaretPosition(length);
        setCharacterAttributes(style, true);
        replaceSelection(key);
    }
    
}
