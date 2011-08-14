package de.inger.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Converter from InputStream to String.
 * 
 * @author Igor Inger
 * 
 */
public class InputStreamToString {

	private static final int BUFFER_SIZE = 1024;

	/**
	 * Protected constructor
	 */
	protected InputStreamToString() {
	}

	/**
	 * Read input stream into a string.
	 * 
	 * @param stream
	 *            input stream
	 * @return converted string
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static String read(InputStream stream) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		InputStreamReader reader = new InputStreamReader(stream);
		char[] buffer = new char[BUFFER_SIZE];
		int length = 0;
		while ((length = reader.read(buffer)) != -1) {
			stringBuffer.append(buffer, 0, length);
		}
		return stringBuffer.toString();
	}

	/**
	 * Read input stream into a string.
	 * 
	 * @param stream
	 *            input stream.
	 * @param charsetName
	 *            the name of a charset
	 * @return converted string
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static String read(InputStream stream, String charsetName) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		InputStreamReader reader = new InputStreamReader(stream, charsetName);
		char[] buffer = new char[BUFFER_SIZE];
		int length = 0;
		while ((length = reader.read(buffer)) != -1) {
			stringBuffer.append(buffer, 0, length);
		}
		return stringBuffer.toString();
	}

}
