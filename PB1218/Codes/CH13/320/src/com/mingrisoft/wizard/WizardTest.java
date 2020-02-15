package com.mingrisoft.wizard;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import jwizardcomponent.DefaultJWizardComponents;
import jwizardcomponent.Utilities;
import jwizardcomponent.example.SimpleLabelWizardPanel;
import jwizardcomponent.frame.SimpleLogoJWizardFrame;

public class WizardTest {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SimpleLogoJWizardFrame frame = new SimpleLogoJWizardFrame(new ImageIcon("src/image/logo.jpg"));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("²�檺�n��w���Q��");
            
            DefaultJWizardComponents components = frame.getWizardComponents();
            JLabel label1 = new JLabel("�n��w�˲Ĥ@�B");
            label1.setFont(new Font("�L�n����", Font.PLAIN, 20));
            JLabel label2 = new JLabel("�n��w�˲ĤG�B");
            label2.setFont(new Font("�L�n����", Font.PLAIN, 20));
            JLabel label3 = new JLabel("�n��w�˲ĤT�B");
            label3.setFont(new Font("�L�n����", Font.PLAIN, 20));
            
            SimpleLabelWizardPanel panel1 = new SimpleLabelWizardPanel(components, label1);
            components.addWizardPanel(panel1);
            
            SimpleLabelWizardPanel panel2 = new SimpleLabelWizardPanel(components, label2);
            components.addWizardPanel(panel2);
            
            SimpleLabelWizardPanel panel3 = new SimpleLabelWizardPanel(components, label3);
            components.addWizardPanel(panel3);
            
            frame.setSize(450, 300);
            frame.setVisible(true);
            Utilities.centerComponentOnScreen(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
