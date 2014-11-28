package com.sirma.itt.javacourse.gui.downloadagent;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * @author smustafov
 */
public class DownloadUI extends JFrame implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Download agent";
	private JTextField urlField;
	private JFileChooser fileChooser;
	private JButton saveButton;
	private JButton startButton;
	private JProgressBar progressBar;
	private Task task;

	public DownloadUI() {
		super(WINDOW_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		JLabel label = new JLabel("Enter URL:");
		urlField = new JTextField(25);
		fileChooser = new JFileChooser();

		saveButton = new JButton("Save to...");
		saveButton.addActionListener(this);

		startButton = new JButton("Start downloading");
		startButton.addActionListener(this);

		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(label);
		buttonPanel.add(urlField);
		buttonPanel.add(saveButton);
		buttonPanel.add(startButton);

		add(buttonPanel, BorderLayout.PAGE_START);
		add(progressBar, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveButton) {
			int returnVal = fileChooser.showSaveDialog(DownloadUI.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				System.out.println(file.getPath());
				// This is where a real application would save the file.
				// log.append("Saving: " + file.getName() + "." + newline);
			}
		} else if (e.getSource() == startButton) {
			task = new Task();
			task.addPropertyChangeListener(this);
			task.execute();
		}
	}

	public static void main(String[] args) {
		new DownloadUI();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if ("progress".equals(e.getPropertyName())) {
			int progress = (Integer) e.getNewValue();
			progressBar.setValue(progress);
		}
	}
}
