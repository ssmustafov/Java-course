package com.sirma.itt.javacourse.gui.downloadagent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Downloads a file in a background thread. Extends {@code SwingWorker}.
 * 
 * @author Sinan
 */
public class DownloadTask extends SwingWorker<Void, Void> {
	private static final Logger LOGGER = LogManager.getLogger(DownloadTask.class);
	private static final int BUFFER_SIZE = 4096;
	private String downloadUrl;
	private String pathToFile;
	private DownloadView view;

	/**
	 * Creates a new download task with given view, http url from to download and path to a file to
	 * be saved.
	 * 
	 * @param view
	 *            - the ui of the download agent
	 * @param downloadUrl
	 *            - http url from to download
	 * @param pathToFile
	 *            - path to a file where the downloaded file to be saved
	 */
	public DownloadTask(DownloadView view, String downloadUrl, String pathToFile) {
		this.view = view;
		this.downloadUrl = downloadUrl;
		this.pathToFile = pathToFile;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Void doInBackground() {
		FileOutputStream outputStream = null;
		DownloadAgent downloadAgent = null;

		try {
			downloadAgent = new DownloadAgent();
			downloadAgent.downloadFile(downloadUrl);

			InputStream inputStream = downloadAgent.getInputStream();

			outputStream = new FileOutputStream(pathToFile);

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			int percentCompleted = 0;
			long totalBytesRead = 0;
			long fileSize = downloadAgent.getContentLength();

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
				outputStream.flush();

				totalBytesRead += bytesRead;

				percentCompleted = (int) (totalBytesRead * 100 / fileSize);
				setProgress(percentCompleted);
			}
		} catch (IOException ioException) {
			JOptionPane.showMessageDialog(view,
					"Error downloading file: " + ioException.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			setProgress(0);
			cancel(true);
			LOGGER.error(ioException.getMessage(), ioException);
		} finally {
			try {
				if (downloadAgent != null) {
					downloadAgent.closeConnection();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void done() {
		if (!isCancelled()) {
			JOptionPane.showMessageDialog(view, "File has been downloaded successfully!",
					"Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
