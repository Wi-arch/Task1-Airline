package by.education.airline.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	private Reader() {
	}

	private static class ReaderInstanse {
		private final static Reader INSTANCE = new Reader();
	}

	public static Reader getInstance() {
		return ReaderInstanse.INSTANCE;
	}

	public String readStringFromFile(String path) {

		StringBuilder result = new StringBuilder();

		File file = new File(path);
		if (!file.exists()) {
			// TODO write log
			throw new RuntimeException("File " + path + " not found");
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line = reader.readLine();
			while (line != null) {
				result.append(line + "\r\n");
				line = reader.readLine();
			}

		} catch (IOException e) {
			// TODO write log
		}
		return result.toString();
	}

}
