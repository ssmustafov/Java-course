package com.sirma.itt.javacourse.gui.downloadagent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Holds method for downloading file from http url.
 * 
 * @author Sinan
 */
public class DownloadAgent {
	private InputStream inputStream = null;
	private URLConnection urlConnection = null;
	private int contentLength = 0;

	/**
	 * Downloads a file from given url.
	 * 
	 * @param downloadUrl
	 *            - the url from to download
	 * @throws IOException
	 *             - thrown when I/O error occurs
	 */
	public void downloadFile(String downloadUrl) throws IOException {
		URL url = new URL(downloadUrl);
		urlConnection = url.openConnection();
		contentLength = urlConnection.getContentLength();

		inputStream = urlConnection.getInputStream();
	}

	/**
	 * Closes the connection to the url.
	 * 
	 * @throws IOException
	 *             - thrown when I/O exception occurs
	 */
	public void closeConnection() throws IOException {
		if (inputStream != null) {
			inputStream.close();
		}
		if (urlConnection != null) {
			urlConnection = null;
		}
		contentLength = 0;
	}

	/**
	 * Returns the {@code InputStream} of the connection to the file.
	 * 
	 * @return - the {@code InputStream} of the connection to the file
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * Returns the length of the file that will be download.
	 * 
	 * @return - the length of the file that will be download
	 */
	public int getContentLength() {
		return contentLength;
	}
}
