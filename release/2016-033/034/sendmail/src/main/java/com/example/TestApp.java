package com.example;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class TestApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestApp window = new TestApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton exxls = new JButton("导出Excel");
		exxls.setAction(action);
		exxls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exxls.setBounds(200, 41, 117, 25);
		frame.getContentPane().add(exxls);
		
		JButton button = new JButton("整合图片");
		button.setBounds(49, 69, 117, 25);
		frame.getContentPane().add(button);
	}

}
