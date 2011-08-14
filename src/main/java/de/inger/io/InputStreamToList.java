package de.inger.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Converts input stream into list of strings. 
 * 
 * @author Igor Inger
 *
 */
public abstract class InputStreamToList {

	protected InputStreamToList() {		
	}
	
	/**
	 * Converts input stream with given charset into list of strings.
	 * 
	 * @param stream input stream
	 * @param charsetName charset name
	 * @return list of strings
	 * @throws IOException if any I/O error occurs
	 */
	public static List<String> read(InputStream stream, String charsetName) throws IOException {
		return read(stream, Charset.forName(charsetName));
	}
	
	/**
	 * Converts input stream with default charset into list of strings.
	 * 
	 * @param stream input stream
	 * @return list of string
	 * @throws IOException if any I/O error occurs
	 */
	public static List<String> read(InputStream stream) throws IOException {
		return read(stream, Charset.defaultCharset());
	}
	
	/**
	 * Converts input stream with given charset into list of strings.
	 * 
	 * @param stream input stream
	 * @param charset charset
	 * @return list of strings
	 * @throws IOException if any I/O error occurs
	 */
	public static List<String> read(InputStream stream, Charset charset) throws IOException {
		List<String> result = new ArrayList<String>();
		InputStreamReader inputStreamReader = new InputStreamReader(stream, charset);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			result.add(line);
		}
		bufferedReader.close();
		inputStreamReader.close();
		return result;
	}

}
