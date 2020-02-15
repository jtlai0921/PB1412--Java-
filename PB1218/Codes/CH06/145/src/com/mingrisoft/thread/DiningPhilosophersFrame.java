package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class DiningPhilosophersFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9072333459039474643L;
	private JPanel contentPane;
	private JTextArea thinkingTextArea;
	private JTextArea eatingTextArea;
	private JTextArea waitingTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	    } catch (Throwable e) {
	        e.printStackTrace();
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiningPhilosophersFrame frame = new DiningPhilosophersFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DiningPhilosophersFrame() {
		setTitle("­õ¾Ç®a´NÀ\°ÝÃD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel labelPanel = new JPanel();
		contentPane.add(labelPanel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("ª¬ºA");
		label.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		labelPanel.add(label);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton startButton = new JButton("¶}©l¹B¦æ");
		startButton.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_startButton_actionPerformed(arg0);
			}
		});
		buttonPanel.add(startButton);
		
		JPanel statePanel = new JPanel();
		contentPane.add(statePanel, BorderLayout.CENTER);
		statePanel.setLayout(new GridLayout(1, 3, 5, 5));
		
		JPanel thinkingPanel = new JPanel();
		statePanel.add(thinkingPanel);
		thinkingPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel thinkingLabel = new JLabel("«ä¦Ò");
		thinkingLabel.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 14));
		thinkingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thinkingPanel.add(thinkingLabel, BorderLayout.NORTH);
		
		JScrollPane thinkingScrollPane = new JScrollPane();
		thinkingPanel.add(thinkingScrollPane, BorderLayout.CENTER);
		
		thinkingTextArea = new JTextArea();
		thinkingTextArea.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 12));
		thinkingScrollPane.setViewportView(thinkingTextArea);
		
		JPanel eatingPanel = new JPanel();
		statePanel.add(eatingPanel);
		eatingPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel eatingLabel = new JLabel("´NÀ\");
		eatingLabel.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 14));
		eatingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eatingPanel.add(eatingLabel, BorderLayout.NORTH);
		
		JScrollPane eatingScrollPane = new JScrollPane();
		eatingPanel.add(eatingScrollPane, BorderLayout.CENTER);
		
		eatingTextArea = new JTextArea();
		eatingTextArea.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 12));
		eatingScrollPane.setViewportView(eatingTextArea);
		
		JPanel waitingPanel = new JPanel();
		statePanel.add(waitingPanel);
		waitingPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel waitingLabel = new JLabel("µ¥«Ý");
		waitingLabel.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 14));
		waitingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		waitingPanel.add(waitingLabel, BorderLayout.NORTH);
		
		JScrollPane waitingScrollPane = new JScrollPane();
		waitingPanel.add(waitingScrollPane, BorderLayout.CENTER);
		
		waitingTextArea = new JTextArea();
		waitingTextArea.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 12));
		waitingScrollPane.setViewportView(waitingTextArea);
	}

	protected void do_startButton_actionPerformed(ActionEvent arg0) {
		ChopstickArray chopstickArray = new ChopstickArray(5);
		for(int i=0;i<5;i++) {
			new Thread(new Philosopher(i, chopstickArray, thinkingTextArea, eatingTextArea, waitingTextArea)).start();
		}
	}
}
