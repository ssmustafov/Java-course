package com.sirma.itt.javacourse.inputoutput.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Holds methods for serializing and deserializing objects.
 * 
 * @author smustafov
 */
public class DataClass {

	/**
	 * Serializes given object in given file name.
	 * 
	 * @param path
	 *            - the full path to file in to be serialized the object
	 * @param obj
	 *            - the object to be serialized
	 * @throws IOException
	 *             - if it can't close the stream throws the exception
	 */
	public void saveObject(String path, Object obj) throws IOException {
		ObjectOutputStream objectOutputStream = null;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(obj);
		} finally {
			if (objectOutputStream != null) {
				objectOutputStream.close();
			}
		}
	}

	/**
	 * Deserializes object from given file.
	 * 
	 * @param path
	 *            - the full path to file from which to be deserialize the object
	 * @return - the deserialized object
	 * @throws IOException
	 *             - if the given path doesn't exists throws the exception
	 * @throws ClassNotFoundException
	 *             - if it can't read the object throws teh exception
	 */
	public Object getObject(String path) throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			objectInputStream = new ObjectInputStream(fileInputStream);
			return objectInputStream.readObject();
		} finally {
			if (objectInputStream != null) {
				objectInputStream.close();
			}
		}
	}

}
