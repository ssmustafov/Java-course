package com.sirma.itt.javacourse.gui.downloadagent;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.Random;

import javax.swing.SwingWorker;

/**
 * @author smustafov
 */
public class Task extends SwingWorker<Void, Void> {
	private String url;
	private String path;

	/**
	 * Ads.
	 * 
	 * @param url
	 *            - url
	 * @param path
	 *            - path
	 */
	public Task(String url, String path) {
		this.url = url;
		this.path = path;
	}

	/*
	 * Main task. Executed in background thread.
	 */
	@Override
	public Void doInBackground() {
		try {
			DownloadAgent.downloadFile(url, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Random random = new Random();
		int progress = 0;
		// Initialize progress property.
		setProgress(0);
		while (progress < 100) {
			// Sleep for up to one second.
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException ignore) {
			}
			// Make random progress.
			progress += random.nextInt(10);
			setProgress(Math.min(progress, 100));
		}
		return null;
	}

	/*
	 * Executed in event dispatching thread
	 */
	@Override
	public void done() {
		Toolkit.getDefaultToolkit().beep();
	}
}
