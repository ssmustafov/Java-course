package com.sirma.itt.javacourse.gui.downloadagent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Holds methods for downloading file from http.
 * 
 * @author smustafov
 */
public final class DownloadAgent {
	private static final int BUFFER_SIZE = 4096;

	/**
	 * Protects from instantiation.
	 */
	private DownloadAgent() {
	}

	/**
	 * Downloads a given file from http url.
	 * 
	 * @param urlAsString
	 *            - url from which to download
	 * @param filename
	 *            - the filename in which to download
	 * @throws IOException
	 *             - exception
	 */
	public static void downloadFile(String urlAsString, String filename) throws IOException {
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;

		try {
			URL url = new URL(urlAsString);
			URLConnection urlConnection = url.openConnection();
			inputStream = urlConnection.getInputStream();
			fileOutputStream = new FileOutputStream(filename);

			byte[] data = new byte[BUFFER_SIZE];
			int bytesTransferred;

			while ((bytesTransferred = inputStream.read(data, 0, BUFFER_SIZE)) != -1) {
				fileOutputStream.write(data, 0, bytesTransferred);
				fileOutputStream.flush();
			}
			System.out.println("Finished");
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (fileOutputStream != null) {
				fileOutputStream.close();
			}
		}
	}

}