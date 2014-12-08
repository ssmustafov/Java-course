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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * Represents a UI for download agent.
 * 
 * @author Sinan
 */
public class DownloadView extends JFrame implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Download agent";
	private JTextField urlField;
	private JFileChooser fileChooser;
	private JButton saveButton;
	private JButton startButton;
	private JProgressBar progressBar;
	private String pathToFile = "";

	/**
	 * Creates a new download UI.
	 */
	public DownloadView() {
		super(WINDOW_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		JLabel label = new JLabel("Enter URL:");
		urlField = new JTextField(25);
		fileChooser = new JFileChooser();

		saveButton = new JButton("Browse...");
		saveButton.addActionListener(this);

		startButton = new JButton("Download");
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
			int returnVal = fileChooser.showSaveDialog(DownloadView.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				pathToFile = file.getPath();
			}
		} else {

			String downloadUrl = urlField.getText();

			if (downloadUrl.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please enter URL from which to download!",
						"Error", JOptionPane.ERROR_MESSAGE);
				urlField.requestFocus();
				return;
			}
			if (pathToFile.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please choose a path to a file!", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			try {
				DownloadTask task = new DownloadTask(this, downloadUrl, pathToFile);
				task.addPropertyChangeListener(this);
				task.execute();
				urlField.setEditable(false);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error downloading: " + ex.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if ("progress".equals(e.getPropertyName())) {
			int progress = (Integer) e.getNewValue();
			progressBar.setValue(progress);

			if (progress == 100) {
				urlField.setEditable(true);
			}
		}
	}

}
